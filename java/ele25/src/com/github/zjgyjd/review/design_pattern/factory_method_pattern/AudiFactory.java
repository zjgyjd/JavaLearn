package com.github.zjgyjd.review.design_pattern.factory_method_pattern;

public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
