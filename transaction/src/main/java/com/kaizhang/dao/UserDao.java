package com.kaizhang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author ：kaizhang
 * @date ：2019/8/10 10:11
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO tbl_user (username, age) VALUE (?, ?);";
        String userName = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, userName, 19);
    }
}
