package com.github.zjgyjd.review;

import java.util.concurrent.TimeUnit;

class JionTest implements Runnable{
    @Override
    public void run() {
        System.out.println("子线程开始执行");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行结束");
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        JionTest test1 = new JionTest();
        Thread thread1 = new Thread(test1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程_____");
    }
}
