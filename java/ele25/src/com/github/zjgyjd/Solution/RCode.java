package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class RCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = null;
        String b = null;
        if (scanner.hasNext()) {
            a = scanner.nextLine();
        }

        if (scanner.hasNext()) {
            b = scanner.nextLine();
        }
        if (a != null && b != null) {
            System.out.println(rcount(a.toCharArray(), b.toCharArray()));
        } else {
            System.out.println(0);
        }
    }

    private static int rcount(char[] a, char[] b) {
        char[] plat = new char[a.length + b.length];
        int count = 0;
        for (int j = 0; j < b.length; j++) {
            if (b[j] < 'a' || b[j] > 'z') {
                return 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 'a' || a[i] > 'z') {
                return 0;
            }
            System.arraycopy(a, 0, plat, 0, i);
            System.arraycopy(b, 0, plat, i, b.length);
            System.arraycopy(a, i, plat, i + b.length, a.length - i);
            if (isR(plat)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isR(char[] plat) {
        int start = 0;
        int end = plat.length - 1;
        while (end - start > 0) {
            if (plat[end--] != plat[start++]) {
                return false;
            }
        }
        return true;
    }
}
