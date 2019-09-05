package com.github.zjgyjd.review.design_pattern.factory_method_pattern;

public class SimpleFactory {
    // 实现统一管理,专业化管理
    // 如果没有工厂模式,小作坊,没有执行标准
    public Car getCar(String name) {
        if("Audi".equalsIgnoreCase(name)) {
            return new Audi();  // 产生的是奥迪
        } else if ("BENZ".equalsIgnoreCase(name)) {
            return new Benz(); // 产生的是奔驰
        }
        System.out.println("无该产品");
        return null;
    }
}
