package com.kaizhang.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author ：kaizhang
 * @date ：2019/7/16 0:50
 * @description：
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog constructor");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void init() {
        System.out.println("Dog...@PostConstruct...");
    }

    /**
     * 容器移除对象之前执行
     */
    @PreDestroy
    public void destory() {
        System.out.println("Dog...@PreDestroy...");
    }
}
