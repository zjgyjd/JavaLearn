package com.github.zjgyjd.Solution;

public class test {

    public static void main(String[] args) {
        int[] a = {4,5,6};
        sort(a);
    }

    public static void sort(int[] array) {
        int[] brr = new int[array.length];
        short1(array,brr, 0,array.length);
    }

    private static void short1(int[] array, int[] brr, int i, int length) {
        if (i == length){
            for (int j = 0; j < brr.length; j++) {
                if (brr[j] == 1){
                    System.out.print(array[j]+" ");
                }
            }
            System.out.println();
        }else {
            brr[i] = 1;
            short1(array,brr,i+1,length);

            brr[i] = 0;
            short1(array,brr,i+1,length);
        }
    }
}
