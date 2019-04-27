package com.github.zjgyjd.DS.Sort;

import com.github.zjgyjd.DS.THeap.TtHeap;

public class tSort {
    private static void selectSort(int[] array) {
        //每次选一个最大的,放到无序部分最后
        for (int i = 0; i < array.length; i++) {
            //无序 [0, array.length-i)
            //有序 [array.length-i,array.length)
            //在无序部分选最大的一个数,找出其下标
            int max = 0;    //最大数下标
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }

            //把最大数放到无序区间最后一个
            int t = array[max];
            array[max] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
    }


    /**
     * 堆排序
     * 时间复杂度 O(n * log n)
     *
     * @param array
     */
    private static void heapSort(int[] array, int size) {
        if (size <= 1) {
            return;
        }
        TtHeap.createHeap(array, size);//建大堆
        QuickSort.swap(array,0,size -1);
        //将剩下的在建堆
        heapSort(array, size - 1);
    }
}
