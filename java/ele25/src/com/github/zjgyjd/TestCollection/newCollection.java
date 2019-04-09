package com.github.zjgyjd.TestCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class newCollection {
    public static void code1() {
        //forEach-->Iterable
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "java", "C++", "Python");
//        list.forEach(System.out::println);//方法引用
        System.out.println(list.stream().count());
        list.stream().filter(s -> s.contains("java"))//过滤元素
                .forEach(System.out::println);

        List<String> newList = list.stream(). //流
                filter(s -> s.contains("java")).//过滤
                map(String::toUpperCase).//转换
                collect(Collectors.toList());


        //符合条件的元素个数统计
        Long count = list.stream().filter(s -> s.contains("java")).count();
        System.out.println(count);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1、Java", "2、C++", "3、Python", "4、JavaScript",
                "5、 Nginx","6、Tomcat");
//        list.stream().skip(1)//跳过一个
//                .limit(2)//去两个
//                .forEach(System.out::println);

        list.stream()
                .skip(1)
                .limit(3)
                .filter(s->s.contains("Java"))
                .forEach(System.out::println);//流式传输是有顺序的,但是调用有两种方法,分为中间过程(limit,skip)--
        // ->和终结方法(forEach)此时才开始执行调用

    }
}
