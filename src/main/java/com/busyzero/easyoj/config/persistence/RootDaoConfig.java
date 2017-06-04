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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by 11456 on 2017/4/10.
 */

/**
 * 持久层组件集成
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = {"com.katey2658.mapper"})
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

    private final static String MAPPER_LOCATIONS_PATTERN="classpath:mapper/*Mapper.xml";
    private final static String TYPE_ALIASES_PACKAGE="com.katey2658.easyoj.domain";

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
        dataSource.setName(env.getProperty(this.JDBC_USERNAME));
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
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(this.MAPPER_LOCATIONS_PATTERN));
        sessionFactory.setTypeAliasesPackage(this.TYPE_ALIASES_PACKAGE);
        SqlSessionFactory sqlSessionFactory=sessionFactory.getObject();
        org.apache.ibatis.session.Configuration configuration=sqlSessionFactory.getConfiguration();
        //开启驼峰转换
        configuration.setMapUnderscoreToCamelCase(true);
        //使用jdbc自增序列
        configuration.setUseGeneratedKeys(true);
        //使用列明别名
        configuration.setUseColumnLabel(true);
        return sqlSessionFactory;
    }
}
