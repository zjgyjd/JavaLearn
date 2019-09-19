package com.zjgyjd.demo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Notepad2Test {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NotePad noteoad1 = (NotePad)context.getBean("notepad2");
        NotePad noteoad2 = (NotePad)context.getBean("notepad2");
        System.out.println(noteoad1 == noteoad2);//以单例的模式进行存储
    }
}
