package com.github.zjgyjd.util;

public class TestArrayUtil {
    public static void code1(){
        Object[] array1 = {null,1,2};
        System.out.println(ArrayUtil.firstNonNull(array1));//1

        int[] array2 = null;
        System.out.println(ArrayUtil.isEmpty(array1));//false
        System.out.println(ArrayUtil.isEmpty(array2));//true
        array2 = new int[]{1,2};
        System.out.println(ArrayUtil.isEmpty(array2));//false

        Class test = Integer.class;
        Integer[] j = ArrayUtil.newArray(test,10);
        j[8] = 9;
        j[1] = 88;
        System.out.println(ArrayUtil.firstNonNull(j));
        System.out.println(ArrayUtil.getComponentType(j));

        Object[] k = {1,1.11,'S',"hello"};
        Class test1 = j.getClass().getComponentType();
        System.out.println(test1.getName());
    }
    public static void main(String[] args) {
    Parent[] test = new Parent[10];
    Object[] s = ArrayUtil.cast(son.class,test);
        System.out.println(s.getClass());
    }
}

class Parent{

}
class son extends Parent{

}