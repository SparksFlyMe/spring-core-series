package com.kaizhang.demo;

import com.kaizhang.bean.Person;
import com.kaizhang.bean.Student;
import com.kaizhang.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/10 22:17
 * @description： Scope测试
 */
public class ScopeTest {
    /**
     * 当{@link ScopeConfig}中 scope不配置（默认为单实例）或者配置成单实例时（SINGLETON），则该方法返回true：说明返回单个实例
     * 当{@link ScopeConfig}中 scope配置成多实例时（PROTOTYPE），则该方法返回false：说明返回多个实例
     */
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Person person = applicationContext.getBean(Person.class);

        Person person1 = applicationContext.getBean(Person.class);

        if (person.equals(person1)) {
            System.out.println("SINGLETON person:" + true);
        } else {
            System.out.println("SINGLETON person:" + false);
        }

        Student student1 = applicationContext.getBean(Student.class);
        Student student2 = applicationContext.getBean(Student.class);

        if (student1.equals(student2)) {
            System.out.println("PROTOTYPE student:" + true);
        } else {
            System.out.println("PROTOTYPE student:" + false);
        }
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        System.out.println("ioc容器创建完成...");
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        System.out.println("ioc容器创建完成...");
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        Person person3 = applicationContext.getBean(Person.class);


        Student student1 = applicationContext.getBean(Student.class);
        Student student2 = applicationContext.getBean(Student.class);
        Student student3 = applicationContext.getBean(Student.class);
        Student student4 = applicationContext.getBean(Student.class);

    }
}
