package com.kaizhang.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ：kaizhang
 * @date ：2019/7/16 21:48
 * @description： 后置处理器：初始化前后进行处理工作（jdk1.8后BeanPostProcessor中的两个方法改为了默认方法，可以不用实现）
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 初始化之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + beanName + "..." + bean);
        return bean;
    }

    /**
     * 初始化之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanName + "..." + bean);
        return bean;
    }
}
