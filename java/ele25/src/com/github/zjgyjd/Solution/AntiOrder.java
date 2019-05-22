package com.github.zjgyjd.Solution;

import java.util.Arrays;

public class AntiOrder {
    public static void main(String[] args) {
        AntiOrder s = new AntiOrder();
        int[] a = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(s.count(a,a.length));
    }
    public int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] B = Arrays.copyOfRange(A, i, n);
            count += setInt(B);
        }
        return count;
    }

    private int setInt(int[] b) {
        int hock = b[0];
        int start = 0;
        int end = b.length - 1;
        while (end - start > 0) {
            while(end - start > 0 && b[end]>=hock){
                end--;
            }
            b[start] = b[end];
            while (end - start > 0 && b[start] < hock){
                start++;
            }
            b[end] = b[start];
        }
        return start;
    }
}
