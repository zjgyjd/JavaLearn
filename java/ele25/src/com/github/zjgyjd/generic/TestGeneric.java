package com.github.zjgyjd.generic;

public class TestGeneric {
    public static void code1(){
        //未使用泛型时
        Point intPoint = new Point(10,20);
        int intX = (int)intPoint.getX();//Object-->需要int强转
    }
    public static void main(String[] args) {

    }

}
