package com.kaizhang.demo;

import com.kaizhang.bean.Person;
import com.kaizhang.bean.Student;
import com.kaizhang.config.LazyBeanConfig;
import com.kaizhang.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 15:22
 * @description：懒加载bean
 *
 *
 * 1、不是懒加载的Bean，默认在容器启动的时候创建对象
 * 2、懒加载的Bean，容器启动不创建对象。第一次使用（获取）Bean时创建对象，并初始化（以后每次获取则不会创建对象，因为是单实例的）
 * 3、懒加载是专门针对于单实例的Bean
 */
public class LazyBeanTest {
    /**
     * 不是懒加载的bean，默认在容器启动的时候创建对象
     */
    @Test
    public void lazyBeanTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyBeanConfig.class);
        Person person = applicationContext.getBean(Person.class);

        Person person1 = applicationContext.getBean(Person.class);

        if (person.equals(person1)) {
            System.out.println("SINGLETON person:" + true);
        } else {
            System.out.println("SINGLETON person:" + false);
        }
    }

    /**
     * 懒加载的bean，容器启动不创建对象。第一次使用（获取）Bean时创建对象并初始化（以后每次获取则不会创建对象，因为是单实例的）
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyBeanConfig.class);
        System.out.println("没有获取bean时：在容器启动后，没获取Bean时不会创建对象--------");


        Student student1 = applicationContext.getBean(Student.class);
        Student student2 = applicationContext.getBean(Student.class);

        // 这里两次获取Bean,但是只有一次会创建Bean，且获取的两个Bean是指向同一个
        if (student1.equals(student2)) {
            // 因为是单实例的，所以每次获取的对象是相同的
            System.out.println("student:" + true);
        } else {
            System.out.println("student:" + false);
        }
    }

}
