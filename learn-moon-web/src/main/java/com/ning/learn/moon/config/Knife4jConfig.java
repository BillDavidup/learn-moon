package com.ning.learn.moon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <!-- knife4j 接入STEP ②：创建配置类 -->
 * @Author: wudening
 * @Description: knife4j接口文档配置 swagger-bootstrap-ui 的增强版 官方文档 https://doc.xiaominfo.com/knife4j/
 * @Date: 2021/4/26 8:13 下午
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.ning.learn.moon.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("SpringBoot项目【learn-moon】服务API接口文档")
                // 文档简介
                .description("使用 knife4j 搭建的后台服务API接口文档")
                // 修改成活的配置
                .termsOfServiceUrl("本地：http://localhost:9092/doc.html，测试：http://t-learn-moon/doc.html，预发：http://p-learn-moon/doc.html，线上：http://learn-moon/doc.html")
                .contact(new Contact("学习Knife4j接口文件接入", "https://github.com/BillDavidup/learn-moon.gi", "1336038558@qq.com"))
                .version("1.0.0")
                .build();
    }
}
