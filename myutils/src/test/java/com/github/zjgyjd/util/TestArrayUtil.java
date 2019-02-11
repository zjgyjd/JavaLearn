package com.github.zjgyjd.util;

import java.lang.reflect.Array;

public class TestArrayUtil {
    public static void code1() {
        Object[] array1 = {null, 1, 2};
        System.out.println(ArrayUtil.firstNonNull(array1));//1

        int[] array2 = null;
        System.out.println(ArrayUtil.isEmpty(array1));//false
        System.out.println(ArrayUtil.isEmpty(array2));//true
        array2 = new int[]{1, 2};
        System.out.println(ArrayUtil.isEmpty(array2));//false

        Class test = Integer.class;
        Integer[] j = ArrayUtil.newArray(test, 10);
        j[8] = 9;
        j[1] = 88;
        System.out.println(ArrayUtil.firstNonNull(j));
        System.out.println(ArrayUtil.getComponentType(j));

        Object[] k = {1, 1.11, 'S', "hello"};
        Class test1 = j.getClass().getComponentType();
        System.out.println(test1.getName());
        Parent[] test12 = new Parent[10];
        Object[] s = ArrayUtil.cast(son.class, test);
        System.out.println(s.getClass());

    }

    public static void code2() {
        String[] insert = {"Ok", "HaHa", "HeHe", "Java", "C++", "Go", null, null, null};
        System.out.println(insert.length);
        Object[] change = ArrayUtil.insert(insert, -7, "PP");
        Object[] change3 = null;
        Object[] change1 = ArrayUtil.insert(insert, 7, "PP");
        Object[] change2 = ArrayUtil.addAll(change, change1, change3);

        for (Object s : change
        ) {
            System.out.println(s);
        }

        for (Object s : change1) {
            System.out.println(s);
        }
        for (Object s : change2
        ) {
            System.out.println(s);
        }
    }

    public static void code3() {
        int[] range = ArrayUtil.range(-5, -3);
        int[] range2 = ArrayUtil.range(-6, -3, 2);

        for (int s : range
        ) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("长度为" + range2.length);
        for (int s : range2) {
            System.out.println(s);
        }
    }

    public static void code4() {
        byte[] temp = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        byte[][] split = ArrayUtil.split(temp, 2);
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split[i].length; j++) {
                System.out.print(split[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] test = {
                0,1,2,3,4,5,6,7,8,9
        };
        Object[] testEnd0 =  ArrayUtil.getAny(test,2,6);
        Integer[] testEnd1 = (Integer[]) ArrayUtil.sub(test,2,6);

        for (Object s: testEnd0
        ) {
            System.out.println(s);
        }
        System.out.println();
        for (Object s: testEnd1
             ) {
            System.out.println(s);
        }
    }
}

class Parent {

}

class son extends Parent {

}