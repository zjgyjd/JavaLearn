

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerCustomer {
    
    public static void main(String[] args) {
        
        Queue<Goods> queue = new LinkedList<>();
        AtomicInteger goodsName = new AtomicInteger(1);
        Object monitor = new Object();
        
        Producer producer1 = new Producer(queue, monitor, goodsName);
        Producer producer2 = new Producer(queue, monitor, goodsName);
        Customer customer = new Customer(queue, monitor);
        
        new Thread(producer1, "生产者1").start();
        new Thread(producer2, "生产者2").start();
        new Thread(customer).start();
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

//生产者
class Producer implements Runnable {
    
    private final Queue<Goods> goods;
    
    private final Object monitor;
    
    private final AtomicInteger atomicInteger;
    
    Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(monitor) {
                //商品池满了
                if (this.goods.size() == 10) {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods = new Goods(String.valueOf(atomicInteger.getAndAdd(1)));
                    this.goods.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产：" + goods);
                    
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
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(monitor) {
                if (this.goods.isEmpty()) {
                    this.monitor.notifyAll();
                } else {
                    //消费商品
                    Goods goods = this.goods.poll();
                    System.out.println("消费者消费：" + goods);
                }
            }
        }
    }
}
