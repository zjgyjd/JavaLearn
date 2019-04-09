package com.github.zjgyjd.Chorus2.Choose;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> s = new LinkedList<>();
        s.add(48);
        s.add(58);
        s.add(88);
        LinkedList<Integer> s1 = (LinkedList<Integer>) s.clone();
        s1.add(555);
        for(Integer a : s){
            System.out.println(a);
        }
    }
}
