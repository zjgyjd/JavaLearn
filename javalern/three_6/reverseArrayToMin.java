package com.github.zjgyjd.Arrays;

public class reverseArrayToMin {
    public static int foundMin(int[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (s[mid] > s[high]) {
                low = mid+1;
            }else if(s[mid]==s[high]){
                high = high -1;
            }else {
                high = mid;
            }
        }
        return s[low];
    }

    public static void main(String[] args) {
        int[] test0 ={2,2,2,2,2,2,1,2};
        int[] test1 ={1,0,1,1,1};
        int[] test2 ={1,1,1,0,1};
        int[] test3 ={3,4,5,1,2};

        System.out.println(foundMin(test0));
        System.out.println(foundMin(test1));
        System.out.println(foundMin(test2));
        System.out.println(foundMin(test3));
    }
}
