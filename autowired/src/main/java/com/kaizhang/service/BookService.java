package com.kaizhang.service;

import com.kaizhang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ：kaizhang
 * @date ：2019/7/7 22:23
 * @description：
 */
@Service
public class BookService {
    @Qualifier("bookDao")  // 这里指定需要装配的组件的id，而不是使用属性名
    @Autowired
    private BookDao bookDao2;

    public void print() {
        System.out.println(bookDao2);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao2 +
                '}';
    }
}
