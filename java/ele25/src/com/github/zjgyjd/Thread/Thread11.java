package com.github.zjgyjd.Thread;

public class Thread11 {
    public static void main(String[] args) {
        Runnable runnable = new PrintRunnable();
        for (int i = 0; i <10 ; i++) {
            new Thread(runnable,"ThreadTest-" +i).start();
        }
    }
}

class PrintRunnable implements Runnable{

    @Override
    public synchronized void run() {
        System.out.println("@ "+Thread.currentThread().getName());
    }
}
