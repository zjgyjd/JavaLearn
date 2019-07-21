package com.github.zjgyjd.review;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> s1 = new HashMap<>();
        Map<String, String> s2 = new Hashtable<>();
        Map<String, String> s3 = new TreeMap<>();
        test t = new test(15, 15);
        char[] a = {'s', 's', 's'};
        int k = 0;
        change(a, k, t);
        System.out.println(Arrays.toString(a) + " " + k + t);

    }

    public static void change(char[] a, int k, test t) {
        a[0] = '5';
        k = 10;
        t.age = 16;
    }
}

class test {
    int age;
    int money;

    @Override
    public String toString() {
        return "test{" +
                "age=" + age +
                ", money=" + money +
                '}';
    }

    public test(int age, int money) {
        this.age = age;
        this.money = money;
    }
}
