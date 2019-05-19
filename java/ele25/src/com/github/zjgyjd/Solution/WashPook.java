package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
//1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
public class WashPook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grop = scanner.nextInt();

        ArrayList<int[]> result = new ArrayList<>();

        while (grop > 0) {
            int size = scanner.nextInt() * 2;
            grop--;

            int k = scanner.nextInt();

            int[] pook = new int[size];
            for (int i = 0; i < size; i++) {
                pook[i] = scanner.nextInt();

            }
            result.add(pook(pook, k));
        }

        for (int i = 0; i < result.size(); i++) {
            int[] part = result.get(i);

            for (int j = 0; j < part.length; j++) {
                if (j==part.length-1) {
                    System.out.println(part[j]);
                } else {
                    System.out.print(part[j] + " ");
                }
            }
        }


    }

    private static int[] pook(int[] pook, int k) {
        if (k == 0) {
            return pook;
        }

        int cut = pook.length / 2 - 1;

        int[] array = new int[pook.length];
        int end = pook.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                array[i] = pook[end];
                end--;
            } else {
                array[i] = pook[cut];
                cut--;
            }
        }


        return pook(array, k - 1);
    }
}
