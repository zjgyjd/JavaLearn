package com.github.zjgyjd.Function;


import com.github.zjgyjd.inbuilt.Person;

@FunctionalInterface
public interface IUtil3 {
    Person createPerson(String name, Integer age);

    static void main(String[] args) {
        IUtil3 iUtil3 = (name,age)->{
            return new Person(name,age);
        };

        //构造方法引用
        IUtil3 iUtil31 =Person::new;
        Person person = iUtil31.createPerson("tom",13);
    }
}
