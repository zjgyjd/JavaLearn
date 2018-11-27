package com.github.zjgyjd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class class_1 {
    public static void code1(int x, int y) {
        System.out.println("Begin");
        try {
            System.out.println(x / y);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("yuejie");
        } catch (NumberFormatException e) {
            System.out.println("not number");
        } catch (ArithmeticException e) {
            System.out.println("not zero");
        } finally {
            System.out.println("Finally");
        }
        System.out.println("end");
    }

    public static void code2() {
        File file = new File("D:\\ab.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int div(int a, int b) throws ArithmeticException {
        try {
            return a / b;
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public static void code3() {
        try {
            div(10, 2);
            div(10, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void code4() {
        int a = 53;
        //默认不开启 java -ea开启

        assert a == 55;//true才往下走
        System.out.println("断言成功");
    }


    public long add(long a, long b) {
        long value = a + b;
        if (value == 500) {
            throw new AddException();
        } else {
            return value;
        }
    }

    public static void main(String[] args) {
        try {
            Gender gender = Gender.valueOf(args[0]);
            System.out.println(gender);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

enum Gender {
    FAMALE("男"), MALE("女");//要实例化对象,没有打分号
    private String type;

    Gender(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class AddException extends RuntimeException {

}