package com.ning.learn.moon.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: wudening
 * @Description: RedisTemplate配置
 * @Date: 2021/5/1 4:13 下午
 */
public class RedisTemplateComponent {
    @Value("${redis.hostname}")
    private String redisHost;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.maxidleConnection:20}")
    private Integer maxidleConnection;

    @Value("${redis.minidleConnection:5}")
    private Integer minidleConnection;

    @Value("${redis.maxWaitMillis:1000}")
    private Integer maxWaitMillis;

    @Value("${redis.maxactive:100}")
    private Integer maxactive;

    @Value("${redis.minEvictableIdleTimeMillis:60000}")
    private Integer minEvictableIdleTimeMillis;

    public RedisConnectionFactory getRedisConnectionFactory() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxidleConnection);
        jedisPoolConfig.setMinIdle(minidleConnection);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxactive);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        //开启使用链接时进行扫描
        jedisPoolConfig.setTestOnBorrow(true);

        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
        factory.setHostName(redisHost);
        factory.setPort(redisPort);
        factory.setPassword(redisPassword);
        return factory;
    }

    public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
