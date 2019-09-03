package com.github.zjgyjd.Solution;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SpecialDistance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String target = s.nextLine();
        String[] num = target.split(",");
        HashSet<Integer> num1 = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            String num2 = num[i].trim();
            num1.add(Integer.parseInt(num2));
        }
        int sum = 0;
        int[] result = new int[num1.size()];
        int i = 0;
        for (Integer temp:num1
             ) {
            result[i] = temp;
            i++;
        }
        for(i = 0 ; i < result.length ; i++){
            for (int j = i + 1; j < result.length; j++) {
                if(result[i] + result[j] == 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
