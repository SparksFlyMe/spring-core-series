package com.kaizhang.service;

import com.kaizhang.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：kaizhang
 * @date ：2019/7/21 22:38
 * @description：
 */
@Component
public class PersonService {
    private Student student;

    public PersonService(@Autowired Student student){
        this.student = student;
        System.out.println("PersonService 无参构造器。。。");
    }


    /**
     *
     * @param student 这里方法的参数（student）的值，从ioc容器中获取
     * @return
     */

    @Autowired
    public Student getStudent(Student student) {
        return this.student = student;
    }


    @Override
    public String toString() {
        return "PersonService{" +
                "student=" + student.hashCode() +
                '}';
    }
}
