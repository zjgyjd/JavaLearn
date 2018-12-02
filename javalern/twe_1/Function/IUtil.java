package com.github.zjgyjd.Function;

@FunctionalInterface
public interface IUtil {
    String convert(Integer value);

    public static void main(String[] args) {
        IUtil iUtil = (value)->{
            return String.valueOf(value);
        };
        //Integer ->String y =f(x)
        //Stirng.valueOf() 相同

        IUtil iUtil1 = String::valueOf;//静态方法引用
    }
}
