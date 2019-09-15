package com.zjgyjd.demo.dao;

import com.zjgyjd.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserDaoTest {
    @Autowired
    @Qualifier("userDaoNormal")
    private UserDao userDao;

    @Test
    public void testAdd() {
        userDao.add();
    }
}
