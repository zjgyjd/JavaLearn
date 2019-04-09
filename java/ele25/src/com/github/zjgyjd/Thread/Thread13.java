package com.github.zjgyjd.Thread;

public class Thread13 {
    //修改方法全局锁
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread5();
            thread.start();
        }
    }
}

class Sync2 {
    public void test() {
        synchronized (Sync2.class) {//全局锁
            System.out.println("test方法开始，当前线程为 " +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test方法结束，当前线程为 " +
                    Thread.currentThread().getName());
        }
    }

    public void test2() {

        System.out.println("test方法开始，当前线程为 " +
                Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test方法结束，当前线程为 " +
                Thread.currentThread().getName());

    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        Sync2 sync = new Sync2();
        sync.test();
        sync.test2();//只是被选中块被锁了这个并没有
    }
}

