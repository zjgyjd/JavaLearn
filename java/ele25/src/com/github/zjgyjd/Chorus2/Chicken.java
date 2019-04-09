package com.github.zjgyjd.Chorus2;

import java.util.Scanner;

public class Chicken {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] food = new String[2500];
        StringBuilder fs = new StringBuilder();
        String s;
        for (int i = 0; i <  50&& scanner.hasNext(); i++) {
            s = scanner.nextLine();
            fs.append(s);
            fs.append(" ");
        }

        s = fs.toString();
        char[] ss = s.toCharArray();
        char[] c = null;
        int j = 0;
        int k = 0;
        for (int i = 0; i < ss.length; i++) {
            if (c == null) {
                c = new char[50];
            }
            if (ss[i] != ' ') {
                c[k] = ss[i];
                k++;
            } else {
                    if (checkFood(food, c)) {
                        food[j] = new String(c);
                        j++;
                    }
                    c = null;
                    k = 0;
            }
        }
        k = 0;
        for (int i = 0; i < food.length; i++) {
            if(food[i]!=null){
                k++;
            }
        }
        System.out.println(k);
    }

    public static Boolean checkFood(String[] f, char[] c) {
        String x = new String(c);
        if(f == null&&f.length==0){
            return true;
        }
        for (int i = 0;i<f.length&&f[i]!=null; i++) {
            if (f[i].equals(x)) {
                return false;
            }
        }
        return true;
    }
}
