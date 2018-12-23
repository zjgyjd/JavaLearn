package com.github.zjgyjd.Thread;

public class Thread1 extends Thread {
    private final String title;

    public Thread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        //多线程逻辑
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title+i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("线程1 ");
        //thread1.run();不启动线程只是方法调用
        thread1.start();

        Thread1 thread2 = new Thread1("线程2 ");
        //thread2.run();//此时会顺序输出
        thread2.start();//此时才会启动线程,而且线程只能启动一次,之后再启动会抛出异常
    }
}
