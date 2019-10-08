package com.github.zjgyjd.DS.Sort;

public class InsertSort {
    /**
     * 时间复杂度: O(n^2)[最坏]
     * 当数据有序时:O(n)[最好情况]
     *
     * @param array 空间复杂度:O(1)
     *              稳定
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //有序区间遍历查找
            int j;
            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {

            }
            //j+1就是要插入下标
            int key = array[i];
            for (int k = i; k > j + 1; k--) {
                array[k] = array[k - 1];
            }
            array[j + 1] = key;//所有进行移动到指定位置
        }
    }

    public static void insertSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0 && key < array[j]; j = j - gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

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
    public static void insertShell(int[] array){
        int gap = array.length;
        while(true){
            gap = (gap / 3) + 1;

            insertSortWithGap(array,gap);
            if(gap ==1){
                break;
            }
        }
    }
}
