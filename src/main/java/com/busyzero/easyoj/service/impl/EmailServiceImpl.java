package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.commons.exception.BusinessException;
import com.busyzero.easyoj.commons.exception.ExceptionCodeEnum;
import com.busyzero.easyoj.commons.result.ResultVO;
import com.busyzero.easyoj.config.common.ConfigConstantsPool;
import com.busyzero.easyoj.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 这是邮件服务
 * 主要是为用户邮箱认证以及其它通知或者什么提供支持
 * {@link AccountAuthService}
 * Created by 11456 on 2017/6/23.
 */
@Service
public class EmailServiceImpl implements EmailService {
    private final Logger logger= LoggerFactory.getLogger(EmailServiceImpl.class);

    /**邮件发送器*/
    @Autowired
    private JavaMailSender mailSender;

    /**邮件模板引擎*/
    @Qualifier(value = "emailTemplateEngine")
    @Autowired
    private TemplateEngine htmlTemplateEngine;


    /**
     * 发送邮件
     * @param subject 主题
     * @param mailFrom 发送邮件来源
     * @param mailTo 发送邮件目的地
     * @return
     */
    private ResultVO<Boolean> sendMailMessage(ResultVO<Boolean> result,
                                              String subject,
                                              String mailFrom,
                                              String mailTo,
                                              String htmlTemplete,
                                              final Context ctx){
        final MimeMessage mimeMessage=this.mailSender.createMimeMessage();
        final MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage,true, ConfigConstantsPool.CHARACTER_ENCODING);
            helper.setSubject(subject);
            helper.setFrom(mailFrom);
            helper.setTo(mailTo);

            final String htmlContent=this.htmlTemplateEngine.process(htmlTemplete, ctx);
            helper.setText(htmlContent,true);
            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.info("send email  have a error:"+e.getMessage());
            result.fail(new BusinessException(ExceptionCodeEnum.MAIL_SEND_ERROR));
        }
        return result;
    }

    /**
     * 邮箱绑定
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    @Override
    public ResultVO<Boolean> sendEmailBindVerification(ResultVO<Boolean> result, String emailAddress, Context context) {
        String subject = "注册邮箱验证";
        String mailFrom = "easyOJ开发团队";
        String htmlTemplate = "mail/signUpAuhMail.html";
        sendMailMessage(result,subject,mailFrom,emailAddress,htmlTemplate,context);
        return result;
    }

    @Override
    public ResultVO<Boolean> sendEmailUnbundVerification(ResultVO<Boolean> result, String emailAddress, Context context) {
        String subject = "解绑邮箱验证";
        String mailFrom = "easyOJ开发团队";
        String htmlTemplate = "mail/signUpAuhMail.html";
        sendMailMessage(result,subject,mailFrom,emailAddress,htmlTemplate,context);
        return result;
    }

    @Override
    public ResultVO<Boolean> sendNumberVerification(ResultVO<Boolean> result, String emailAddress, String number, Context context) {
        String subject = "验证码";
        String mailFrom = "easyOJ开发团队";
        String htmlTemplate = "mail/signUpAuhMail.html";
        sendMailMessage(result,subject,mailFrom,emailAddress,htmlTemplate,context);
        return result;
    }

    @Override
    public ResultVO<Boolean> sendDirectMail(ResultVO<Boolean> result, String emailAddress) {
        return null;
    }

    @Override
    public ResultVO<Boolean> sendCourseInfoMail(ResultVO<Boolean> result, String emailAddress) {
        return null;
    }


//
//    /**
//     * 先将数据对象缓存到缓存中，并且定时时间为12小时
//     * 然后生成一个密钥并创建一个邮件发送出去，里面包含连接和密约
//     * @param account
//     * @return
//     */
//    @Override
//    public AccountOperateResult emailAddressSignUp(AccountInfo account, Locale locale) {
//        //因为查看是否有人已经注册是之前已经校验，不在继续做
//        //生成一个加密的字符串accessKey,并且缓存进去24个小时
//        String accessKey=EncryptionUtils.accountAccessKeyEncryption(account.getEmailAddress());
//        String key=SIGN_UP_ACCESSKEY_CACHE_KEY_PREFIX+account.getEmailAddress();
//        redisTemplate.opsForValue().set(key,accessKey);
//        redisTemplate.expire(key,24, TimeUnit.HOURS);
//        //将对象缓存到redis 中，并设置有效时间是24小时
//        String accountObjKey=SIGN_UP_OBJECT_CACHE_KEY_PREFFIX+account.getEmailAddress();
//        redisTemplate.opsForValue().set(accountObjKey,account);
//        redisTemplate.expire(accountObjKey,24, TimeUnit.HOURS);
//        //发送一封邮件，并且这代这个信息
//        String accessUrl="http://localhost:8888/?accessKey="+accessKey;
//        String username=account.getFirstName()+" "+account.getLastName();
//        String[] messages={"欢迎你加入EasyOJ俱乐部",linkUrl};
//        String subject="注册邮箱验证";
//        AccountOperateResult result=sendMessage(locale,username,subject,messages,account.getEmailAddress());
//        return result;
//    }
//
//    /**
//     * 密码找回功能时候需要发送的邮箱验证：
//     * 具体步骤是先发送一封邮件，邮件中带有一个路径，路径指向一个修改密码的地方
//     * 然后就需要a修改密码
//     * @param emailAddress
//     * @param locale
//     * @return
//     */
//    @Override
//    public AccountOperateResult passwordReset(String emailAddress,Locale locale) {
//        String accessKey=EncryptionUtils.accountAccessKeyEncryption(emailAddress);
//        String passwordResetKey=PASSWORD_RESET_ACCESSKLEY_CACHE_KEY_PREFIX+emailAddress;
//        redisTemplate.opsForValue().set(passwordResetKey,accessKey);
//        redisTemplate.expire(passwordResetKey,24, TimeUnit.HOURS);
//        String accessUrl="http://localhost:8888/?accessKey="+accessKey;
//        String[] messages={"提示:您现在修改您的密码",accessUrl};
//        String username="";
//        String subject="找回密码邮箱验证";
//        AccountOperateResult result=sendMessage(locale,username,subject,messages,emailAddress);
//        return null;
//    }
//
//
//    /**
//     * 发送邮件
//     * @param locale 本地化对象
//     * @param username 用户名
//     * @param subject 主题
//     * @param paragraphs 段落
//     * @param mailTo 发送邮件目的地
//     * @return
//     */
//    public AccountOperateResult sendMessage(Locale locale,
//                                            String username,
//                                            String subject,
//                                            String[] paragraphs,
//                                            String mailTo){
//        String mailFrom ="1145690747@qq.com";
//        return sendMailMessage(locale,username,subject,paragraphs,mailFrom,mailTo);
//    }
}
