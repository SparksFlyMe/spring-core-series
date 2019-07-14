package com.kaizhang.bean;

/**
 * @author ：kaizhang
 * @date ：2019/7/7 16:02
 * @description：
 */
public class Person {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
