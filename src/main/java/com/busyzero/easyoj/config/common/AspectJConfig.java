package com.busyzero.easyoj.config.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by 11456 on 2017/4/16.
 */

@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.busyzero.easyoj.aspect"})
@Configuration
public class AspectJConfig {

}
