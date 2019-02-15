package com.github.zjgyjd.util;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;

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

    public static void code5() {
        Integer[] test = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        Object[] test2 = new Object[1];
        long[] test3 = {1, 2, 3, 4, 5, 6};
        Object[] testEnd0 = ArrayUtil.getAny(test, 2, 6);
        Integer[] testEnd1 = (Integer[]) ArrayUtil.sub(test, 2, 6);
        System.out.println(ArrayUtil.length(test2));

        System.out.println(ArrayUtil.join(test3, "*"));
        System.out.println(ArrayUtil.toString(testEnd0));
        System.out.println(ArrayUtil.toString(testEnd1));
        System.out.println(ArrayUtil.toString(test2));
    }

    public static void code6() {
        byte[] s = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10};
        ArrayList<Byte> test1 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            test1.add(s[i]);

        }
        System.out.println(test1.get(0).getClass());
        Class test3 = test1.get(0).getClass();
        System.out.println(Byte.class);
        Byte[] end = ArrayUtil.toArray(test1, test3);

        System.out.println(ArrayUtil.toString(end));
        ByteBuffer test = ByteBuffer.allocate(10);
        test.put(s);
        System.out.println(ArrayUtil.toString(ArrayUtil.toArray(test)));
    }

    public static void main(String[] args) {
        byte[] test0 = {1,2,3,5,8,6,8};
        byte[] end0 =  ArrayUtil.remove(test0,4);
        long[] test1 = {1,2,3,4,5,6,7,8,9};
        long[] end1 = ArrayUtil.removeEle(test1,10);
        byte[] test5 = new byte[0];
       Object array = Array.newInstance(Object.class,0);
        System.out.println(array.getClass().isArray());

        Byte[] test2 = {1,2,3,4,56,8,9,10};
        Byte[] end2 = (Byte[]) ArrayUtil.removeEle(test2, (byte) 56);
        Byte[] end2_0 = ArrayUtil.reverse(test2,2,5);
        Integer[] test3 = {8,7,6,5,4,3,2,1,0};

        System.out.println(ArrayUtil.isEmpty(test5));
        System.out.println(ArrayUtil.toString(ArrayUtil.swap(test3,0,1)));
        System.out.println(ArrayUtil.min(test3));
        System.out.println(ArrayUtil.toString(ArrayUtil.reverse(test3)));
        System.out.println(ArrayUtil.toString(end1));
        System.out.println(ArrayUtil.toString(end2));
        System.out.println(ArrayUtil.toString(end2_0));

        System.out.println(ArrayUtil.toString(end0));
        System.out.println(ArrayUtil.toString(test0));
    }
}

class Parent {

}

class son extends Parent {

}