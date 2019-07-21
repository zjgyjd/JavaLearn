package com.github.zjgyjd.Solution;

import java.util.*;

public class HowDay{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while(s.hasNext()){
            int year = s.nextInt();
            int mou = s.nextInt();
            int day  = s.nextInt();
            int check = iConverDateToDay(year,mou,day);
            if(check == -1){
                System.out.println("失败");
            }
            int[] sumDay = {31,28,31,30,31,30,31,31,30,31,30,31};
            int result = getOutDay(sumDay,year,mou,day);
            System.out.println(result);
        }
    }
    public static int iConverDateToDay(int year,int mou,int day){
        if(year <= 0 || mou <= 0 || day  <= 0){
            return -1;
        }
        if( mou > 12){
            return -1;
        }
        if(mou <= 7){
            if(mou % 2 != 0 && day > 31 ){
                return -1;
            }
            if(mou % 2 == 0 && mou != 2 && day > 30){
                return -1;
            }
        }
        if(mou > 7){
            if(mou % 2 == 0 && day > 31 ){
                return -1;
            }
            if(mou % 2 != 0 && day > 30){
                return -1;
            }
        }
        if(mou == 2){
            if(checkYear(year) && day > 29)
                return -1;
            if(!checkYear(year) && day > 28)
                return -1;
        }
        return 0;
    }
    public static boolean checkYear(int year){
        return year % 4 == 0 && year % 100 != 0;
    }
    public static int getOutDay(int[] sumDay,int year,int mou,int day){
        int sum = 0;
        for(int i = 0; i < mou - 1 ; i++){
            sum = sum + sumDay[i];
        }
        if(mou > 2 && checkYear(year)){
            return sum + day + 1;
        }
        return sum + day;
    }
}