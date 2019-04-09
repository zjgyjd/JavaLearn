package com.github.zjgyjd.Thread;

public class TestWait {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(() -> {
            synchronized (object) {
                object.notify();
            }//没有这个会一直等待
        }).start();
        synchronized (object) {
            System.out.println("等待中...");
            try {
                object.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待已过...");
        }
        System.out.println("main方法结束...");
    }
}
