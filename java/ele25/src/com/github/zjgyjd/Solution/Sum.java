package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        caculNum(array, m);
    }

    public static void caculNum(int[] array, int m) {
        int[] brr = new int[array.length];
        ArrayList<String> results = new ArrayList<>();
        caculN(array, brr, 0, array.length, m,results);
//        results.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.charAt(0) > o2.charAt(0)){
//                    return 1;
//                }else {
//                    return -1;
//                }
//            }
//        });
        for (String rs :
                results) {
            System.out.println(rs);
        }
    }

    public static void caculN(int[] array, int[] brr, int start, int length, int m,ArrayList<String> results) {
        if(start == length){
            int sum = 0;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if(brr[i] == 1){
                    sum = sum + array[i];
                    result.append(array[i]);
                    if(i != length -1){
                        result.append(" ");
                    }
                }
            }
            if(sum == m){
                results.add(result.toString());
            }
        }else {
            brr[start] = 1;
            caculN(array, brr, start + 1, array.length, m ,results);

            brr[start] = 0;
            caculN(array, brr, start + 1, array.length, m ,results);
        }
    }
}
