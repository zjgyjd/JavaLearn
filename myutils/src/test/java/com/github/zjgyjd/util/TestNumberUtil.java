package com.github.zjgyjd.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestNumberUtil {

    public static void code0() {
        double test = 0.1;
        System.out.println(new BigDecimal(Double.toString(test)));//0.1
        System.out.println(new BigDecimal(0.1));//不是0.1

        BigDecimal s = new BigDecimal(Double.toString(2.350005));
        System.out.println(s.setScale(5, RoundingMode.HALF_DOWN));
        float test1 = 1.0f;
        float test2 = 6.0f;
        System.out.println(NumberUtil.div(test1, test2));
        System.out.println(NumberUtil.div(test1, test2, 8, RoundingMode.HALF_UP));
    }

    public static void code1() {
        double s = 56.650000;
        double test0 = 56.451;
        double test1 = 56.751;
        double test2 = 56.7501;
        System.out.println(NumberUtil.roundHalfEven(s, 1));//56.6
        System.out.println(NumberUtil.roundHalfEven(test0, 1));//56.5
        System.out.println(NumberUtil.roundHalfEven(test1, 1));//56.8
        System.out.println(NumberUtil.roundHalfEven(test2, 1));//56.8
        System.out.println(NumberUtil.roundDown(test2, 1));//56.7
    }

    public static void code2() {
        double pi = 3.1415927;
        System.out.println(NumberUtil.decimalFormat("0", pi));
        System.out.println(NumberUtil.decimalFormat("0.00", pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));// 03.142
        //取所有整数部分
        System.out.println(NumberUtil.decimalFormat("#", pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(NumberUtil.decimalFormat("#.##%", pi));//314.16%
        System.out.println(NumberUtil.formatPercent(pi, 2));//314.16%

        long c = 299792458;//光速
        //显示为科学计数法，并取五位小数
        System.out.println(NumberUtil.decimalFormat("#.#####E0", c));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(NumberUtil.decimalFormat("00.####E0", c));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(NumberUtil.decimalFormat(",###", c));//299,792,458
        //将格式嵌入文本
        System.out.println(NumberUtil.decimalFormat("#米/秒", c));
    }

    public static void main(String[] args) {
        String test0 = "12.12.3";
        String test1 = "1@22.3";
        String test2 = "122.3";
        String test3 = "0x65";
        Integer s = Integer.decode("0x65");
        System.out.println(s);
        System.out.println(NumberUtil.isNumber(test0));//false
        System.out.println(NumberUtil.isNumber(test1));//false
        System.out.println(NumberUtil.isNumber(test2));//true
        System.out.println(NumberUtil.isNumber(test3));//true
        System.out.println(NumberUtil.isInteger(test3));//true

    }
}
