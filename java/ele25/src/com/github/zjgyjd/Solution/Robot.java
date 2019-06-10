package com.github.zjgyjd.Solution;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Robot {
    public static void main(String[] args) {
        int x = 3;
        int y = 2;
        System.out.println(countWays(x - 1,y-1));
    }
    private static int countWays(int x, int y) {
        if(x == 0&& y == 0){
            return 1;
        }
        int right = 0;
        if(x != 0){
            right = countWays(x-1,y);
        }
        int left = 0;
        if(y != 0){
            left = countWays(x,y-1);
        }
        return right + left;
    }
}
