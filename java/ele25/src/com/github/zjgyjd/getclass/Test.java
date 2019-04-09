package com.github.zjgyjd.getclass;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("java.util.Date") ;
        Object obj = cls.newInstance() ; // 通过反射实例化对象，等价于 new java.util.Date() ;
        System.out.println(obj);
    }
}
