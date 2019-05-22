package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class changeBubble {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;
        while (s.hasNext()) {
            num = s.nextInt();
            if (num != 0)
                System.out.println(canDrink(num));
        }
    }

    public static int canDrink(int num) {
        if (num < 2) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        int dos = num / 3;
        int some = num % 3;
        return dos + canDrink(dos + some);
    }
}
