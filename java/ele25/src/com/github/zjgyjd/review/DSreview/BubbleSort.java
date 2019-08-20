package com.github.zjgyjd.review.DSreview;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 9, 8, 5, 4, 6, 3};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void bubbleSort(int[] array){
        boolean sorted = true;
        for(int i = 0 ; i < array.length - 1 ; i++){
            for(int j = 0 ; j < array.length - i - 1 ; j++){
                if(array[j] > array[j+1]){
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }
}
