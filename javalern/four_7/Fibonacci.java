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
}
