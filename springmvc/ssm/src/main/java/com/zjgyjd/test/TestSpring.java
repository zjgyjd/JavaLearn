package com.zjgyjd.test;

import com.zjgyjd.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void  run1(){
        //加载配置文件,获取对象,调用方法测试Spring
        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }
}
