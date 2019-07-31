package com.github.zjgyjd.Solution;

public class Example {
    public static void main(String[] args) {
        String x1 = "hello world";
        String x2 = "hello " + "world";
        String x3 = "hello ";
        String x4 = "world";
        String x5 = x3 + x4;
        System.out.println(x1 == x2);//true
        System.out.println(x5 == x1);//false
    }
}
