package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class Chorus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = scan.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = scan.nextInt();
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
