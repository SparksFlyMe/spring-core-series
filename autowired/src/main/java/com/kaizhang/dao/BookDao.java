package com.kaizhang.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ：kaizhang
 * @date ：2019/7/7 22:23
 * @description：
 */

// 名字默认是类名首字母小写的方式
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
