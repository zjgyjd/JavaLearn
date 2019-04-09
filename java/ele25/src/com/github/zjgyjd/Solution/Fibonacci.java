package com.github.zjgyjd.Solution;

public class Fibonacci {

    /**
     *尾递归用次数来计算结果
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        return fibonacci(n,0,1);
    }


    private static int fibonacci(int n,int acc1,int acc2){
        if(n==0) return 0;
        if(n==1) return acc2;
        else     return fibonacci(n - 1, acc2, acc1 + acc2);

    }

    /*
     * 方法一：循环 时间复杂度O(n)
     */
    public int Fibonacci_1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    /*
     * 结论：F(n)=F(n-1)+F(n-2),是一个二阶递推数列，
     * 一定可以用矩阵乘法的形式表示
     * 这道题的递推矩阵为[1,1;1,0]
     */
    public int Fibonacci_2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[][] base = { { 1, 1 }, { 1, 0 } };
        int[][] res = maxtrixPower(base, n - 2);

        return res[0][0] + res[0][1];

    }

    /*
     * 求矩阵m的p次方
     */
    private int[][] maxtrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;

        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }

        return res;
    }

    /*
     * 求两个矩阵相乘
     */
    public int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;

    }
}
