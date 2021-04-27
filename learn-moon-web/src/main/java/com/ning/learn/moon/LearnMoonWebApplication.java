package com.ning.learn.moon;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot 启动类
 *
 */
@MapperScan(basePackages = {"com.ning.learn.moon.**.dao"})
@SpringBootApplication
@NacosPropertySources(
        {
                @NacosPropertySource(dataId = "learn-moon_hot-config", type = ConfigType.YAML, autoRefreshed = true)
        }
)
public class LearnMoonWebApplication
{
    public static void main(String[] args) {
        SpringApplication.run(LearnMoonWebApplication.class, args);
    }
}
