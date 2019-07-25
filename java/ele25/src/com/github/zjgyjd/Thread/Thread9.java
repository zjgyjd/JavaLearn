package com.github.zjgyjd.Thread;

public class Thread9 {
    public static void main(String[] args) {
        //主线程的优先级
        System.out.println("主:" + Thread.currentThread().getPriority());
        //此时如果在线程里创建线程,默认优先级和外部相同

        //判断是否是守护线程,守护线程例如垃圾回收器,只要当前JVM进程中存在任何一个非守护线程没有结束，
        // 守护线程就在工作；只有当最后一个非守护线程结束时，守护线程才会随着JVM一同停止工作。
        System.out.println(Thread.currentThread().isDaemon());//false说明主线程是非守护线程,为用户线程
        //可以创建一个线程守护线程
        Thread threadA = new Thread(new A(),"ThreadTest-A");
        threadA.setDaemon(true);//变为守护,要一直执行到主线程结束
        threadA.start();

        Thread threadB = new Thread(new A(),"ThreadTest-B");
        threadB.start();

        try {
            Thread.sleep(3000);
            threadB.interrupt();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A implements Runnable {
    private int i;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("线程名称：" + Thread.currentThread().getName() +
                        ",i=" + i + ",是否为守护线程:"
                        + Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            //当线程中断标识为true,且进入阻塞则抛此异常
            System.out.println("线程名称：" + Thread.currentThread().getName() + "中断线程了");
        }
    }
}