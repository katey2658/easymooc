package com.busyzero.easyoj.config.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by 11456 on 2017/4/10.
 */

/**
 * 邮件服务配置
 */
@Configuration
@PropertySource("classpath:mail.properties")
public class SpringMailConfig implements ApplicationContextAware,EnvironmentAware{

    public static final String EMAIL_TEMPLATE_ENCODING="UTF-8";

    private static final String MAIL_HOST="spring.mail.server.host";
    private static final String MAIL_PORT="spring.mail.server.port";
    private static final String MAIL_PROTOCOL="spring.mail.server.protocol";
    private static final String MAIL_USERNAME="spring.mail.server.username";
    private static final String MAIL_PASSWORD="spring.mail.server.password";
    private static final String MAIL_PROPERTIES_SMTP_AUTH="spring.mail.properties.mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE="spring.mail.properties.mail.smtp.starttls.enable";
    private static final String MAIL_SMTP_STARTTLS_REQUIRED="spring.mail.properties.mail.smtp.starttls.required";
    private static final String KEY_SMTP_STARTTLS_ENABLE="mail.smtp.starttls.enable";
    private static final String KEY_SMTP_STARTTLS_REQUIRED="mail.smtp.auth";
    private static final String KEY_SMTP_AUTH="smtp.starttls.required";

    private static final String RESOLVER_TEXT_PATTERNS="text/*";
    private static final String RESOLVER_TEXT_PREFIX="/mail/";
    private static final String RESOLVER_TEXT_SUFFIX=".text";
    private static final String RESOLVER_HTML_PATTERNS="html/*";
    private static final String RESOLVER_HTML_PREFIX="/mail/";
    private static final String RESOLVER_HTML_SUFFIX=".html";

    private static final String RESOLVER_STRING_MODE="HTML5";

    /**环境变量*/
    private Environment env;
    /**上下文容器*/
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }

    /**
     * 提供邮件发送服务
     * @return
     */
    @Bean
    public JavaMailSender mailSender(){
        final JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty(SpringMailConfig.MAIL_HOST));
        mailSender.setUsername(env.getProperty(SpringMailConfig.MAIL_USERNAME));
        mailSender.setPassword(env.getProperty(SpringMailConfig.MAIL_PASSWORD));
        mailSender.setDefaultEncoding(SpringMailConfig.EMAIL_TEMPLATE_ENCODING);
        Properties properties=new Properties();
        properties.setProperty(SpringMailConfig.KEY_SMTP_AUTH
                ,env.getProperty(SpringMailConfig.MAIL_PROPERTIES_SMTP_AUTH));
        properties.setProperty(SpringMailConfig.KEY_SMTP_STARTTLS_ENABLE
                ,env.getProperty(SpringMailConfig.MAIL_SMTP_STARTTLS_ENABLE));
        properties.setProperty(SpringMailConfig.KEY_SMTP_STARTTLS_REQUIRED
                ,env.getProperty(SpringMailConfig.MAIL_SMTP_STARTTLS_REQUIRED));
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    @Bean
    public ResourceBundleMessageSource emailMessageSource(){
        final ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("mail/MailMessage");
        return messageSource;
    }

    /**
     * 邮件模板引擎解析器
     * @return
     */
    @Bean
    public SpringTemplateEngine emailTemplateEngine(){
        final SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        templateEngine.addTemplateResolver(textTemplateResolver());
        templateEngine.addTemplateResolver(stringTemplateResolver());
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }

    /**
     * 文本解析
     * @return
     */
    private ITemplateResolver textTemplateResolver(){
        final ClassLoaderTemplateResolver templateResolver=new ClassLoaderTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(1));
        templateResolver.setResolvablePatterns(Collections.singleton(this.RESOLVER_TEXT_PATTERNS));
        templateResolver.setPrefix(this.RESOLVER_TEXT_PREFIX);
        templateResolver.setSuffix(this.RESOLVER_TEXT_SUFFIX);
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * html 页面解析
     * @return
     */
    private ITemplateResolver htmlTemplateResolver(){
        final ClassLoaderTemplateResolver templateResolver=new ClassLoaderTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(2));
        templateResolver.setResolvablePatterns(Collections.singleton(this.RESOLVER_HTML_PATTERNS));
        templateResolver.setPrefix(this.RESOLVER_HTML_PREFIX);
        templateResolver.setSuffix(this.RESOLVER_HTML_SUFFIX);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * 字符串模板解析
     * @return
     */
    private ITemplateResolver stringTemplateResolver(){
        final StringTemplateResolver templateResolver=new StringTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(3));
        templateResolver.setTemplateMode(this.RESOLVER_STRING_MODE);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
}
