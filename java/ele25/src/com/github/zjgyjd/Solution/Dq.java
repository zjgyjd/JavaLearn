package com.github.zjgyjd.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Dq {
    public int backPackII(int m, int[] A, int[] V) {
        if (A == null || V == null || m < 1 || A.length == 0 || V.length == 0) {
            return 0;
        }
        int N = A.length + 1;
        int M = m + 1;
        int[][] result = new int[N][M];
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j != M; ++j) {
                //第i个商品在A中对应的索引为i-1: i从1开始
                //如果第i个商品大于j,说明放不下， 所以(i,j)的最大价值和(i-1,j)相同
                if (A[i - 1] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    //如果可以装下，分两种情况，装或者不装
                    //如果不装，则即为(i-1, j)
                    //如果装，需要腾出放第i个物品大小的空间： j - A[i-1],装入之后的最大价值即为(i - 1,
                    //j - A[i-1]) + 第i个商品的价值V[i - 1]最后在装与不装中选出最大的价值
                    int newValue = result[i - 1][j - A[i - 1]] + V[i - 1];
                    result[i][j] = Math.max(newValue, result[i - 1][j]);
                }

            }
        }
        return result[A.length][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int[] sum = new int[n];

        for (int i = 1; i < area.length; i += 2) {
            for (int j = 0; j < area[i].length; j++) {
                sum[j] = sum[j] + area[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < sum.length ; i++){
            if(sum[i] < min){
                min = sum[i];
            }
        }
        return min;
    }
}
