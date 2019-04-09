package com.github.zjgyjd.Exceptions;

interface Message {
    //接口功能加强
    void chat();

    //聊天
    //void transportFile();//每增加方法都要修改
    //正确方法
    default void transportFile() {
        //新特性可以使用default来写普通方法
        System.out.println("暂时不支持");
    }

    //方法
    static void print() {
        //可以写静态方法
    }

}

class QQMessage implements Message {

    @Override
    public void chat() {

    }

    @Override
    public void transportFile() {

    }
}

public class class_2 {

    public static void lambda(){
        //Lambda表达式,一条命令时可以无大括号,会创建一个匿名类
        //当所创建的类有两个抽象方法时无法将其改为Lambda表达式
        //在接口处用@FunctionalInterface
        Message message = () -> {
            System.out.println("匿名");
        };
        //括号表示抽象方法的参数列表,有一个参数时括号可省略,在lambda所在的作用域下防止参数名与作用域名冲突
        //箭头后为方法执行体,若干该方法有返回值且只用一条语句则可以省去return
    }

    public static void main(String[] args) {

    }
}
