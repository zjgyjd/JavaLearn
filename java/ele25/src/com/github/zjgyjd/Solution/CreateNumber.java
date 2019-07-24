package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class CreateNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = Integer.parseInt(s.nextLine());
            HashSet<String> number = new HashSet<>();
            String[] m = new String[n];
            for (int i = 0; i < n; i++) {
                m[i] = s.nextLine();
            }
            number =  thinkNum(m , number);
            ArrayList<String> sort = new ArrayList<>();
            sort.addAll(number);
            sort.sort((o1, o2) -> {
                for(int i = 0 ; i < o1.length() ; i++){
                    if(o1.charAt(i) == '-'){
                        continue;
                    }
                    if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }else if (o1.charAt(i) < o2.charAt(i)){
                        return -1;
                    }
                }
                return 0;
            });
            for (String t :
                    sort) {
                System.out.println(t);
            }
            System.out.println();

        }
    }

    public static HashSet<String> thinkNum(String[] m , HashSet<String> num) {
        for (int i = 0; i < m.length; i++) {
            char[] target = m[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m[i].length(); j++) {
                if (target[j] >= '0' && target[j] <= '9') {
                    sb.append(target[j]);
                } else if (target[j] != '-') {
                    int source = target[j] - 'A';
                    int number = source / 3 + 2;
                    if (source == 18 || source == 21 || source == 24 || source == 25) {
                        number = number - 1;
                    }
                    sb.append(String.valueOf(number));
                }
                if(sb.length() == 3){
                    sb.append('-');
                }
            }
            num.add(sb.toString());
        }
        return num;
    }
}
