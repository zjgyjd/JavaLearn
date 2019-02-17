package com.github.zjgyjd.util;

public class TestCharUtil {
    public static void main(String[] args){
        char s = 190;
        char s0 = 5;
        char s1 = 'A';
        Character s2 = 's';
        Class s3 = char.class;

        System.out.println(CharUtil.isCharClass(s2.getClass()));
        System.out.println(CharUtil.isCharClass(s3));

        System.out.println((int)s1);
        System.out.println(CharUtil.isAscii(s));
        System.out.println(CharUtil.isAsciiPrintable(s0));
        System.out.println(CharUtil.isLetter(s0));
        System.out.println(CharUtil.isLetter(s1));
        System.out.println(CharUtil.isAscii(';'));
        System.out.println(CharUtil.isAsciiPrintable('-'));
    }
}
