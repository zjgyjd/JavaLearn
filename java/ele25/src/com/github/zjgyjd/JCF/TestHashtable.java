package com.github.zjgyjd.JCF;

import java.util.Hashtable;
import java.util.Map;

public class TestHashtable {
    public static void main(String[] args) {
    Map<String,String> map = new Hashtable<>();//注意table小写
    map.put("1","c++");
    //当Hashtable: key和value为null时,会抛空指针NPE

    }
}
