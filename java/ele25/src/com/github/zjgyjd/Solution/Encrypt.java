package com.github.zjgyjd.Solution;

import java.util.*;

public class Encrypt{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String doing = s.nextLine();
        String did = s.nextLine();
        String doingResult = doingChar(doing);
        String didResult = didChar(did);
        System.out.println(doingResult);
        System.out.println(didResult);
    }
    //加密
    public static String doingChar(String doing){
        char[] str  = doing.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            char target = str[i];
            if(target >= 'a' && target <= 'z'){
                if(target == 'z'){
                    str[i] = 'A';
                }else{
                    str[i] =(char) (target + 1 - 32);
                }
            }
            if(target >= 'A' && target <= 'Z'){
                if(target == 'Z'){
                    str[i] = 'a';
                }else{
                    str[i] =(char) (target + 1 + 32);
                }
            }
            if(target >= '0' && target <= '9'){
                if(target == '9'){
                    str[i] = '0';
                }else{
                    str[i] = (char) (target + 1);
                }
            }
        }
        return String.valueOf(str);
    }
    //解密
    public static String didChar(String did){
        char[] str  = did.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            char target = str[i];
            if(target >= 'a' && target <= 'z'){
                if(target == 'a'){
                    str[i] = 'Z';
                }else{
                    str[i] =(char) (target - 1 - 32);
                }
            }
            if(target >= 'A' && target <= 'Z'){
                if(target == 'A'){
                    str[i] = 'z';
                }else{
                    str[i] =(char) (target - 1 + 32);
                }
            }
            if(target >= '0' && target <= '9'){
                if(target == '0'){
                    str[i] = '9';
                }else{
                    str[i] = (char) (target - 1);
                }
            }
        }
        return String.valueOf(str);
    }
}
