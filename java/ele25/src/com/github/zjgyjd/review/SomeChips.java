package com.github.zjgyjd.review;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SomeChips {
    public static void main(String[] args) {
        String[] t1 = {};
        String[] t2 = {"java","C++"};
        String t3 = "java";
        threePoint("java","C++","Python");
        threePoint(t1);
        threePoint(t2);
        threePoint(t3);
        //threePoint(t1,t2);


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

class People{
    String name;
    String sex;

    public People(String name,String sex) {
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
    }
}

interface Test{
    public void test();
}