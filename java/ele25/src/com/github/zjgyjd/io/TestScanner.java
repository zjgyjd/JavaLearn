package com.github.zjgyjd.io;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestScanner {
    public static void code1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        if (scanner.hasNext()) {//判断师傅有下一个
            System.out.println(scanner.next());
        }
        scanner.close();
    }

    public static void code2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        while (true) {

            if (scanner.hasNextInt()) {//判断是否有下一个,可以选择各种类型
                System.out.println(scanner.next());
                break;
            } else {
                System.out.println("输入不是数字");
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void code3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        while (true) {
            if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {//输入正则表达式
                System.out.println(scanner.next());
                break;
            } else {
                System.out.println("输入不是生日");
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        //Scanner构造方法中传入文件可以替代BufferReader
        try(  Scanner scanner = new Scanner(Paths.get("D:","Test","javaStudent"));){
          scanner.useDelimiter("\n");//用反斜杠分隔
          while (scanner.hasNext()){
              System.out.println(scanner.next());
          }
        }

    }
}
