package com.kaizhang.bean;

import org.springframework.stereotype.Component;

/**
 * @author ：kaizhang
 * @date ：2019/7/10 23:46
 * @description：学生测试类
 */
@Component
public class Student {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public Student() {

    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
