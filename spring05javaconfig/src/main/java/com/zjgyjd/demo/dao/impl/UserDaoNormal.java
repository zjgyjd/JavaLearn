package com.zjgyjd.demo.dao.impl;

import com.zjgyjd.demo.dao.UserDao;

public class UserDaoNormal implements UserDao {
    @Override
    public void add() {
        System.out.println("添加用户到数据库");
    }
}
