package com.kaizhang;

import com.kaizhang.bean.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 21:42
 * @description： 使用Spring提供的FactoryBean（工厂Bean）来注册组件
 */
public class MyFactoryBean implements FactoryBean<Student> {
    /**
     * 返回一个Student对象，这个对象会添加到容器中。通过FactoryBean注册组件，就是利用该方法创建bean
     * @return
     * @throws Exception
     */
    @Override
    public Student getObject() throws Exception {
        System.out.println("通过自定义的FactoryBean创建bean");
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 当返回值为false时，表示这个bean不是多实例的，每次获取都会创建一个新的bean
     * 当返回值为true时，表示这个bean时单实例的，在容器中只保存一份
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
