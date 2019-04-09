package com.github.zjgyjd.JCF;

import java.util.*;

public class TestSet {
    public static void code1() {
        Set<String> set = new HashSet<>();
        set.add("java");//Set忽略重复元素
        set.add("C++");
        set.add("C");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //判断元素是否存在
        System.out.println(set.contains("java"));//true
        System.out.println(set.contains("javaScript"));//false
        //当里面是自定义对象时,需要复写equals和hashcode方法
    }

    public static void code2() {

        Set<String> set = new TreeSet<>(////TreeSet 无参为元素排序策略,可以传有参改变 即传入比较方法
                new Comparator<String>() {//利用比较器
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2) * -1;//实现倒序,此时为固定操作,但如果自定义时有其他属性,也可以改为比那个属性
                        //return o1.getname().compareTo(o2.getname());
                    }
                }
        );
        set.add("java");//Set忽略重复元素
        set.add("C++");
        set.add("C");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //foreach方式遍历集合(Set,List)如果在里面修改集合则不会被允许
    }

    public static void main(String[] args) {
    Vector<String> vector = new Vector<>();
    vector.add("java");
    vector.add("C++");
    vector.add("C");
    Enumeration enumeration = vector.elements();//枚举类实现,类似迭代器
    while(enumeration.hasMoreElements()){
        System.out.println(enumeration.nextElement());
    }
    }
}
