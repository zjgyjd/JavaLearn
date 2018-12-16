package com.github.zjgyjd.JCF;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void code1() {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("java");
        queue.add("C++");

        System.out.println("队列的元素是否为空:" + queue.isEmpty());
        System.out.println("队列长度" + queue.size());

        //此时查看的是第一个元素
        System.out.println("第一个元素" + queue.peek());
        //出队先进先出,注意入队用add,出队用poll此时为队列,出多了会返回null
        //入队用push出队用pop此时为栈,出多了会返回异常
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        //生产者->消费者模型
        //生产者和消费者的能力不匹配
        //采用队列的方式存储生成消费的资源,解耦生成消费的逻辑
        Queue<String> queue = new LinkedList<>();
        new Thread(new Runnable() {
            {
                System.out.println("生产启动");
            }
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(1000);
                        queue.add("1");
                        System.out.println("生产:"+"1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            {
                System.out.println("消费者线程");
            }
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(5000);
                        System.out.println("消费:"+queue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
