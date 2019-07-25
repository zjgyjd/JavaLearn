package com.github.zjgyjd.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberTimes {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));

    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        int max = 0;
        int maxValue = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (a.containsKey(array[i])) {
                a.put(array[i], a.get(array[i]) + 1);
            } else {
                a.put(array[i], 1);
            }
        }

        //foreach, iterator
        for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
            if (entry.getValue() > max && entry.getValue() > length / 2) {
                maxValue = entry.getKey();
                max = entry.getValue();
            }
        }
        return maxValue;
    }
}
