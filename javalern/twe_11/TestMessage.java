package com.github.zjgyjd.generic;

public class TestMessage {
    public static void main(String[] args) {
        Message2<String> s = new Message2<>();
        s.setMessage("hello");
        fun(s);
       // fun2(s);//此时String就会出错
        Message2<Integer> s1 = new Message2<>();
        s1.setMessage(18);
        fun2(s1);
    }
    //    public static void fun(Message2<String> m) {
//        System.out.println(m);
//    }
    public static void fun(Message2<?> m) {
        System.out.println(m);//通配符解决参数同一,但此时无法再方法里修改
        // m.setMessage(111);//error
    }
    //Number只是数值类型
    public static void fun2(Message2<? extends Number> m){//泛型上限
        System.out.println(m);
    }
    public static void fun3(Message2<? super Integer> m){//泛型下限,只能在方法参数,但可以修改内容
        m.setMessage(888);//但只能改本类型
       // m.setMessage(new Number());//error
        System.out.println(m);
    }
}

class Message2<T> {
    private T message;

    public void setMessage(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }
}
class Message3<T extends Number>{//同样可以指定类的泛型参数直接继承某个类

}