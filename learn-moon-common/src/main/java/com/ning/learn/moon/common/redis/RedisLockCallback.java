package com.ning.learn.moon.common.redis;

/**
 * @Author: wudening
 * @Description: RedisTemplate的回调方法
 * @Date: 2021/5/1 4:35 下午
 */
public interface RedisLockCallback {
    Object doInRedisLock();
}
