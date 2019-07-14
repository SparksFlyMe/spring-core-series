package com.kaizhang.demo;

import com.kaizhang.config.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/15 1:00
 * @description：
 */
public class LifeCycleTest {

    @Test
    public void test() {
        // 1、创建ioc容器，初始化bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成...");

        // 2、关闭容器，则销毁bean
        applicationContext.close();

    }
}
