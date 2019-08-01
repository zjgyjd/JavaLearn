package com.github.zjgyjd.review;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class JionTest implements Runnable {
    @Override
    public void run() {
        System.out.println("子线程开始执行");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行结束");
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        JionTest test1 = new JionTest();
        Thread thread1 = new Thread(test1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程_____");
    }
}

class Goods {
    private int maxGoodsNum;
    private int currentNum;
    private Lock lock = new ReentrantLock();

    //生产者等待队列
    private Condition producerQueue = lock.newCondition();
    //消费者等待队列
    private Condition consumerQueue = lock.newCondition();

    public Goods(int maxGoodsNum) {
        this.maxGoodsNum = maxGoodsNum;
    }

    public void produceGoods() {
        try {
            lock.lock();
            while (this.currentNum == maxGoodsNum) {
                producerQueue.await();//调用哪个扔到哪个队列中
            }
            System.out.println("xxxxxx");
            currentNum++;
            //唤醒消费者线程
            consumerQueue.signalAll();
        } catch (Exception e) {

        } finally {

        }
    }
}

class MultiThreadPC {

}

class ThreadSafeCache {
    private Map<String, String> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public String getValue(String key) {
        reentrantReadWriteLock.readLock();
        return map.get(key);
    }

    public void SetValue(String key, String value) {
        reentrantReadWriteLock.writeLock();
        map.put(key, value);
    }
}

class CDLTask implements Runnable {
    public CountDownLatch countDownLatch;

    public CDLTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始跑步");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " 到达终点");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CDLTask cdlTask = new CDLTask(countDownLatch);
        System.out.println("比赛开始>>>>>>>>>");
        new Thread(cdlTask, "1号").start();
        new Thread(cdlTask, "2号").start();
        new Thread(cdlTask, "3号").start();
        new Thread(cdlTask, "4号").start();
        countDownLatch.await();
        System.out.println("比赛结束<<<<<<<<<");
    }
}

class CBTask implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CBTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在写入数据...");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "写入数据完毕,等待其他线程写入完毕...");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "全部结束");
    }
}

class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        CBTask cbTask = new CBTask(cyclicBarrier);
        for (int i = 0; i < 4; i++) {
            new Thread(cbTask, "写程序" + (i + 1)).start();
        }
    }
}

class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread girlThread = new Thread(() -> {
            try {
                String girl = exchanger.exchange("I like you");
                System.out.println("女生说: " + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        girlThread.start();
        Thread boyThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                String boy = exchanger.exchange("I like you too");//会进行内容的交换
                System.out.println("男生说: " + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        boyThread.start();
    }
}

class SemaphoreTask implements Runnable {
    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "占用一台设备");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "生产完毕,释放设备");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        SemaphoreTask task = new SemaphoreTask(semaphore);
        for (int i = 0; i < 8; i++) {
            new Thread(task, "工人" + (i + 1)).start();
        }
    }
}

class ThreadLocalTest {
    private static String commStr;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        commStr = "ming";
        threadLocal.set("main");
        Thread t = new Thread(() -> {
            commStr = "thread";
            threadLocal.set("thread");
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(commStr);
        System.out.println(threadLocal.get());
    }
}

class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = new ThreadPoolExecutor(4, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        //核心池         // 最大线程池       //存活时间       //单位秒          //阻塞队列
        CallableTask callableTask = new CallableTask();
        Future<String> submit = null;
        for (int i = 0; i < 4; i++) {
//            if (i != 0)
//                TimeUnit.SECONDS.sleep(3);
            submit = e.submit(callableTask);
            //System.out.println(submit.get());//会阻塞线程,直到取得Callable的返回值
        }


        e.shutdown();
    }
}

class CallableTask implements Callable<String> {
    private int ticket = 20;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 20; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "剩余 " + ticket--);
            }
        }
        return "票已经没有了";
    }
}

class FutureTaskDemo {
    public static void main(String[] args) {
        CallableTask callableTask = new CallableTask();
        FutureTask<String> f = new FutureTask<String>(callableTask);
        new Thread(f, "HN-A").start();
        new Thread(f, "HN-B").start();
        new Thread(f, "HN-C").start();
        new Thread(f, "HN-D").start();
    }
}