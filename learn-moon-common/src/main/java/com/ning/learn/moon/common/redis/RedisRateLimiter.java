package com.ning.learn.moon.common.redis;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wudening
 * @Description:
 * @Date: 2021/5/1 4:32 下午
 */
@Slf4j
public class RedisRateLimiter {
    public static final String LIMIT_LUA_SCRIPT;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("local current\r\n");
        sb.append("current = redis.call('GET',KEYS[1])\r\n");
        sb.append("if current and tonumber(current) >= tonumber(ARGV[1]) then\r\n");
        sb.append("return -1 \r\n;");
        sb.append("end\r\n");
        sb.append("current = redis.call('incr',KEYS[1])\r\n");
        sb.append("if tonumber(current) == 1 then\r\n");
        sb.append("redis.call('expire',KEYS[1],KEYS[2])\r\n");
        sb.append("end\r\n");
        sb.append("return 1 \r\n;");
        LIMIT_LUA_SCRIPT = sb.toString();
//        log.info("UNLOCK_LUA_SCRIPT --> {}", LIMIT_LUA_SCRIPT);
    }

    private RedisTemplate<Object, Object> redisTemplate;

    public RedisRateLimiter(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * second秒钟内限制访问key操作count次
     * 应用场景，限制一个ip在1秒钟内只能访问10次，key传ip
     *
     * @param key
     * @param second
     * @param count
     * @return 被限制的请求返回true
     */
    public boolean limitAccess(String key, int second, int count) {
        return limitAccess(key, second, count, -1);
    }

    public boolean limitAccess(String key, int limitSecond, int count, int lockSeconds) {
        String lockKey = "@_" + key;
        try {
            RedisCallback<Long> callback = (connection) -> {
                List<String> keys = Lists.newArrayList();
                keys.add(lockKey);
                keys.add(limitSecond + "");
                List<String> args = Lists.newArrayList();
                args.add(count + "");
                Object nativeConnection = connection.getNativeConnection();
                if (nativeConnection instanceof JedisCluster) {
                    return (Long) ((JedisCluster) nativeConnection).eval(LIMIT_LUA_SCRIPT, keys, args);
                } else if (nativeConnection instanceof Jedis) {
                    return (Long) ((Jedis) nativeConnection).eval(LIMIT_LUA_SCRIPT, keys, args);
                }
                return 0L;
            };
            Long result = redisTemplate.execute(callback);
            if (result < 0 && lockSeconds > 0) {
                redisTemplate.opsForValue().set(lockKey, count + 1, lockSeconds, TimeUnit.SECONDS);
            }
            return result < 0;
        } catch (Exception e) {
            log.error("limitAccess exception：{}", ExceptionUtils.getStackTrace(e));
        }
        return false;
    }
}
