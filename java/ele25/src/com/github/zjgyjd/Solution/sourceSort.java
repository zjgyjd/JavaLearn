package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class sourceSort {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int select = Integer.parseInt(s.nextLine());

        String[] stu = new String[n];
        for(int i = 0 ; i < n ; i++){
            stu[i] = s.nextLine();
        }
        stu = selectSort( stu , select );
        for(int i = 0 ; i < n ; i++){
            System.out.println(stu[i]);
        }
    }
    public static String[] selectSort(String[] stu , int select){
        int[] num = new int[stu.length];
        for(int i = 0; i < stu.length ; i++){
            num[i] = Integer.parseInt(stu[i].split(" ")[1]);
        }
        if(select != 0){//降序
            for(int i = 0; i < num.length ; i++){
                for(int j = 1; j < num.length - i ; j++){
                    if( num[j - 1] >= num[j]){
                        String t;
                        t = stu[j - 1];
                        stu[j - 1] = stu[j];
                        stu[j] = t;//换原数据
                        int temp;
                        temp = num[j - 1];
                        num[j - 1] = num[j];
                        num[j] = temp;//换数字
                    }
                }
            }
        }else{//升序
            for(int i = 0; i < num.length ; i++){
                for(int j = 1; j < num.length - i ; j++){
                    if( num[j - 1] < num[j]){
                        String t;
                        t = stu[j - 1];
                        stu[j - 1] = stu[j];
                        stu[j] = t;//换原数据
                        int temp;
                        temp = num[j - 1];
                        num[j - 1] = num[j];
                        num[j] = temp;//换数字
                    }
                }
            }
        }
        return stu;
    }
}
