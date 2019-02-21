package com.github.zjgyjd.util;

import java.math.BigDecimal;

public class TestNumberUtil {
    public static void main(String[] args) {
        double test = 0.1;
        System.out.println(new BigDecimal(Double.toString(test)));//0.1
        System.out.println(new BigDecimal(0.1));//不是0.1

    }
}
