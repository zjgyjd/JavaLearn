package com.github.zjgyjd.review;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 9, 8, 5, 4, 6, 3};
        InsetSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void InsetSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j;
            for (j = i - 1; j >= 0 && array[j] > array[i]; j--) {
                //此时将无序的第一位[i]和有序里面的所有数作对比
                //找到合适位置,即有序的[j] <= [i]的位置
            }
            //此时应该将[i]的值搬移到现在的j位置,之后的都向后移一位
            int temp = array[i];
            for (int k = i - 1; k > j; k--) {
                array[k + 1] = array[k];
            }
            array[j + 1] = temp;
        }

    }
}
