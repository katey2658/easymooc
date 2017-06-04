package com.busyzero.easyoj.config;

import com.busyzero.easyoj.config.common.AspectJConfig;
import com.busyzero.easyoj.config.mvc.WebConfig;
import com.busyzero.easyoj.config.persistence.RedisClusterConfig;
import com.busyzero.easyoj.config.persistence.RootDaoConfig;
import com.busyzero.easyoj.config.service.CachingConfig;
import com.busyzero.easyoj.config.service.RootServiceConfig;
import com.busyzero.easyoj.config.service.SpringMailConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by 11456 on 2017/6/4.
 */
public class MyApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    private  final String CHARACTER_ENCODING="UTF-8";
    private final String MULTIPART_LOCATION="/temp/upload";
    /**
     * 其它组件的注册
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootDaoConfig.class,
                RedisClusterConfig.class,
                CachingConfig.class,
                RootServiceConfig.class,
                SpringMailConfig.class,
                AspectJConfig.class};
    }

    /**
     * mvc 层相关配置 以及组件的注册
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * dispatcher 映射的路径
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 添加过滤器:
     * 添加了字符过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        //字符过滤器
        CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }

    /**
     * 配置dispatcherServlet
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        //设置文件上传目录地址
        registration.setMultipartConfig(new MultipartConfigElement(MULTIPART_LOCATION));
        super.customizeRegistration(registration);
    }
}
