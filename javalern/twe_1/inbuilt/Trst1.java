package com.github.zjgyjd.inbuilt;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Trst1 {
    public static void code(){
        //功能型函数接口
        Function<Object,String> function = (value)->{
            return value.toString();
        };
        String result = function.apply(888);

        function = String::valueOf;
        result = function.apply(new Person("sj",18));
    }
    public static void code2(){
        //y =f(x)
        //x =g()
        Function<Supplier<Person>,String> function = (s)->{
            return s.get().toString();
        };
        //供给型用于产生对象
        Supplier<Person> s =()->{
            return new Person("sjs",18);
        };
        String rs = function.apply(s);

        //消费性,有参数没用返回值,一般为打印语句
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("Hello World");

        //断言型,不管传入什么最后返回bool
        Predicate<String> predicate = "Hello"::endsWith;
        predicate.test("o");

        Predicate<Object> predicate1 = (obj)->{
            return obj instanceof Person;
        };
    }

    public static void main(String[] args) {

    }
}
