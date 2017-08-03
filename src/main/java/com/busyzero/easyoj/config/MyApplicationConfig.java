package com.busyzero.easyoj.config;

import com.busyzero.easyoj.config.mvc.SecurityConfig;
import com.busyzero.easyoj.config.mvc.WebConfig;
import com.busyzero.easyoj.config.persistence.RedisClusterConfig;
import com.busyzero.easyoj.config.persistence.RootDaoConfig;
import com.busyzero.easyoj.config.service.RootServiceConfig;
import com.busyzero.easyoj.config.service.SpringMailConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * 全局配置类，是应用的入口
 * 也是会在容器启动时候被访问
 * {@link AbstractAnnotationConfigDispatcherServletInitializer} 实现了
 * {@link WebApplicationInitializer}  这个接口会被
 * {@link org.springframework.web.SpringServletContainerInitializer} 访问
 * 而SpringServletContainerInitializer 是关于Spring 对于
 * {@link ServletContainerInitializer}的实现，会在容器启动的时候被访问
 * @author katey2658
 */
public class MyApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**字符编码*/
    private  final String CHARACTER_ENCODING="UTF-8";
    /**文件上传目录*/
    private final String MULTIPART_LOCATION="/temp/upload";

    /**
     * 其它组件IOC容器的集成
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootDaoConfig.class,
                RedisClusterConfig.class,
                //CachingConfig.class,
                RootServiceConfig.class,
                SecurityConfig.class,
                SpringMailConfig.class,
                //AspectJConfig.class
        };
    }

    /**
     * mvc 层相关配置 以及组件的注册
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class,
        };
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
     * 添加了字符过滤器 编码utf-8
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        //设置字符过滤器utf-8
        CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }

    /**
     * 配置dispatcherServlet的配置
     * 在中间配置了关于文件上传目录到/temp/upload.
     * 以及配置类参数throwExceptionIfNoHandlerFound
     * 也就是当请求路径找不到合适的处理器来进行处理的时候会抛出异常来进行处理.
     * @see  com.busyzero.easyoj.handler.GlobalExceptionHandler
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        //设置文件上传目录地址
        registration.setMultipartConfig(new MultipartConfigElement(MULTIPART_LOCATION));
        //当找不到正确的处理器的时候抛出异常，来让处理
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        super.customizeRegistration(registration);
    }
}
