package com.github.zjgyjd.Solution;

import java.util.HashMap;
import java.util.Map;

public class Gift {
    public int getValue(int[] gifts, int n) {
        //找到其中出现次数做多的
        HashMap<Integer,Integer> s = new HashMap<>();
        for(int i = 0; i < gifts.length; i ++){
            if(s.get(gifts[i]) == null){
                s.put(gifts[i],1);
            }else{
                int iz = s.get(gifts[i]);
                s.put(gifts[i],iz + 1);
            }
        }
        int max = 0;
        int maxIndex = -1;
        for(Map.Entry<Integer, Integer> t : s.entrySet()){
            if(t.getValue() >= max){
                max = t.getValue();
                maxIndex = t.getKey();
            }
        }
        if(max <= n / 2){
            return  0;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println( new Gift().getValue(new int[]{1,2,3,2,2,5},5));
    }
}
