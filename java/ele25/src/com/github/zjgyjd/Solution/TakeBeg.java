package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class TakeBeg {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] want = new int[n];
        for (int i = 0; i < n; i++) {
            want[i] = s.nextInt();
        }
        System.out.println(canChoose(want,n));
    }

    private static int canChoose(int[] want, int n) {
        int[] b = new int[n];
        son(want,b,0,n);
        return count;
    }

    private static void son(int[] want, int[] b, int i, int n) {
        if(i == n){
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(b[j] == 1){
                    sum  = sum + want[j];
                }
            }
            if(sum == 40){
                count++;
            }
        }else{
            b[i] = 1;
            son(want,b,i+1,n);
            b[i] = 0;
            son(want,b,i+1,n);
        }

    }
}
