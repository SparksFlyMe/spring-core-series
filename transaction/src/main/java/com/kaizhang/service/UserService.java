package com.kaizhang.service;

import com.kaizhang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：kaizhang
 * @date ：2019/8/10 10:10
 */
@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入用户成功");

        int i = 10/0;
    }
}
