package com.github.zjgyjd.getclass;

public class TestClassLoader {
    public static void main(String[] args) {
        Class class2 = TestClassLoader.class;
        System.out.println(class2.getClassLoader());//App
        System.out.println(class2.getClassLoader().getParent());//Ext
        System.out.println(class2.getClassLoader().getParent().getParent());//null因为是用非java语言写的
    }
}
