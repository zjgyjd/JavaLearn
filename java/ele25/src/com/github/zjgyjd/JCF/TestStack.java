package com.github.zjgyjd.JCF;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("java");
        stack.push("C++");
        stack.push("PHP");
        System.out.println("当前栈是否为空:"+stack.isEmpty());
        System.out.println("当前栈的元素个数:"+stack.size());

        //观察栈顶
        System.out.println("栈顶是否为PHP:"+"PHP".equals(stack.peek()));
        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());//此时会抛异常ESE
    }
}
