package com.github.zjgyjd.Thread;

public class Thread8 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "子线程A");
        thread1.start();
        Thread.sleep(2000);
        myThread.setFlag(false);
        System.out.println("代码结束");
    }
}

class MyThread implements Runnable {
    //通过标记位的方式终止线程
    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println("第" + i + "次线程:" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
