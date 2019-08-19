package com.github.zjgyjd.Solution;

import java.util.Arrays;

public class SonString {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            result[i] = isContain(s, p[i]);
        }
        return result;
    }

    public boolean isContain(String s, String p) {
        char[] own = s.toCharArray();
        char[] co = p.toCharArray();
        for (int i = 0; i < own.length; i++) {
            int j = 0;
            int i1 = i;
            while (i1 < own.length && own[i1] == co[j]) {
                if (j == co.length - 1) {
                    return true;
                }
                j++;
                i1++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[] result = new SonString().chkSubStr(new String[]{
                "ba", "bc", "ca", "de", "ag", "aab"
        }, 6, "aaabaaaaacdefg");

        int result_1 = new SonString().MaxSubSequence(new int[]{
                -2, 11, -4, 13, -5, -2
        });

        int result_2 = new SonString().downTower(new int[][]{
                {5}, {8, 4}, {3, 6, 9}, {7, 2, 9, 5}
                //13
        }, 1);

        System.out.println(Arrays.toString(result));
        System.out.println(result_1);
        System.out.println(result_2);
    }

    /**
     * 求一个数列中最大连续子序列的和。
     * 例如:
     * { -2, 11, -4, 13, -5, -2 }
     * 则最大的连续序列为:
     * {11,-4,13}
     * 状态转移方程:F~k~= max{F~k-1~ + A~k~,A~k~}   F~k~是前k项的最大子序列和,A~k~是当前k项的值,
     * 为方便起见，如果所有整数均为负数，则最大子序列和为0。
     */
    public int MaxSubSequence(int[] array) {
        int kSum;
        int MaxSum;
        int i = 0;
        kSum = MaxSum = 0;
        for (; i < array.length; ++i) {
            kSum += array[i];
            if (kSum > MaxSum) {
                MaxSum = kSum;
            } else if (kSum < 0) {
                kSum = 0;
            }
        }
        return MaxSum;
    }

    /**
     * 数塔取数问题
     * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
     * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
     * <p>
     * 该三角形第n层有n个数字，例如：
     * <p>
     * 第一层有一个数字：            5
     * <p>
     * 第二层有两个数字：          8   4
     * <p>
     * 第三层有三个数字：        3   6   9
     * <p>
     * 第四层有四个数字：      7   2   9   5
     * <p>
     * 最优方案是：5 + 8 + 6 + 9 = 28
     * ```
     * 将问题进行转换 :
     * 找到每一层大的最优子序列:
     * 利用i 表示行 , j表示列,利用F~i,j~表示第i行第j列项的最大取数和,则这个问题就变成了求第n行的F~n,m~这m个中的最大值?
     * 状态转换方程
     * F~i,j~ = max{F~i-1,j~ ,F~i - 1,j - 1~ }+ A ~i,,j~;
     *
     * @param array 提供的塔
     * @param n     想要到达的层
     * @return
     */
    public int downTower(int[][] array, int n) {
        int kmax = 0;
        int max = 0;
        int[][] result = new int[n][n];//存储每一步的最优解
        //需要对边界进行判断
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != 0 && j != 0) {
                    kmax = result[i - 1][j - 1];
                    if (j < i && kmax < result[i - 1][j]) {
                        kmax = result[i - 1][j];
                    }
                } else if (j < i && i != 0) {
                    kmax = result[i - 1][j];
                }
                result[i][j] = kmax + array[i][j];
                max = Math.max(result[i][j], max);
            }
        }
        return max;
    }
}
