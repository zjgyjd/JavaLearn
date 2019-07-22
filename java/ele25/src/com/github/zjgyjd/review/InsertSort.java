package com.github.zjgyjd.review;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 9, 8, 5, 4, 6, 3};
        insertSort(array);
        System.out.println(Arrays.toString(array));
        insertSort1(array);
        System.out.println(Arrays.toString(array));
    }

    //排升序
    public static void insertSort(int[] array) {
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

    //插入排序改进,将数组搬移的过程加到第一个for循环中(排降序)
    public static void insertSort1(int[] array){
        for(int i = 0; i < array.length ; i++){
            int j;
            int temp = array[i];
            for(j = i - 1; j >=0 && array[j] < temp ; j--){
                array[j+1] = array[j];
            }
            array[j + 1] = temp;
        }
    }
}
