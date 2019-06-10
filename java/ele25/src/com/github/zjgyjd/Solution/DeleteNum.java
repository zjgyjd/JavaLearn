package com.github.zjgyjd.Solution;

import java.util.Scanner;

public class DeleteNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int n = s. nextInt();
            if(n > 1000){
                n = 1000;
            }

            int[] array = new int[n];
            for(int i = 0 ; i < n ; i++){
                array[i] = 0;
            }
            int i = 0;
            int count = 0;
            int index = -1;
            while(n != 0){
                if(i == array.length){
                    i = 0;
                }
                if(array[i] == 0){
                    count++;
                    if(count == 3){
                        count = 0;
                        array[i] = 1;
                        if(index == i){

                            break;
                        }
                    }
                    index = i;
                }
                i++;
            }
            System.out.println(index);
        }

    }
}
