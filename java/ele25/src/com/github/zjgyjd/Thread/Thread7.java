package com.github.zjgyjd.Thread;

public class Thread7 {
    public static void main(String[] args) {
        //业务逻辑
        MyRunnable runnable = new MyRunnable();
        //线程
        Thread thread = new Thread(runnable,"ThreadTest-A");
        thread.start();
        //在主线程中调用线程对象的join方法,会阻塞主线程
        //直到执行完毕,主线程才会继续执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前线程: "+Thread.currentThread().getName());//main
    }
}
class MyRunnable implements Runnable{
private int tick = 100;
    @Override
    public void run() {
        while (tick>0){
            System.out.println(Thread.currentThread().getName()+" tick = "+tick--);
        }
    }
}
