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
 * @author katey2658
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.busyzero.easyoj.repository")
public class RootDaoConfig {

    private final static String JDBC_DRIVER="spring.jdbc.driver";
    private final static String JDBC_URL="spring.jdbc.url";
    private final static String JDBC_USERNAME="spring.jdbc.username";
    private final static String JDBC_APSSWORD="spring.jdbc.password";
    private final static String JDBC_INITSIZE="spring.jdbc.initsize";
    private final static String JDBC_MINIDLE="spring.jdbc.minidle";
    private final static String JDBC_MAXACTIVE="spring.jdbc.maxactive";
    private final static String JDBC_MAXWAIT="spring.jdbc.maxwait";
    private final static String JDBC_AUTOCOMMIT="spring.jdbc.autocommit";

    private final static String TYPE_ALIASES_PACKAGE="com.busyzero.easyoj.domain";

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
        dataSource.setDriverClassName(env.getProperty(this.JDBC_DRIVER));
        dataSource.setUrl(env.getProperty(this.JDBC_URL));
        dataSource.setUsername(env.getProperty(this.JDBC_USERNAME));
        dataSource.setPassword(env.getProperty((this.JDBC_APSSWORD)));

        dataSource.setInitialSize(env.getProperty(this.JDBC_INITSIZE,Integer.class));
        dataSource.setMaxActive(env.getProperty(this.JDBC_MAXACTIVE,Integer.class));
        dataSource.setMinIdle(env.getProperty(this.JDBC_MINIDLE,Integer.class));
        dataSource.setMaxWait(env.getProperty(this.JDBC_MAXWAIT,Integer.class));
        dataSource.setDefaultAutoCommit(env.getProperty(this.JDBC_AUTOCOMMIT,Boolean.class));
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
        sessionFactory.setTypeAliasesPackage(this.TYPE_ALIASES_PACKAGE);
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
