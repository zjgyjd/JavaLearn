package com.zjgyjd.demo.config;

import com.zjgyjd.demo.dao.UserDao;
import com.zjgyjd.demo.dao.impl.UserDaoCache;
import com.zjgyjd.demo.dao.impl.UserDaoNormal;
import com.zjgyjd.demo.service.UserService;
import com.zjgyjd.demo.service.impl.UserServiceNormal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserDao userDaoNormal(){
        System.out.println("创建UserDao对象");
        return new UserDaoNormal();
    }
    @Bean
    public UserService userServiceNormal(@Qualifier("userDaoCache")UserDao userDao){
        System.out.println("创建UserService对象");
        UserServiceNormal userService = new UserServiceNormal();
        userService.setUserDao(userDao);
        return userService;
    }
    @Bean
    public UserDao userDaoCache(){
        System.out.println("创建UserDaoCache对象");
        return new UserDaoCache();
    }
}
