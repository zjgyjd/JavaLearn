package com.github.zjgyjd.JCF;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("java");
        list.add("C++");
        list.add("PHP");
        System.out.println(list);

        list.addFirst("C");//放前面     说明这是一个双向链表
        list.addLast("javaScript");//放后面


    }
}
