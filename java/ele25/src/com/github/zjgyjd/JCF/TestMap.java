package com.github.zjgyjd.JCF;

import java.util.*;

public class TestMap {
    public static void code1 (){
        Map<String,String> map = new HashMap<>();//内部实现不传参为16个数组,0.75因子,当链表大于8个,数组大于64个变成数
        map.put("1","java");
        map.put("2","C++");
        map.put("3","Python");
        System.out.println(map.containsKey("1"));//true
        System.out.println(map.get("2"));//"java"

        map.put(null,"key is null");//此时可以看出HashMap的Key和Value可以为null
        map.put("4",null);
        map.put("4","PHP");//此时会发生覆盖
        System.out.println(map.size());
        System.out.println(map.get("4"));
        System.out.println(map.get("6"));//此时没有值为null

        //获取Map中的使用key
        Set<String> keys = map.keySet();
        for(String s : keys){
            System.out.println(s);
            System.out.println(s+" = "+map.get(s));
        }

        //获取所以value
        Collection<String> value = map.values();
        //通过EntrySet访问
        Set<Map.Entry<String,String>> entries = map.entrySet();
        //foreach, iterator
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());//两个都同时需要时用这种
        }
    }
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<>(
                (o1, o2) -> o1.compareTo(o2)*-1
        );//排序时可以加比较器
        map.put(1,"Java");
        map.put(2,"C++");
        map.put(4,"C");
        map.put(3,"PHP");//此时会自动排序


    }
}
