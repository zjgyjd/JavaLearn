package com.github.zjgyjd.review.DSreview;

public class ChTree {
    public static void chTree(int[] brr, int[] array, int i, int length){
        if (i == length){
            i++;
            System.out.println(i);
        }else {
            brr[i] = 1;
            chTree(brr,array,i+1,length);
            brr[i] = 0;
            chTree(brr,array,i+1,length);
        }
    }

}
