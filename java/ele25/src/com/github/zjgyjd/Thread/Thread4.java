package com.github.zjgyjd.Thread;

import java.util.concurrent.*;

public class Thread4 {
    public static void main(String[] args) {
        //业务员
        Callable<String> c = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(c);
        Thread t = new Thread(futureTask);
        t.start();
//        try{//因为是阻塞操作,所以一个给一个最终时间
//            String result = futureTask.get(1, TimeUnit.SECONDS);//如果超一秒就终止
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName());//会返回main方法线程名称
        System.out.println("结束");
    }
}

//run是没有返回值的,当需要返回时要用以下方法
class MyCallable implements Callable<String> {
    private int tick = 10;

    @Override
    public String call() throws Exception {
        while (tick > 0) {
            System.out.println(Thread.currentThread().getName() + "剩余: " + tick-- + "张票");
        }
        return "票没了!!";
    }
}
