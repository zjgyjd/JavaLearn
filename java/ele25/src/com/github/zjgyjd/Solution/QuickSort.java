package com.github.zjgyjd.Solution;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[ ]{1,3,5,2,2};
        System.out.println(findKth(a,5,2));
    }
    public static int findKth(int[] a, int n, int K) {
        if (K > n) {
            return -1;
        }
        quick(a,0,a.length);
        System.out.println(Arrays.toString(a));
        return a[n-K];
    }

    private static void quick(int[] a,int start,int end) {
        if (a == null || end -start <= 1) {
            return;
        }
        int part = cularPart(a,start,end);

        quick(a, 0, part);

        quick(a, part + 1, end);
    }

    private static int cularPart(int[] a,int start,int end) {
        end = end - 1;
        int temp = a[end];
        while (end - start > 0) {
            while (end - start > 0 && a[start] <= temp) {
                start++;
            }
            a[end] = a[start];
            while (end - start > 0 && a[end] >= temp) {
                end--;
            }
            a[start] = a[end];
        }
        a[start] = temp;
        return start;
    }
}
