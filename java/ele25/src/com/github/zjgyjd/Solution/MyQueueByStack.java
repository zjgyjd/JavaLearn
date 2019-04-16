package com.github.zjgyjd.Solution;

import java.util.Stack;

public class MyQueueByStack {
    private Stack<Integer> stack = null;

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
        System.out.println("-------------------------------------------");
        MyCircularQueue j = new MyCircularQueue(3);
        System.out.println(j.enQueue(1));//true
        System.out.println(j.enQueue(2));//true
        System.out.println(j.enQueue(3));//true
        System.out.println(j.enQueue(4));//false
        System.out.println(j.Rear());//3
        System.out.println(j.isFull());//true
        System.out.println(j.deQueue());//true
        System.out.println(j.enQueue(4));//true
        System.out.println(j.Rear());//4

    }
}

class MyCircularQueue {

    private int[] array;
    private int tail;
    private int top;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        array = new int[k + 1];
        tail = 0;
        top = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        array[tail] = value;
        if (tail == array.length - 1) {
            tail = 0;
        } else {
            tail++;
        }


        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        array[top] = 0;
        if (top == array.length) {
            top = 0;
        } else {
            top++;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return array[top];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        if (tail == 0) {
            return array[array.length - 1];
        }
        return array[tail - 1];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (tail == top) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if ((tail + 1) == array.length) {
            if (top == 0) {
                return true;
            }
        }
        if ((tail + 1) == top) {
            return true;
        }
        return false;
    }
}