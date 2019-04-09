package com.github.zjgyjd.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DesignPrintStream {
    //自定义打印流
    private OutputStream outputStream;

    public DesignPrintStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(String str){
        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
    print(str);
        try {
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(int value){//基本类型同理
        println(String.valueOf(value));
    }

    public static void main(String[] args) {
        DesignPrintStream print = new DesignPrintStream(System.out);
        print.println("HelloWorld");
    }
}
