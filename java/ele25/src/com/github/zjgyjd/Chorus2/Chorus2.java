package com.github.zjgyjd.Chorus2;


import java.util.Scanner;

public class Chorus2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = scanner.nextInt();//输入能力值
        }
        int allK = scanner.nextInt();//选取人数
        int d = scanner.nextInt();//最大间隔

        long f[][] = new long[n + 1][allK + 1];
        long g[][] = new long[n + 1][allK + 1];
        //递归选取k,先定义当k = 1时
        for (int one = 1; one <= n; one++) {//此时one k个人中代表最后的一个人
            f[one][1] = arr[one];
            g[one][1] = arr[one];
        }
        for (int k = 2; k <= allK; k++) {//从k只要两人开始,先得到最优解
            for (int one = k; one <= n; one++) {//最后一个人最小值为k,他左边一个则为k-1
                Long maxTemp = Long.MIN_VALUE;
                Long minTemp = Long.MAX_VALUE;
                for (int left = Math.max(k - 1, one - d); left <= one - 1; left++) {//从选取人数减一下标或最后一个人减限制d开始
                    if (maxTemp <= Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one])) {//如果左边人和最后一人能力值一乘
                        maxTemp = Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);//如果没有g[][]无法对负数且取奇数时进行判断
                    }
                    if (!(minTemp <= Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]))) {
                        minTemp = Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);
                    }
                }
                //left循环将所有当前one的所有可能最大值算出
                f[one][k] = maxTemp;//存储当前值
                g[one][k] = minTemp;//当为负数时只考虑最小值
            }
        }
        //遍历kk这一列的所有有效行
        Long result = Long.MIN_VALUE;
        for (int one = allK; one <= n; one++) {
            if (result < f[one][allK]) {
                result = f[one][allK];
            }
        }
        System.out.println(result);
    }


}

