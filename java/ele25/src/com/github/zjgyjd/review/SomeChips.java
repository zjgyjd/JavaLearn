package com.github.zjgyjd.review;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SomeChips {
    public static void main(String[] args) {
        String[] t1 = {};
        String[] t2 = {"java", "C++"};
        String t3 = "java";
        threePoint("java", "C++", "Python");
        threePoint(t1);
        threePoint(t2);
        threePoint(t3);
        //threePoint(t1,t2);
        System.out.println("从这里开始");
        HashSet<Object> test = new HashSet<>();
        Object test1 = new String("hehe");
        Object test2 = new String("hehe");
        test.add(test1);
        test.add(test2);
        System.out.println(test.size());
        System.out.println(test1.equals(test2));
        System.out.println(test1.hashCode() == test2.hashCode());
        System.out.println(test1.hashCode() + ","+test2.hashCode());
        System.out.println(test1 == test2);
    }

    public static void threePoint(String... s) {
        if (s == null) {
            return;
        }
        int len = s.length;
        if (len == 0) {
            System.out.println("没有字符");
        } else {
            for (String s1 : s
            ) {
                System.out.println(s1 + " ");
            }
        }
        System.out.println("==============================");
    }
}

class People {
    String name;
    String sex;

    public People(String name, String sex) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Test s = () -> System.out.println("haha");
        s.test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("no use lambda");
            }
        });
        //使用Lambda
        Thread t2 = new Thread(() -> System.out.println("use lambda"));

    }
}

interface Test {
    public void test();
}