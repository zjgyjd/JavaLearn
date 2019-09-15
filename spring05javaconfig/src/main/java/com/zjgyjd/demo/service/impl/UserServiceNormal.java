package com.zjgyjd.demo.service.impl;

import com.zjgyjd.demo.dao.UserDao;
import com.zjgyjd.demo.service.UserService;


public class UserServiceNormal implements UserService {
    private UserDao userDao;

    public UserServiceNormal(){
        super();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceNormal(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void add() {
        userDao.add();
    }
}
