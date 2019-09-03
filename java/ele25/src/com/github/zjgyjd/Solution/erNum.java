package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class erNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(praseNum(num));
    }
    public static int praseNum(int num){
        int sum = 0;
        while(num != 0){
            if((num & 1) == 1){
                sum++;
            }
            num = num>>1;
        }
        return sum;
    }
}
