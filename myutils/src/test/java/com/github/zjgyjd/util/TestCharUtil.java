package com.github.zjgyjd.util;

public class TestCharUtil {

    public static void code0(){
        char s = 190;
        char s0 = 5;
        char s1 = 'A';
        Object s5 = s1;
        Character s2 = 's';
        Class s3 = char.class;

        System.out.println(CharUtil.isCharClass(s5.getClass()));
        System.out.println(s5.getClass());
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

    public static void main(String[] args){
        char test = ' ';
        char test0 = ' ';
        char test1 = '	';
        char s = 'z';
        char s2 = 'Z';
        System.out.println(CharUtil.equals(s,s2,true));
        System.out.println((int)s2);
        System.out.println(CharUtil.isBlankChar(test));
        System.out.println(CharUtil.isBlankChar(test0));
        System.out.println(CharUtil.isBlankChar(test1));
    }
}
