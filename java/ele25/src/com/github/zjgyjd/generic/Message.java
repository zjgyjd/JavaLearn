package com.github.zjgyjd.generic;

public class Message<T> {//T为参数类型
    private T message;
    //此时泛型方法和泛型类相互独立,类上的T和方法T没有任何联系,即在new时定义的<T>并不能限制方法类型

    public Message(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public static <T,S> void print(T data, S value){
        //参数泛型
        System.out.println(data+","+value);
    }
    public static <T> T convert(T data){
        //参数类型 返回值均为泛型
        return data;//T称为参数化类型
    }
}
