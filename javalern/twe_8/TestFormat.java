package com.github.zjgyjd.io;

public class TestFormat {
    public static void code1(){
        System.out.printf("%s","hello");//格式化
        //正数右对齐,负数左对齐
        System.out.printf("姓名: %4s,年龄: %-4d","hhhhh",18);
        //System:lang包下面的一个类
        //out:是一个对象 Object java.io.PrintStream  打印流
        //println:out,即PrintStream调用的一个成员方法
        System.err.println();//同样是打印流且为System的一个静态属性
       // System.in.read();//in输入InputStream
    }
    public static void main(String[] args) {

    }
}
