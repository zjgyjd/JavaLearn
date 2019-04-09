package com.github.zjgyjd.BookToStrings;

import java.util.*;

public class IntegerMatch {
    public static void main(String[] args) {
//        System.out.println("-1234".matches("-?\\d+"));
//        System.out.println("8888".matches("-?\\d+"));//可能有负号,所以只要没有正号就是true
//        System.out.println("+911".matches("-?\\d+"));
//        System.out.println("+911".matches("([-+])?\\d+"));//正则表达式


        Comparator<Integer> comparator =( o1, o2) -> o2-o1;


        ArrayList<Integer> a = new ArrayList();
        for (int i = 0; i <100 ; i++) {
            a.add(new Random().nextInt(1000));
        }

        Collections.sort(a,comparator);

        Iterator<Integer> iterator = a.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
}
class A implements Runnable{

    @Override
    public void run() {
        System.out.println("hello world");
    }
}