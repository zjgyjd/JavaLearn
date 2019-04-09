package com.github.zjgyjd.Thread;

public class Thread12 {
    public static void main(String[] args) {
        Sync sync = new Sync();//叫做使用对象锁

        for (int i = 0; i < 3 ; i++) {
            MyThread4 thread = new MyThread4() ;
            thread.setSync(sync);
            thread.start();
        }
    }
}

class Sync {
    public synchronized void test() {
        System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
    }
}

class MyThread4 extends Thread {
    public void setSync(Sync sync) {
        this.sync = sync;
    }

    //将其改为属性,变为同一个对象,在main方法中传入
    private Sync sync ;


    @Override
    public void run() {
        //Sync sync = new Sync();//这样会造成相互不干扰,因为同步是针对同一个对象,多个对象不会被同步
        sync.test();
    }
}