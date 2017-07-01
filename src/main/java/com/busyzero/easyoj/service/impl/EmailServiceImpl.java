package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.enums.AccountOperateEnum;
import com.busyzero.easyoj.service.EmailService;
import com.busyzero.easyoj.utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

/**
 * Created by 11456 on 2017/6/23.
 */
@Service
public class EmailServiceImpl implements EmailService {
    /**日志对象*/
    private Logger logger= LoggerFactory.getLogger(EmailServiceImpl.class);

    /**解析路径*/
    private static final String EMAIL_SIMPLE_TEMPLATE_NAME="html/signUpAuthMail";

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
        //生成一个加密的字符串accessKey
        String accessKey=EncryptionUtils.accountAccessKeyEncryption(account.getEmailAddress());
        //发送一封邮件，并且这代这个信息
        String accessUrl="http://localhost:8888/?accessKey="+accessKey;
        final Context ctx=new Context(locale);
        String username=account.getFirstName()+" "+account.getLastName();
        ctx.setVariable("username",username);
        ctx.setVariable("paragraph1","欢迎你加入EasyOJ俱乐部");
        ctx.setVariable("paragraph2",accessUrl);

        final MimeMessage mimeMessage=this.mailSender.createMimeMessage();
        final MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setSubject("EasyOJ账号邮箱验证");
            helper.setFrom("1145690747@qq.com");
            helper.setTo(account.getEmailAddress());

            final String htmlContent=this.htmlTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);
            helper.setText(htmlContent,true);
            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.info("send email auth have a error:"+e.getMessage());
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"发送邮件出现错误");
        }
        return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,true);
    }

    /**
     * 密码找回功能时候需要发送的邮箱验证：
     * 具体步骤是先发送一封邮件，邮件中带有一个路径，路径指向一个修改密码的地方
     * 然后就需要修改密码
     * @param username
     * @param emailAddress
     * @param locale
     * @return
     */
    @Override
    public AccountOperateResult passwordForgot(String username, String emailAddress,Locale locale) {
        return null;
    }

}
