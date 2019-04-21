package com.github.zjgyjd.DS.SomeTalked;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String className = "com.github.zjgyjd.DS.SomeTalked.TextExample";
        Class testClass = Class.forName(className);
        if(testClass.isAnnotationPresent(Tester.class)){
            //如果有改注释就进来
            Annotation annotation = testClass.getAnnotation(Tester.class);
            Tester tester = (Tester) annotation;

            System.out.println(tester.author());
            System.out.println(tester.date());
        }

        Method[]  methods= testClass.getDeclaredMethods();
        for (Method method:methods
             ) {
            System.out.println(method);
        }
    }
}
