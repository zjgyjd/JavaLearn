package com.github.zjgyjd.Thread;

public class Thread3 extends Thread {
    private static int tick = 10;

    @Override
    public void run() {
        while (tick > 0) {
            System.out.println(this.getName() + "剩余: " + tick-- + "张票");
        }
    }

    public static void main(String[] args) {
//        Thread3 thread1 = new Thread3();
//        thread1.setName("Thread-A");
//        Thread3 thread2 = new Thread3();
//        thread2.setName("Thread-B");//此时票数相互没有干扰,除非将属性改为静态
//        thread1.start();
//        thread2.start();

        //如果使用Runnable则不一样,容易共享
        Runnable runnable = new Runnable() {
            private int tick =10;
            @Override

                public void run() {
                    while (tick > 0) {//currentThread获取当前线程
                        System.out.println(Thread.currentThread().getName()+ "剩余: " + tick-- + "张票");
                    }
                }

        };
        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();

    }
}
