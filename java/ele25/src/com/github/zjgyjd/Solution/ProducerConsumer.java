package com.github.zjgyjd.Solution;

//相当于实现一个生产者消费者模型
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}

class TList {
    int size;
    Node n;
    Node tail;
    public TList(){
        this.size = 0;
    }

    public void push(int t){
        Node temp = new Node(t);
        if(n == null){
            n = temp;
        }else{
            tail.next = temp;
        }
        tail = temp;
        size++;
    }

    public int pop(){
        if(n != null){
            int temp = n.val;
            n = n.next;
            if(n == null){
                tail = null;
            }
            size--;
            return temp;
        }
        return -1;
    }
}
//利用wait() 和 notify() 实现生产者消费者模型
public class ProducerConsumer{
    public static void main(String[] args){
        TList queue = new TList();
        Thread producer = new Producer(queue , 10);
        Thread consumer = new Consumer(queue , 10);
        producer.start();
        consumer.start();
    }
}
class Producer extends Thread{
    private TList queue;
    int maxSize;
    int i = 0;
    public Producer(TList queue , int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run(){
        while(true){
            synchronized(queue){
                while(queue.size == maxSize){
                    System.out.println("Full");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("add " + i);
                queue.push(i++);
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread{
    private TList queue;
    int maxSize;
    public Consumer(TList queue , int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run(){
        while(true){
            synchronized(queue){
                while(queue.size == 0){
                    System.out.println("Empty");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("get " + queue.pop() );
                queue.notifyAll();
            }
        }
    }
}
