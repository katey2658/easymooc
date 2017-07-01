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
 * 缓存集群配置类
 *  TODO 这边还没有想好如何动态去变化结点的配置从而来比买你硬编码 还有配置这边也是没有做好
 * Created by 11456 on 2017/5/31.、
 */
@Configuration
public class RedisClusterConfig {

    private static final String HSOT_REDIS_CLUSTER_NODE1="192.168.30.124";
    private static final String HSOT_REDIS_CLUSTER_NODE2="192.168.30.124";
    private static final String HSOT_REDIS_CLUSTER_NODE3="192.168.30.124";
    private static final String HSOT_REDIS_CLUSTER_NODE4="192.168.30.124";
    private static final String HSOT_REDIS_CLUSTER_NODE5="192.168.30.124";
    private static final String HSOT_REDIS_CLUSTER_NODE6="192.168.30.124";

    private  static final int PORT_REDIS_CLUSTER_NODE1=7001;
    private  static final int PORT_REDIS_CLUSTER_NODE2=7002;
    private  static final int PORT_REDIS_CLUSTER_NODE3=7003;
    private  static final int PORT_REDIS_CLUSTER_NODE4=7004;
    private  static final int PORT_REDIS_CLUSTER_NODE5=7005;
    private  static final int PORT_REDIS_CLUSTER_NODE6=7006;

    /**
     * redis 连接池配置项
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxTotal(600);
        return poolConfig;
    }

    /**
     * 集群配置
     * @return
     */
    @Bean
    public RedisClusterConfiguration clusterConfiguration(){
        RedisClusterConfiguration configuration=new RedisClusterConfiguration();
        configuration.setMaxRedirects(3);
        configuration.setClusterNodes(clusterNodes());
        return configuration;
    }

    /**
     * 集群结点集合
     * @return
     */
    @Bean
    public Set<RedisNode> clusterNodes(){
        Set<RedisNode> clusterNodes=new HashSet<>();
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE1,PORT_REDIS_CLUSTER_NODE1));
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE2,PORT_REDIS_CLUSTER_NODE2));
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE3,PORT_REDIS_CLUSTER_NODE3));
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE4,PORT_REDIS_CLUSTER_NODE4));
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE5,PORT_REDIS_CLUSTER_NODE5));
        clusterNodes.add(new RedisNode(HSOT_REDIS_CLUSTER_NODE6,PORT_REDIS_CLUSTER_NODE6));
        return clusterNodes;
    }

    /**
     * Redis 连接工厂
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
       JedisConnectionFactory factory=new JedisConnectionFactory(clusterConfiguration(),jedisPoolConfig());
       return factory;
    }

    /**
     * Redis 操作模板 对外开放操作缓存的统一接口
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate template=new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
