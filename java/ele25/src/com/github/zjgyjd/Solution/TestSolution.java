package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class TestSolution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] target = s.nextLine().split(" ");
        int m = Integer.parseInt(target[1]);
        String[] source = s.nextLine().split(" ");
        int[] t = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            t[i] = Integer.parseInt(source[i]);
        }
        double maxAvg = 0 ;
        for (int i = m; i <= source.length; i++) {
            int temp = maxStr(t, i);
            double avg = (double)temp /(double) i;
            if (avg > maxAvg) {
                maxAvg = avg;
                
            }
        }
        System.out.format("%.3f\n", maxAvg);
    }

    public static int maxStr(int[] t, int n) {
        int maxSum = 0;
        int i = 0;
        while (true) {
            int sum = 0;
            for (int j = i; j < n + i; j++) {
                sum += t[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
            i = i + 1;
            if (i + n >= t.length) {
                break;
            }
        }
        return maxSum;
    }
}
