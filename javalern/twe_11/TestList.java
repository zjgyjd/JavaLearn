package com.github.zjgyjd.JCF;

import java.util.*;

public class TestList {
    public static void code1() {
        //实例化ArrayList对象
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("c");
        list1.add("C++");
        list1.add("Python");
        list1.add("java");//可以放置重复
        System.out.println(list1);

        list1.add(0, "Go");
        System.out.println(list1);//按下标加载
        System.out.println(list1.size());//查看元素

        // list1.addAll(list1);//批量添加
        // System.out.println(list1);
        System.out.println(list1.remove("Go"));//此时有就删除返回true;
        System.out.println(list1);
        System.out.println(list1.remove(0));//按下标移出,此时返回那个元素
        System.out.println(list1);

        //for
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i));
//            if(i<list1.size()-1){
//                System.out.print(",");
//            }
//        }

        //foreach
//        for(String item:list1){
////            System.out.print(item);
////            System.out.print(",");
////        }

//        //迭代器
//        Iterator<String>  iterator = list1.iterator();
//        while(iterator.hasNext()){
//            System.out.println( iterator.next());
//            System.out.println(",");
//        }

        //  Object[] elementsArray = list1.toArray();//返回一个Object数组应用时要显示向下转型
        String[] elementsArray = new String[list1.size()];//标准写法  直接是Collection时没有这种方法
        list1.toArray(elementsArray);//利用泛型完成
        System.out.println(Arrays.toString(elementsArray));
    }

    public static void code2() {
        List<Person> people = new ArrayList<>();
        Person jack = new Person("JACK", 22);
        people.add(jack);
        people.add(new Person("Alice", 18));
        people.add(new Person("Alex", 20));
        System.out.println(people);
        System.out.println(people.contains(new Person("JACK", 22)));//此时为false,因为没有复写equals方法,复写后true
        System.out.println(people.contains(jack));//true 同个对象
        System.out.println(people.remove(jack));//也是值传递,要复写equals
    }

    public static void code4(){
        //Vector
        List<String> vector = new Vector<>();
        vector.add("java");
        vector.add("C++");
        //Vector JDK1.0出现
        //线程安全,同步,性能低  ArrayList性能高
        //ArrayList支持迭代,foreach,List迭代,//Vector多支持一个以前的迭代
        Enumeration<String> enumeration = ((Vector<String>) vector).elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }

    public static void code5(){
        List<String> list = new ArrayList<>();
        list.add("ss");
        list.add("java");
        ListIterator<String> iterator = list.listIterator();//List迭代器比迭代器方法多
        while (iterator.hasPrevious()) {
            iterator.add("+");
            System.out.print(iterator.previous());//反向遍历
            iterator.set("+");//修改内容不能写在next这一类之前
        }
        for(String item:list){
            System.out.print(item);
        }
    }

    public static void main(String[] args) {
      //List-->ArrayList
        //1.ArrayList数据通过数组存放
        //2.ArrayList()无参的存储数据的数组初始化在第一次添加元素时,(lazy load)延时加载--> 扩容50%--默认容量为10
        //3.ArrayList的初始化容量的构造方法实例化,存储数据时立即初始化
        List<String> list = new ArrayList<>();
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
//手工复写参考String
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof Person) {
//            Person that = (Person) obj;
//            return this.getName().equals(that.getName()) && this.getAge() == that.getAge();
//        }
//        return false;
//    }


    //equals和hashCode复写方法要一起使用
    //没有hashCode无法保证对象完全相等,equals相等即内容相等,但hashCode()不相等,此时作为Map的键值就会不相等
    //只要参与判断就要参与hashCode计算
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}