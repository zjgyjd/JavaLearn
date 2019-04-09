package com.github.zjgyjd.generic;

import java.util.ArrayList;
import java.util.List;

public class UseMessage {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMNOPKRSTUVWXYZ".split(""));
        System.out.println(ls);
    }

}
