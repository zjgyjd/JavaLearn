package com.github.zjgyjd.DS.genericType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static void testList(List<Integer> list){
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //[0,9]
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int item = iterator.next();//自动拆箱
            System.out.println(item);
        }

        iterator = list.iterator();
        while(iterator.hasNext()){
            int item = iterator.next();
            if(item == 5){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> seqList = new SeqList<>();
        new StringBuffer('i');
        testList(seqList);
        testList(list);
    }
}
