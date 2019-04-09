package com.github.zjgyjd.Solution;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
//        if(!stack2.isEmpty()){
//            stack2.pop();
//        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.push(4);
        stackToQueue.push(5);
        System.out.print(stackToQueue.pop()+" ");
        System.out.print(stackToQueue.pop()+" ");
        System.out.print(stackToQueue.pop()+" ");
        System.out.print(stackToQueue.pop()+" ");
        System.out.print(stackToQueue.pop()+" ");

    }
}
