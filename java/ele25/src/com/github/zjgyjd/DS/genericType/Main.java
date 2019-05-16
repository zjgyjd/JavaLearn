package com.github.zjgyjd.DS.genericType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static void testList(List<Integer> list) {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //[0,9]
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();//自动拆箱
            System.out.println(item);
        }

        iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item == 5) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void shallowCopy(){
        List<Test> list = new ArrayList<>();
        List<Integer> seqList = new SeqList<>();
        Test[] s = new Test[5];
        for (int i = 0; i < 5; i++) {
            list.add (new Test(8));
        }
        Test[] x = new Test[5];
        list.toArray(x);
        //Test[] x = Arrays.copyOf(s,s.length);
        x[0].x = 50;
        list.get(0).x = 70;
        System.out.println(x[0].getClass()+" "+x[1].getClass());
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(s));
        System.out.println(list);

//        new StringBuffer('i');
//        testList(seqList);
//        testList(list);
    }
    public static void main(String[] args) {


    }
}
class Test{
    public int x;

    public Test(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return Integer.toString(x);
    }
}
