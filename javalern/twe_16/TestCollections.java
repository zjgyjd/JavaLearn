package com.github.zjgyjd.JCF;

import java.util.*;

public class TestCollections {
    public static void code1(){
        //线程完全
        Map<String,String> map =  Collections.synchronizedMap(new HashMap<>());//利用包装类,给
        System.out.println(map.getClass().getName());//会返回一个Colletions里面的synchronizedMap

        //线程不安全
        //        Map<String,String> map = new HashMap<>();
        //        map.put("1","java");
    }
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for (int i = 65; i < 123; i++) {
            data.add(String.valueOf((char)i));
        }
            System.out.println(data);//原始数据
        Collections.reverse(data);//翻转
        System.out.println(data);

        System.out.println(  Collections.binarySearch(data,"z"));//此时返回-58-1 = -59 刚开始坐标减一

        //乱序
        Collections.shuffle(data);
        System.out.println(data);//此时会打乱顺序
        System.out.println(  Collections.binarySearch(data,"z"));
    }
}
