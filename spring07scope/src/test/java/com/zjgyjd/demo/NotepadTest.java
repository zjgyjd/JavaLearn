package com.zjgyjd.demo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NotepadTest {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NotePad noteoad1 = (NotePad)context.getBean("notepad");
        NotePad noteoad2 = (NotePad)context.getBean("notepad");
        System.out.println(noteoad1 == noteoad2);//以单例的模式进行存储
        context.close();
    }
}
