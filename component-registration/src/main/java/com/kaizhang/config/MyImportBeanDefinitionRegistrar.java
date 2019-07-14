package com.kaizhang.config;

import com.kaizhang.bean.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 21:13
 * @description： 自定义ImportBeanDefinitionRegistrar，实现ImportBeanDefinitionRegistrar，手动注册bean到容器中，beanName可以自己定义
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Person.class);
        registry.registerBeanDefinition("beanName: myImportBeanDefinitionRegistrarBean", beanDefinition);
    }
}
