package com.github.zjgyjd.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(15),
                new ThreadFactory() {
                    private AtomicInteger a = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("线程" + a.getAndAdd(1));
                        return t;
                    }
                }
        );

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()));

        }
        executor.shutdown();
        System.out.println(executor.isShutdown());
        System.out.println(executor.isTerminated());//有可能有正在执行的任务没有完成

        System.out.println(Runtime.getRuntime().availableProcessors());//获取CPU核数
    }
}
