package com.github.zjgyjd.Solution;

public class isHappy {
    public static boolean isHappy(int n){
        int temp = n;
        while(true) {
            temp = getNext(temp);
            if (temp == 1) {
                return true;
            } else if (temp == 89){
                return false;
            }
        }
    }
    //返回下一个数
    public static int getNext(int n){
        int result = 0;
        while(n>0){
            result += (n%10)*(n%10);
            n = n/10;
        }
        return result;
    }
}
