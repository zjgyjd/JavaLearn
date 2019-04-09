package com.github.zjgyjd.TestCollection;

import javax.print.attribute.standard.OutputDeviceAssigned;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

public class TestMapRudece {
    public static void code1() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));

        //计算金额总和
//        double total = 0.0D;
////        for (Order order:orderList) {
////            total+=order.getPrice()* order.getAmount();
////        }
////        System.out.println("总金额是:"+total);

        //给里面所有元素求和
        double total = orderList
                .stream()
                .mapToDouble(s -> s.getPrice() * s.getAmount())//ListStream-->DoubleStream求出每一个订单的总价
                .reduce((sum, right) -> {//从最左边开始
                    //sum往右边不停加
                    return sum + right;
                }).orElseGet(new DoubleSupplier() {
                    @Override
                    public double getAsDouble() {
                        return 0;
                    }
                });
        System.out.println(total);

        //map-reduce统计分析, DoubleSummaryStatistics可以用于统计的类,找最大,平均,最小
        DoubleSummaryStatistics s = orderList.stream()
                .mapToDouble(o -> o.getPrice() * o.getAmount())
                .summaryStatistics();
        System.out.println("数量:" + s.getCount());
        System.out.println("最大值:" + s.getMax());
        System.out.println("总和" + s.getSum());
        System.out.println("平均值:" + s.getAverage());
    }
public static void code2(){
    List<Order> orderList = new ArrayList<>();
    orderList.add(new Order("Iphone", 8999.99, 10));
    orderList.add(new Order("外星人笔记本", 12999.99, 5));
    orderList.add(new Order("MacBookPro", 18999.99, 5));
    orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
    orderList.add(new Order("中性笔", 1.99, 200000));
    orderList.add(new Order("中性笔", 2, 20));
    orderList.add(new Order("外星人笔记本", 1000, 1));

    //订单分组
//        Map<String ,List<Order>> map = new HashMap<>();
//        for(Order order:orderList){
//            if(map.containsKey(order.getTitle())){
//                map.get(order.getTitle()).add(order);
//            }else{
//                List<Order> orders = new ArrayList<>();
//                orders.add(order);
//                map.put(order.getTitle(),orders);
//            }
//        }
//        System.out.println(map);
//        //计算title相同的订单金额
//        Map<String,Double> doubleMap = new HashMap<>();
//        for(Map.Entry<String,List<Order>> entry:map.entrySet()){
//            String title = entry.getKey();
//            List<Order> orders = entry.getValue();
//            double sum = 0.0D;
//            for(Order order:orders){
//                sum+= order.getPrice()*order.getAmount();
//            }
//            doubleMap.put(title,sum);
//        }
//        System.out.println(doubleMap);

    //流方法
    Map<String, Double> doubleMap = new HashMap<>();
    orderList.stream()
            .collect(Collectors.groupingBy(o -> o.getTitle()))//按照订单分组
            .forEach((k, v) -> {
                doubleMap.put(k, v.stream()
                        .mapToDouble(o -> o.getPrice() * o.getAmount())
                        .reduce((sum, x) -> sum + x)
                        .orElse(0));
            });
}
    public static void main(String[] args) {

    }
}