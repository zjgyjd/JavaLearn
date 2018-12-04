package com.github.zjgyjd.io;

public class Massage implements AutoCloseable {

    public void print(){
        System.out.println("打印");
    }
    @Override
    public void close(){
        System.out.println("关闭");
    }

    public static void main(String[] args) {
        try(Massage message =  new Massage()){
            message.print();//此时会自动调用关闭流
        }catch(Exception e){

        }
    }
}
