package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.enums.AccountOperateEnum;
import com.busyzero.easyoj.service.EmailService;
import com.busyzero.easyoj.utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by 11456 on 2017/6/23.
 */
@Service
public class EmailServiceImpl implements EmailService {
    /**日志对象*/
    private Logger logger= LoggerFactory.getLogger(EmailServiceImpl.class);

    private static final String EMAIL_SIMPLE_TEMPLATE_NAME="html/signUpAuthMail";

    /**缓存操作模板*/
    @Autowired
    private RedisTemplate redisTemplate;

    /**邮件发送器*/
    @Autowired
    private JavaMailSender mailSender;

    /**邮件模板引擎*/
    @Autowired
    private TemplateEngine htmlTemplateEngine;

    /**
     * 先将数据对象缓存到缓存中，并且定时时间为12小时
     * 然后生成一个密钥并创建一个邮件发送出去，里面包含连接和密约
     * @param account
     * @return
     */
    @Override
    public AccountOperateResult emailAddressSignUp(Account account,Locale locale) {
        //因为查看是否有人已经注册是之前已经校验，不在继续做
        //生成一个加密的字符串accessKey,并且缓存进去24个小时
        String accessKey=EncryptionUtils.accountAccessKeyEncryption(account.getEmailAddress());
        String key="sign-up.accessKey:"+account.getEmailAddress();
        redisTemplate.opsForValue().set(key,accessKey);
        redisTemplate.expire(key,24, TimeUnit.HOURS);
        //将对象缓存到redis 中，并设置有效时间是24小时
        String accountObjKey="accountObj:"+account.getEmailAddress();
        redisTemplate.opsForValue().set(accountObjKey,account);
        redisTemplate.expire(accountObjKey,24, TimeUnit.HOURS);
        //发送一封邮件，并且这代这个信息
        String accessUrl="http://localhost:8888/?accessKey="+accessKey;
        String username=account.getFirstName()+" "+account.getLastName();
        String[] messages={"欢迎你加入EasyOJ俱乐部",accessUrl};
        String subject="注册邮箱验证";
        AccountOperateResult result=sendMessage(locale,username,subject,messages,account.getEmailAddress());
        return result;
    }

    /**
     * 密码找回功能时候需要发送的邮箱验证：
     * 具体步骤是先发送一封邮件，邮件中带有一个路径，路径指向一个修改密码的地方
     * 然后就需要a修改密码
     * @param emailAddress
     * @param locale
     * @return
     */
    @Override
    public AccountOperateResult passwordReset(String emailAddress,Locale locale) {
        String accessKey=EncryptionUtils.accountAccessKeyEncryption(emailAddress);
        String passwordResetKey="PasswordResetKey:"+emailAddress;
        redisTemplate.opsForValue().set(passwordResetKey,accessKey);
        redisTemplate.expire(passwordResetKey,24, TimeUnit.HOURS);
        String accessUrl="http://localhost:8888/?accessKey="+accessKey;
        String[] messages={"您现在正在请求找回密码",accessUrl};
        String username="";
        String subject="找回密码邮箱验证";
        AccountOperateResult result=sendMessage(locale,username,subject,messages,emailAddress);
        //TODO 发送一个邮件
        return null;
    }

    /**
     * 发送邮件
     * @param locale 本地化对象
     * @param username 用户名
     * @param subject 主题
     * @param paragraphs 段落
     * @param mailTo 发送邮件目的地
     * @return
     */
    public AccountOperateResult sendMessage(Locale locale,
                                            String username,
                                            String subject,
                                            String[] paragraphs,
                                            String mailTo){
        String mailFrom ="1145690747@qq.com";
        return sendAccountMailMessage(locale,username,subject,paragraphs,mailFrom,mailTo);
    }

    /**
     * 发送邮件
     * @param locale 本地化对象
     * @param username 用户名
     * @param subject 主题
     * @param paragraphs 段落
     * @param mailFrom 发送邮件来源
     * @param mailTo 发送邮件目的地
     * @return
     */
    private AccountOperateResult sendAccountMailMessage(Locale locale,
                                                 String username,
                                                 String subject,
                                                 String[] paragraphs,
                                                 String mailFrom,
                                                 String mailTo){
        final Context ctx=new Context(locale);
        ctx.setVariable("username",username);
        for (int i=0;i<paragraphs.length;i++){
            ctx.setVariable("paragraph"+(i+1),paragraphs[i]);
        }
        final MimeMessage mimeMessage=this.mailSender.createMimeMessage();
        final MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setSubject(subject);
            helper.setFrom(mailFrom);
            helper.setTo(mailTo);

            final String htmlContent=this.htmlTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);
            helper.setText(htmlContent,true);
            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.info("send email auth have a error:"+e.getMessage());
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"发送邮件出现错误");
        }
        return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,true);
    }


}
