package com.github.zjgyjd.Exceptions;

import static java.lang.System.out;

class ThreeException extends Exception {
}

public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) try {
            if (count++ == 0) {
                throw new ThreeException();
            }
        } catch (ThreeException e) {
            out.println("ThreeException");
        } finally {
            out.println("In finally clause");
            if (count == 2) break;
        }
    }
}
