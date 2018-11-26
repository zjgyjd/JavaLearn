package com.github.zjgyjd;

public class Test {
    private Object data;
    private Test next;

    public Test(Object data, Test next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Test getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Test next) {
        this.next = next;
    }
}