package com.busyzero.easyoj.config.persistence;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 持久层组件集成
 *
 *
 * @author katey2658
 */
@Configuration
@PropertySource(RootDaoConfig.DATASOURCE_CONFIG_PROPERTIES_LOCATION)
@MapperScan(RootDaoConfig.MAPPER_SCAN_PACKAGE)
public class RootDaoConfig {
   /**配置文件所在位置*/
    public static final String DATASOURCE_CONFIG_PROPERTIES_LOCATION = "classpath:jdbc.properties";
    /**自动扫描映射文件*/
    public static final String MAPPER_SCAN_PACKAGE = "com.busyzero.easyoj.repository";

    /**模型包名 别名自动扫描*/
    private static final String TYPE_ALIASES_PACKAGE="com.busyzero.easyoj.entity";


    /**驱动*/
    private static final String CONFIG_DATASOURCE_DRIVER="spring.jdbc.driver";
    /**连接URL*/
    private static final String CONFIG_DATASOURCE_URL="spring.jdbc.url";
    /**用户名*/
    private static final String CONFIG_DATASOURCE_USERNAME="spring.jdbc.username";
    /**密码*/
    private static final String CONFIG_DATASOURCE_PSSWORD="spring.jdbc.password";
    /**连接池初始大小*/
    private static final String CONFIG_DATASOURCE_INITSIZE="spring.jdbc.initsize";
    /**最小闲置*/
    private static final String CONFIG_DATASOURCE_MINIDLE="spring.jdbc.minidle";
    /**最大可用*/
    private static final String CONFIG_DATASOURCE_MAXACTIVE="spring.jdbc.maxactive";
    /**最大等待时间*/
    private static final String CONFIG_DATASOURCE_MAXWAIT="spring.jdbc.maxwait";
    /**事务自动提交*/
    private static final String CONFIG_DATASOURCE_AUTOCOMMIT="spring.jdbc.autocommit";

    /**环境变量对象*/
    @Autowired
    private Environment env;

    /**
     *配置数据源连接池:Druid
     * @return
     */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_DRIVER));
        dataSource.setUrl(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_URL));
        dataSource.setUsername(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_USERNAME));
        dataSource.setPassword(env.getProperty((RootDaoConfig.CONFIG_DATASOURCE_PSSWORD)));

        dataSource.setInitialSize(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_INITSIZE,Integer.class));
        dataSource.setMaxActive(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_MAXACTIVE,Integer.class));
        dataSource.setMinIdle(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_MINIDLE,Integer.class));
        dataSource.setMaxWait(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_MAXWAIT,Integer.class));
        dataSource.setDefaultAutoCommit(env.getProperty(RootDaoConfig.CONFIG_DATASOURCE_AUTOCOMMIT,Boolean.class));
        return dataSource;
    }

    /**
     * 获得 SqlSessionFactory 注入到容器中
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage(RootDaoConfig.TYPE_ALIASES_PACKAGE);
        //获得seqsession工厂对象
        SqlSessionFactory factory=sessionFactory.getObject();
        //获得配置对象
        org.apache.ibatis.session.Configuration configuration=factory.getConfiguration();
        //使用自动生成的key
        configuration.setUseGeneratedKeys(true);
        //使用列标签
        configuration.setUseColumnLabel(true);
        //将下划线转变为驼峰写法
        configuration.setMapUnderscoreToCamelCase(true);
        //使用复杂集合的结果集
        configuration.setMultipleResultSetsEnabled(true);
        //启用缓存
        configuration.setCacheEnabled(true);
        //处理返回空值问题
        configuration.setCallSettersOnNulls(true);
        return factory;
    }
}
