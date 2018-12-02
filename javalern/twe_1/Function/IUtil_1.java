package com.github.zjgyjd.Function;

@FunctionalInterface
public interface IUtil_1 {
    //() -> String
    String convert();//函数接口只要满足() -> String就可以使用

    public static void main(String[] args) {
        IUtil_1 iUtil1 =()->{
            return "Hello";//不同写法不同内容
        };
        //对象方法引用
        String str = "Hello";
        IUtil_1 iUtil11 = str::toUpperCase;
    }
}
