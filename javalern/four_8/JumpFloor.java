package com.github.zjgyjd.Solution;


public class JumpFloor {
    /*
    青蛙一次可以跳一节或者两节台阶,跳上n级台阶有几种跳法
    该方法是一个斐波那契数列
     */
    public int Jump(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int jumpSum = 0;
        int jumpSumBackStep1 = 2;
        int jumpSumBackStep2 = 1;
        for (int i = 3; i < n; i++) {
            jumpSum = jumpSumBackStep1 + jumpSumBackStep2;
            jumpSumBackStep2 = jumpSumBackStep1;
            jumpSumBackStep1 = jumpSum;
        }
        return jumpSum;
    }

    /*
     * 青蛙一次可以跳一节或者两节或者跳到n台阶,跳上n级台阶有几种跳法
     *f(n)= f(n-1) + f(n-2) +.....+f(n-n);
     * f(n-1) =  f(n-2) +.....+f(n-n);
     *f(n) = 2 * f(n-1);
     * */
    public int Jump1(int n) {
        if (n <= 0) {
            return 0;
        }
        return 1 << (n - 1);
    }

    public static void main(String[] args) {
        JumpFloor frog = new JumpFloor();
        System.out.println(frog.Jump(10));
        System.out.println(frog.Jump1(10));
    }

}
