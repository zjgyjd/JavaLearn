package com.zjgyjd.demo.service.impl;

import com.zjgyjd.demo.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("festival")//当不指定时,会直接有类名首字母小写,作为它的id
//@Qualifier("festival")
public class UserServiceFestival implements UserService {
    @Override
    public void add() {
        System.out.println("注册用户并发送礼物");
    }
}
