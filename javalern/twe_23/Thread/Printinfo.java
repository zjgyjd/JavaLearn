package com.github.zjgyjd.Thread;

public class Printinfo {
    public void print(Object... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public static void main(String[] args) {
        new Printinfo().print("Hello", "world");//一般方法
        //代理模式使用多线程,可以复用业务逻辑
        Printinfo task = new Printinfo();
        Runnable tRunnable = new PersonInfoRunnable(task);
        new Thread(tRunnable).start();
        new Thread(tRunnable).start();
        //利用函数式lambda表达式,可以启动线程
        Thread thread = new Thread(() -> task.print("hello","world"));
        thread.start();
        //修改线程名字
        Thread thread1 = new Thread(() -> task.print("hello","world"));
        thread1.setName("线程1");//如果不起名会在Thread内部已创建下标的形式取名
        System.out.println(thread1.getName());
        thread1.start();
    }
}

class PersonInfoRunnable implements Runnable {
    private final Printinfo task;

    PersonInfoRunnable(Printinfo task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.print("Hello", "World");
    }
}