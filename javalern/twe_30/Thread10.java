package com.github.zjgyjd.Thread;

public class Thread10 {
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3() ;
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThread3 implements Runnable {
    private int ticket = 10 ; // 一共十张票

//    //使用同步块
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("------------------");
//           // 在同一时刻，只允许一个线程进入代码块处理
//            synchronized(this) { // 表示为程序逻辑上锁,只有第一个进入的访问
//                if(this.ticket>0) { // 还有票
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//// TODO Auto-generated catch block
//                        e.printStackTrace();
//                    } // 模拟网络延迟
//                    System.out.println(Thread.currentThread().getName()+",还有"
//                            +this.ticket -- +" 张票");
//                }
//            }
//        }
//    }

    @Override
    public void run() {
        //使用同步块
    for (int i = 0; i < 10; i++) {
        System.out.println("--+++-----+++");
        this.sale();
    }
}
    public synchronized void sale() {
        if (this.ticket > 0) { // 还有票
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            } // 模拟网络延迟
            System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket--+ " 张票");
        }
    }

}
