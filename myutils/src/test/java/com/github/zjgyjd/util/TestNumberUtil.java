package com.github.zjgyjd.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestNumberUtil {
    public static void main(String[] args) {
        double test = 0.1;
        System.out.println(new BigDecimal(Double.toString(test)));//0.1
        System.out.println(new BigDecimal(0.1));//不是0.1

        BigDecimal s = new BigDecimal(Double.toString(2.350005));
        System.out.println(s.setScale(5,RoundingMode.HALF_DOWN));
        float test1 = 1.0f;
        float test2 = 6.0f;
        System.out.println(NumberUtil.div(test1, test2));
        System.out.println(NumberUtil.div(test1, test2, 8, RoundingMode.HALF_UP));
    }
}
