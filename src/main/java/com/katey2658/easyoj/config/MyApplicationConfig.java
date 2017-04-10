package com.katey2658.easyoj.config;

import com.katey2658.easyoj.config.controller.WebConfig;
import com.katey2658.easyoj.config.dao.RootDaoConfig;
import com.katey2658.easyoj.config.service.RootServiceConfig;
import com.katey2658.easyoj.config.service.SpringMailConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by 11456 on 2017/4/9.
 */

/**
 * 应用主入口：应用组件主要继承类
 */
public class MyApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootDaoConfig.class,RootServiceConfig.class, SpringMailConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
