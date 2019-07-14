package com.kaizhang.bean;

/**
 * @author ：kaizhang
 * @date ：2019/7/15 0:52
 * @description：
 */
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }


    public void init() {
        System.out.println("car...init...");
    }

    public void destroy() {
        System.out.println("car...destroy...");
    }
}
