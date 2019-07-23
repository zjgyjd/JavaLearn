package com.github.zjgyjd.Solution;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Stack<String> reString = new Stack<>();
        Scanner s = new Scanner(System.in);
        char[] target = s.nextLine().toCharArray();
        boolean isNum = false;
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < target.length ; i++){
            if(target[i] >= 'a' && target[i] <= 'z'){
                sb.append(target[i]);
            }else if(target[i] >= 'A' && target[i] <= 'Z'){
                sb.append(target[i]);
            }else{
                if(!sb.toString().isEmpty()){
                    reString.push(sb.toString());
                }
                sb.delete(0,sb.length());
            }
        }
        if(!sb.toString().isEmpty()){
            reString.push(sb.toString());
        }
        sb.delete(0,sb.length());
        while(!reString.isEmpty()){
            String target1 = reString.pop();
            sb.append(target1).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
