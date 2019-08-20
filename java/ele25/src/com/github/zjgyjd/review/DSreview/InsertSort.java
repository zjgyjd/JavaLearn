package com.github.zjgyjd.review.DSreview;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 9, 8, 5, 4, 6, 3};
        insertSort(array);
        System.out.println(Arrays.toString(array));
        insertSort1(array);
        System.out.println(Arrays.toString(array));
        sortByShell(array);
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

    //希尔排序,进行分组,按照数组长度进行排序,每次分组为gap/3+1,每次逐渐变小然后全排
    /**
     * 时间复杂度
     * 最好为: O(n)
     * 最坏为: O(n^2)
     * 但它减少了最坏情况出现的概率
     * 平均时间为:O(n ^ 1.2 - 1.3)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定,不能保证是不是在一个分组
     * @param array
     */
    public static void sortByShell(int[] array){
        int gap = array.length;
        while(true){
            gap = (gap / 3 + 1);
            gapForShell(array , gap);
            if(gap == 1){
                break;
            }
        }
    }

    public static void gapForShell(int[] array, int gap){
        for(int i = 0 ; i < array.length;i = i + gap){
            int tem = array[i];
            int j = i - gap;
            for(; j>=0 && tem < array[j];j = j - gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = tem;
        }
    }
}
