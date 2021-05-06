package com.ning.learn.moon.redis;

import com.ning.learn.moon.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wudening
 * @Description: Redis测试类
 * @Date: 2021/5/1 5:44 下午
 */
@Slf4j
public class RedisTest extends TestBase {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("1", 3, 30, TimeUnit.SECONDS);
        int o = (int) redisTemplate.opsForValue().get("1");
        log.info("key:{},value:{}", 1, o);
    }

}
