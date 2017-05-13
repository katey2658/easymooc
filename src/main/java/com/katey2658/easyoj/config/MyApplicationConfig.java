package com.katey2658.easyoj.config;

import com.katey2658.easyoj.config.controller.WebConfig;
import com.katey2658.easyoj.config.dao.RootDaoConfig;
import com.katey2658.easyoj.config.service.RootServiceConfig;
import com.katey2658.easyoj.config.service.SpringMailConfig;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by 11456 on 2017/4/9.
 */

/**
 * 应用主入口：应用组件主要继承类
 */
public class MyApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    private final String SERVLET_MAPPING_PATH="/";

    private  final String CHARACTER_ENCODING="UTF-8";

    private final String MULTIPART_LOCATION="/temp/upload";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{SERVLET_MAPPING_PATH};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement(MULTIPART_LOCATION));
        super.customizeRegistration(registration);
    }
}
