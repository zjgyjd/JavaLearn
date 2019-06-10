package com.github.zjgyjd.Solution;

import java.util.Arrays;

public class SonString {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] result = new boolean[n];
        for(int i = 0; i < n; i++){
            result[i] = isContain(s , p[i]);
        }
        return result;
    }
    public boolean isContain(String s , String p){
        char[] own = s.toCharArray();
        char[] co = p.toCharArray();
        for(int i = 0; i < own.length; i++){
            int j = 0;
            int i1 = i;
            while(i1 < own.length && own[i1] == co[j]){
                if(j == co.length - 1){
                    return true;
                }
                j++;
                i1++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[] result =new SonString().chkSubStr(new String[]{
                "ba","bc","ca","de","ag","aab"
        },6,"aaabaaaaacdefg");

        System.out.println(Arrays.toString(result));
    }
}
