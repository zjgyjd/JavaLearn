package com.github.zjgyjd.Exceptions;

public class ArrayUtils {
    public static int arrayMaxElement(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data not null");
        }
        if (data.length == 0) {
            throw new IllegalArgumentException("data not be empty");
        }
        int max = Integer.MIN_VALUE;
        for (int v : data) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        arrayMaxElement(new int[]{});
        arrayMaxElement(new int[]{12, 14, 13});
    }
}
