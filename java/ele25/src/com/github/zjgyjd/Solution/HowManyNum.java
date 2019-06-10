package com.github.zjgyjd.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class HowManyNum {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            count(s.nextInt());
        }
    }
    static int[] array = null;
    public static void count(int n){
        int count = 0;
        split(count,n);
        Arrays.sort(array);

        for(int i = 0;i < array.length;){

            int c = 0;
            int result = array[i];
            System.out.print(result+":");
            while(i < array.length && result == array[i]){
                i++;//2
                c++;// 2
            }
            System.out.println(c);
        }
    }
    public static void split( int count ,int n){
        if(n / 10 == 0){
            array = new int[count + 1];
            array[count] = n % 10;
            return;
        }
        split(count + 1,n / 10);
        if(array == null){
            System.out.println("null");
        }else{

        array[count] = n % 10;

        }
    }
}
