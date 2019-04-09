package com.github.zjgyjd.DS.Sort;

public class bubble_Sort {
    public static void bubbleSort(int[] array) {
        //F(n)= n(n-1)/2;
        //O(n)=n^2;

        /*空间复杂度
            数据规模是n的情况下
            1)即额外使用的空间大小(不考虑输入/输出中用到的空间
            常见形式
            int[] array = new int[和n有关]
            递归函数   时间复杂:O(2^n) 空间复杂度:O(n)
        */
        boolean sorted = true;
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }

   public static int binarySearch(int[] array,int value){
        //O(n)=log n;
       //常见时间复杂度:O(1) O(log(n)) O(n) O(n^2)情况下
       //时间复杂度是表示运行时间的变化趋势
       //在cup单位时间内运行指令数恒定的求算法进行指令数和规模n的关系

        int right= array.length-1;
        int left = 0;
        while(left<=right){
            int mid =left+ (right-left)/2;
            if(value < array[mid]){
                right = mid-1;
            }else if(value == array[mid]){
                return mid;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 4, 1, 3};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(binarySearch(array,4));
    }
}
