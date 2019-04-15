package com.github.zjgyjd.Solution;

import java.util.LinkedList;
import java.util.Stack;

public class Valid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length =  s.length();

        for(int i = 0;i < s.length();i++){
            char target = s.charAt(i);
            switch(target){
                case '(':
                case '{':
                case '[':{
                    stack.add(target);
                    break;
                }
                case ')':{
                    if(stack.isEmpty()|| !stack.pop().equals('(')){
                        return false;
                    }
                    break;
                }
                case '}':{
                    if(stack.isEmpty()|| !stack.pop().equals('{')){
                        return false;
                    }
                    break;
                }
                case ']':{
                    if(stack.isEmpty()|| !stack.pop().equals('[')){
                        return false;
                    }
                    break;
                }
                default:
                    return false;

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        System.out.println(isValid("()"));
    }
}
