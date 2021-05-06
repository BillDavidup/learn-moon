package com.ning.learn.moon.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.learn.moon.common.redis.RedisClientUtil;
import com.ning.learn.moon.common.redis.RedisTemplateComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: wudening
 * @Description: redis配置
 * @Date: 2021/5/1 3:37 下午
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplateComponent getRedisTemplateComponent() {
        return new RedisTemplateComponent();
    }

    @Bean("myRedisConnectionFactory")
    public RedisConnectionFactory getRedisConnectionFactory(RedisTemplateComponent redisTemplateComponent) {
        return redisTemplateComponent.getRedisConnectionFactory();
    }

    @Bean("myRedisTemplate")
    public RedisTemplate<Object, Object> getRedisTemplate(RedisTemplateComponent redisTemplateComponent, @Qualifier("myRedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = redisTemplateComponent.getRedisTemplate(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public RedisClientUtil getUi(@Qualifier("myRedisTemplate") RedisTemplate redisTemplate) {
        return new RedisClientUtil(redisTemplate);
    }

//    @Bean()
//    public RedisRateLimiter redisRateLimiter(@Qualifier("myRedisTemplate") RedisTemplate redisTemplate) {
//        return new RedisRateLimiter(redisTemplate);
//    }
}
