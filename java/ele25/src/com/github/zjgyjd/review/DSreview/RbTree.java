package com.github.zjgyjd.review.DSreview;

import java.util.Arrays;
import java.util.Set;

public class RbTree {
    public static void rbTree(Set<int[]> integers, int[] array, int i, int length){
        if (i == length){
            System.out.println(Arrays.toString(array));
        }else {
            for (int j = 0; j < array.length; j++) {
                swap(array,i,j);
                rbTree(integers, array,i+1,length);
                swap(array,i,j);
            }
        }

    }
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
