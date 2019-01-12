package com.github.zjgyjd.Thread;

public class TestNotify {
    public static void main(String[] args) throws InterruptedException {
//一对一模式
//        Object object = new Object();
//        MyRunnable8 waitThread = new MyRunnable8(true, object);
//        MyRunnable8 notifyThread = new MyRunnable8(false, object);
//        Thread thread1 = new Thread(waitThread, "wait线程");
//        Thread thread2 = new Thread(notifyThread, "notify线程");//此时一对一
//        thread1.start();
//        Thread.sleep(1000);
//        thread2.start();

        //一对多运用notifyall
        Object object = new Object();
        MyRunnable8 waitThread1 = new MyRunnable8(true, object);
        MyRunnable8 waitThread2 = new MyRunnable8(true, object);
        MyRunnable8 waitThread3 = new MyRunnable8(true, object);
        MyRunnable8 notifyThread = new MyRunnable8(false, object);
        Thread thread1 = new Thread(waitThread1, "wait线程A");
        Thread thread2 = new Thread(waitThread2, "wait线程B");
        Thread thread3 = new Thread(waitThread3, "wait线程C");
        Thread thread4 = new Thread(notifyThread, "notify线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束!!");
    }
}

class MyRunnable8 implements Runnable {
    private boolean flag;//true-->生产 false-->消费
    private final Object object;

    MyRunnable8(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }

    private void notifyMethod() {
        synchronized (object) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "消费者开始 ");

          //  this.object.notify();//唤醒一个
            this.object.notifyAll();//唤醒多个

            System.out.println(name + "消费者结束");
        }
    }

    private void waitMethod() {
        synchronized (object) {
            while (true) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "生产者开始 ");
                try {
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "生产者结束");
            }
        }
    }
}