package com.github.zjgyjd.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductToCustomer {
    public static void main(String[] args) {
        Queue<Goods> n = new LinkedList<>();
        Object o = new Object();
        Producter producter = new Producter(n, o, new AtomicInteger(1));
        Customer customer = new Customer(n, o);
        Thread start = new Thread(producter, "生产者");
        Thread end = new Thread(customer, "消费者");
        end.start();
        start.start();
    }
}

class Goods {
    private final String name;

    Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Producter implements Runnable {
    private final Queue<Goods> goods;
    private final Object monitor;
    private final AtomicInteger atomicInteger;

    Producter(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }


    @Override
    public void run() {
        while (true) {

            synchronized (goods) {
                if (this.goods.size() >= 10) {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods good = new Goods("商品" + atomicInteger.getAndAdd(1));
                    goods.add(good);
                    System.out.println("生产者生产商品:" + good);
                }
            }
        }
    }
}

class Customer implements Runnable {
    private final Queue<Goods> goods;
    private final Object monitor;

    Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (goods) {
                if (goods.isEmpty()) {
                    this.monitor.notify();
                } else {

                    Goods g = goods.poll();
                    System.out.println("消费者消费: " + g);
                }
            }
        }
    }
}