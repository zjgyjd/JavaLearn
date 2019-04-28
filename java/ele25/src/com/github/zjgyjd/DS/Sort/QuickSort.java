package com.github.zjgyjd.DS.Sort;

public class QuickSort {
    /**
     * 快速排序未做的优化
     * 如果排序的数据长度 <= 20,用插入排序
     * 做partition的时候,把和基准值相等的数也处理出来,这样可加快区间缩减
     * @param array
     * @param left
     * @param right
     */
    private static void quickSortInner(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        if (left > right) {
            return;
        }
        //找基准值,返回
        //遍历分区间,直到size==1或size == 0
        int pivoindex = partition1(array, left, right);
        //现在分成了三部分(分治算法)
        //再次处理左半部分
        quickSortInner(array, left, pivoindex - 1);
        //再次处理有半部分
        quickSortInner(array, pivoindex + 1, right);
    }

    /**
     * 进行分段,小的在左,大的在右
     * 两个下标一头一尾开始走
     * 注意基准值在右边就要从左先走,不然就会出现没有比较过的数
     * <p>
     * 时间复杂苏: 快速排序  O(log n * n) [最好]  O(n)[最坏]
     * 空间复杂度            O(log n)            O(n)
     * 选边上作为基准值时,如果数组有序或者逆序都是最坏情况
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition1(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            //此时array[begin] > pivot
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            //此时array[end] < pivot
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            //当两个都走不动时,交换两个数时循环继续,直到begin == end
            swap(array, begin, end);
        }
        swap(array, begin, right);
        return begin;
    }

    private static int partition2(int[] array, int left, int right) {
        //先找出空位
        int hock = array[right];
        //将比它大的放过去
        int begin = left;
        int end = right;
        while (begin < end) {
            while (begin < end && array[begin] <= hock) {
                begin++;
            }
            array[end] = array[begin];

            while (begin < end && array[end] <= hock) {
                end--;
            }
            array[begin] = array[end];
        }
        array[begin] = hock;
        return begin;
    }

    //前后下标版本
    private static int partition3(int[] array, int left, int right) {
        int d = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                swap(array, i, d);
                d++;
            }
        }

        swap(array, d, right);
        return d;
    }

    //三数取中找基准值,最左边,最右边,中间数
    private static int sanShuQuZhong(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] > array[right]) {
            if (array[left] < array[mid]) {
                return left;
            } else if (array[left] > array[mid]) {
                if(array[right] > array[mid]){
                    return right;
                }else{
                    return mid;
                }
            }
        }else {
            int temp = right;
            if (temp < array[mid]) {
                return right;
            } else if (array[right] > array[mid]) {
                if(array[left] > array[mid]){
                    return left;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void swap(int[] array, int begin, int end) {
        int t = array[begin];
        array[begin] = array[end];
        array[end] = t;
    }


    public static void quickSort(int[] array) {
        quickSortInner(array, 0, array.length - 1);
    }
}
