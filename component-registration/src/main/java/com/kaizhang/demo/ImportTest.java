package com.kaizhang.demo;

import com.kaizhang.ImportConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 18:19
 * @description： 通过@import注解给容器中添加组件
 */
public class ImportTest {
    /**
     * 通过@import注解给容器中添加组件
     */
    @Test
    public void importTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }


    @Test
    public void factoryBeanTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        // 工厂bean获取的是调用getObject方法创建的对象,在这里是Student对象
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        System.out.println(myFactoryBean);

        Object myFactoryBean1 = applicationContext.getBean("myFactoryBean");
        System.out.println(myFactoryBean1);

        if (myFactoryBean == myFactoryBean1) {
            System.out.println("单例的");
        } else {
            System.out.println("多实例的");
        }

        // 要想获取工厂Bean本身，则需要给id前面加一个&，即这里的&myFactoryBean
        Object myFactoryBean2 = applicationContext.getBean("&myFactoryBean");
        System.out.println("获取工厂bean本身：" + myFactoryBean2);
    }
}
