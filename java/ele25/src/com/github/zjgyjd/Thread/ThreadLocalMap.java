package com.github.zjgyjd.Thread;

public class ThreadLocalMap {
    public static void main(String[] args) {
        Runnable r = new MyRunnable2();
        Thread t1 = new Thread(r,"线程一");
        Thread t2 = new Thread(r,"线程二");
        Thread t3 = new Thread(r,"线程三");

        t1.start();
        t2.start();
        t3.start();
    }
}
class MyRunnable2 implements Runnable{
private ThreadLocal<String> t = new ThreadLocal<>();
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        t.set(name);
        System.out.println(name+" 正在获取值 "+t.get());//因为ThreadLocal属于线程所以相互独立
    }
}

class ThreadLocalTest{
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();
    public static void main(String[] args) {
        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);
        System.out.println(threadStr.get());//输出main,相互独立变量只属于当前线程
    }
}
