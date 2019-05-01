package com.github.zjgyjd.DS.Sort;

public class MergeSort {
    private static void mergeSortInner(int[] array, int low, int high, int[] extra) {

        //左闭右开
        if (low >= high - 1) {
            return;
        }

        //平均切开
        int mid = low + (high - low) / 2;

        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        //将两个连起来
        merge(array, low, mid, high, extra);
    }

    private static void merge(int[] array, int low, int mid, int high, int[] extra) {
        int i = low; //遍历从[low,mid)
        int j = mid; // 遍历[mid, high)
        int x = 0;  // 遍历extra

        while (i < mid && j < high) {
            if (array[i] <= array[j]) {
                extra[x++] = array[i++];
            } else {
                extra[x++] = array[j++];
            }
        }

        while (i < mid) {
            extra[x++] = array[i++];
        }

        while (j < mid) {
            extra[x++] = array[j++];
        }

        for (int k = low; k < high; k++) {
            array[k] = extra[k - low];
        }
    }

    public static void mergeSortNotR(int[] array) {
        int[] extra = new int[array.length];
        for (int i = 1; i < array.length; i *= 2) {
            for (int j = 0; j < array.length; j += 2 * i) {
                    int low = j;
                    int mid=j+i;
                    if(mid >= array.length){
                        continue;
                    }
                    int high = mid +i;
                    if(high > array.length){
                        high = array.length;
                    }
                    merge(array,low,mid,high,extra);
            }
        }
    }

    public static void mergeSort(int[] array) {
        int[] extra = new int[array.length];
        mergeSortInner(array, 0, array.length, extra);
    }
}
