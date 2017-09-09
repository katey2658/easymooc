package com.busyzero.easyoj.config.mvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


/**
 * Created by 11456 on 2017/4/9.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.busyzero.easyoj.controller","com.busyzero.easyoj.handler"})
public class WebConfig extends WebMvcConfigurerAdapter  implements ApplicationContextAware{

    private static final String PATTERN_RESOURCE_CSS = "/css/**";
    private final static String PATTERN_RESOURCE_JS="/js/**";
    private final static String PATTERN_RESOURCE_IMAGES="/images/**";
    private final static String LOCATION_RESOURCE_CSS="/css/";
    private final static String LOCATION_RESOURCE_JS="/js/";
    private final static String LOCATION_RESOURCE_IMAGES="/images/";

    private final static String CHARACTER_ENCODING="UTF-8";

    private final static String TEMPLATE_PREFIX="/WEB-INF/templates/";
    private final static String TEMPLATE_SUFFIX=".html";

    /**
     * 上下文对象
     */
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    /**
     * 处理静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler(PATTERN_RESOURCE_IMAGES)
                .addResourceLocations(LOCATION_RESOURCE_IMAGES);
        registry.addResourceHandler(PATTERN_RESOURCE_CSS)
                .addResourceLocations(LOCATION_RESOURCE_CSS);
        registry.addResourceHandler(PATTERN_RESOURCE_JS)
                .addResourceLocations(LOCATION_RESOURCE_JS);
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    /**
     * 视图解析
     * @return
     */
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding(CHARACTER_ENCODING);
        return viewResolver;
    }


    /**
     * 模板引擎：对内容进行解析
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addMessageResolver(new StandardMessageResolver());
        return templateEngine;
    }


    /**
     * 加载模板资源
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix(TEMPLATE_PREFIX);
        templateResolver.setSuffix(TEMPLATE_SUFFIX);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(CHARACTER_ENCODING);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

}
