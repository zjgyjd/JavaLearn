package com.github.zjgyjd.Exceptions;

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
        } finally {

        }
    }
    public static void code9() {
        int i = 5;
        int j = 0;
        try{
            i++;
            int c = i/j;
            j++;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        System.out.println(i);
        System.out.println(j);
    }

    public static int div(int a, int b) throws ArithmeticException {
        int c = 0;
        try {
            c = a / b;
            return a / b;
        } catch (Exception e) {
            throw e;//被捕获异常重新抛出
        } finally {
            c = 55;
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
        code9();

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



