package com.github.zjgyjd.Solution;

import java.util.Stack;

public class MyQueueByStack {
    Stack<Integer> stack = null;

    /**
     * Initialize your data structure here.
     */
    public MyQueueByStack() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        int num = tempStack.pop();
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
        return num;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        int num = tempStack.peek();
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
        return num;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueueByStack obj = new MyQueueByStack();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());//2
        System.out.println(obj.peek());//3
        System.out.println(obj.empty());//false
    }
}
