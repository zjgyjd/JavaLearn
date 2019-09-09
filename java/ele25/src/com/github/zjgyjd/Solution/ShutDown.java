package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class ShutDown {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] son = s.nextLine().split(" ");
        String[] f= s.nextLine().split(" ");
        String n = s.nextLine();
        int[] sons = new int[son.length];
        int[] fa = new int[f.length];
        for (int i = 0; i < son.length; i++) {
            sons[i] = Integer.parseInt(son[i]);
            fa[i] = Integer.parseInt(f[i]);
        }
        System.out.println((findNum(sons, fa, Integer.parseInt(n)) + 1));
    }
    public static int findNum(int[] k , int[] v , int n){

        //在第一个里面找到n的下标
        int i = 0;
        for (i = 0; i < v.length ; i++) {
            if(v[i] == n){//发现有子,看子有没有子
                return 1 + findNum(k , v ,k[i]);
            }
        }
        return 0;
    }
}
