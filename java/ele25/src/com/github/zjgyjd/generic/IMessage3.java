package com.github.zjgyjd.generic;

public interface IMessage3<T> {
    void print(T t);

    public static void code1() {
        //匿名内部类实现接口
        IMessage3<String> iMessage = new IMessage3<String>() {
            @Override
            public void print(String t) {
                System.out.println(t);
            }
        };
    }

    public static void main(String[] args) {
    //定义:泛型信息存在于编译阶段,运行会类型擦除
        IMessageTmp2<String> massage1 = new IMessageTmp2<>();
        massage1.print("66666");
    }
}

class IMessageTmp1 implements IMessage3<String> {
    //直接实现类型
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

class IMessageTmp2<T> implements IMessage3<T> {
    //保留在用的时候在决定
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}