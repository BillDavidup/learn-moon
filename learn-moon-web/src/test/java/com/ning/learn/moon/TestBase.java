package com.ning.learn.moon;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wudening
 * @Description: 需要启动Spring boot获取IOC容器的测试类请继承它
 * @Date: 2021/4/24 5:55 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnMoonWebApplication.class)
public class TestBase {
}
