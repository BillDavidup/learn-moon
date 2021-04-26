package com.ning.learn.moon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot 启动类
 *
 */
@MapperScan(basePackages = {"com.ning.learn.moon.**.dao"})
@SpringBootApplication
public class LearnMoonWebApplication
{
    public static void main(String[] args) {
        SpringApplication.run(LearnMoonWebApplication.class, args);
    }
}
