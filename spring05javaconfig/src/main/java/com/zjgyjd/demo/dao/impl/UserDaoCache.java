package com.zjgyjd.demo.dao.impl;

import com.zjgyjd.demo.dao.UserDao;

public class UserDaoCache  implements UserDao {
    @Override
    public void add() {
        System.out.println("添加用户到缓存中");
    }
}
