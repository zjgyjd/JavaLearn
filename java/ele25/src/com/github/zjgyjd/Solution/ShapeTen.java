package com.github.zjgyjd.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShapeTen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] target = s.nextLine().toCharArray();
        HashMap<Character, Integer> has = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            //找连续,并存长度,1.找到连续2.看有没有存在3.如果存在看连续的长度4.不存在则直接存入
            int size = 1;
            //此时连续
            while (i + 1 < target.length && target[i + 1] == target[i]) {
                i = i + 1;
                size++;
            }
            if (has.containsKey(target[i])) {
                //此时包含
                if (has.get(target[i]) < size) {
                    has.put(target[i], size);
                }
            } else {
                has.put(target[i], size);
            }
        }
        //此时就是最大连续串,遍历找到size
        for(Map.Entry entry: has.entrySet() ){
            sum += (Integer) entry.getValue();
        }
        System.out.println(sum);
    }
}
