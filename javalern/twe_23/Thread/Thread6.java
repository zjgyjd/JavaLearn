package com.github.zjgyjd.Thread;

public class Thread6 {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            for (int i = 0; i < 3; i++) {
                Thread.yield();//让步不会释放资源,当线程不进入阻塞而是直接回到就绪
                System.out.println(Thread.currentThread().getName()+" i= "+i);
            }
        };
        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();
        new Thread(runnable,"Thread-C").start();
    }
}
