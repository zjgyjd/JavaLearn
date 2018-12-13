package com.github.zjgyjd.JCF;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void code1 (){
        Map<String,String> map = new HashMap<>();
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
    }
    public static void main(String[] args) {
            code1();
    }
}
