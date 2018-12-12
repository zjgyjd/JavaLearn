package com.github.zjgyjd.generic;

import java.util.EnumSet;
import java.util.Set;

import static com.github.zjgyjd.generic.Watercolors.*;
import static com.github.zjgyjd.generic.Sets.*;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);//EmumSet从第一个枚举量
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BULE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));//集合
        Set<Watercolors> subset = intersection(set1,set2);
        System.out.println("intersection(set1 , set2): " +subset);//取共同的部分
        System.out.println("difference(set1,set2): "+difference(set1,set2));//将set1中的set2包含的元素移出
        System.out.println("complement(set1,set2): "+complement(set1,set2));//返回除两个相交之外的所有元素
    }
}
