package com.github.zjgyjd.io;

import java.io.*;
import java.nio.file.Paths;


public class TestCharStream {
public static void write(){
    File file = Paths.get("D:","Test","java6.txt").toFile();

    try(Writer writer = new FileWriter(file)){
        writer.write("holle 666");
        writer.write(new char[]{'a','a','b','b'},2,1);
        //会在一行,'\n'来换行
    }catch (IOException e){
        System.out.println(e.getMessage());
    }
}
public static void read(){
    File file = Paths.get("D:","Test","java6.txt").toFile();
    try(Reader reader = new FileReader(file)){
        // System.out.println(reader.read());//读入一个字符,返回int,Ascll码
        char[] buffer = new char[10];
        int len = -1;
        while((len = reader.read(buffer))!=-1){
            System.out.print(new String(buffer,0,len));//不用println,这样才能打印出源内容
        }
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}

public static void byteToChar(){
    File file =Paths.get("D:","Test","outputstreamwriter.txt").toFile();
    try(FileOutputStream out = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(out)//字符流转换
    ){
        //通过字节流构造字符流要注意编码格式
        writer.write("HelloWorld");
        writer.write("科技");

    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}
    public static void main(String[] args) {

    }
}
