package com.github.zjgyjd.Thread;

import java.time.LocalDateTime;

public class Thread5 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName()+"执行 当前时间"+ LocalDateTime.now());//同样可以获取当前时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };
//        new Thread(() -> {
////            while (true) {
////                try {
////                    Thread.sleep(1000);
////                    System.out.println(Thread.currentThread().getName()+"执行 当前时间"+ LocalDateTime.now());//同样可以获取当前时间
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        }, "Thread-A").start();
        new Thread(runnable,"Thread-A").start();//如果加synchronized,只有一个执行,虽然sleep交出了cpu但不会释放资源
        new Thread(runnable,"Thread-B").start();
        new Thread(runnable,"Thread-c").start();
    }
}
