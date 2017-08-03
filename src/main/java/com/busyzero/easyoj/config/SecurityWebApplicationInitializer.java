package com.busyzero.easyoj.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 在应用启动时候会被加载Spring Security
 * 使用这个的时候会自动注册{@link DelegatingFilterProxy}
 * @author katey2658
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {}
