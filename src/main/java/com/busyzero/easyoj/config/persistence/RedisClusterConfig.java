package com.busyzero.easyoj.config.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 11456 on 2017/5/31.
 */

@Configuration
public class RedisClusterConfig {

    /**
     * redis配置项
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxTotal(600);
        return poolConfig;
    }

    @Bean
    public RedisClusterConfiguration clusterConfiguration(){
        RedisClusterConfiguration configuration=new RedisClusterConfiguration();
        configuration.setMaxRedirects(3);
        configuration.setClusterNodes(clusterNodes());
        return configuration;
    }

    @Bean
    public Set<RedisNode> clusterNodes(){
        Set<RedisNode> clusterNodes=new HashSet<>();
        clusterNodes.add(new RedisNode("192.168.30.124",7001));
        clusterNodes.add(new RedisNode("192.168.30.124",7002));
        clusterNodes.add(new RedisNode("192.168.30.124",7003));
        clusterNodes.add(new RedisNode("192.168.30.124",7004));
        clusterNodes.add(new RedisNode("192.168.30.124",7005));
        clusterNodes.add(new RedisNode("192.168.30.124",7006));
        return clusterNodes;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
       JedisConnectionFactory factory=new JedisConnectionFactory(clusterConfiguration(),jedisPoolConfig());
       return factory;
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate template=new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
