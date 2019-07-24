package com.github.zjgyjd.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        sort(a);
        System.out.println(Arrays.toString(a));
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] array = new int[n];

		
    }

    public static void sort(int[] array) {
        int[] brr = new int[array.length];
        short1(array,brr, 0,array.length);
    }

	public int select(int capacity, int i) {
		if (capacity == 0) {
			return 1;
		}
		if (i == 0) {
			return 0;
		}
		return select(capacity, i - 1) + select(capacity , i -1);
	}
	
    private static void short1(int[] array, int[] brr, int i, int length) {
        if (i == length){
            int sum = 0;
            for (int j = 0; j < brr.length; j++) {
                if (brr[j] == 1){
                    sum = sum + array[j];
                    System.out.print(array[j]+" ");
                }
            }
            System.out.println("sum = "+ sum);
            System.out.println();
        }else {
            brr[i] = 1;
            short1(array,brr,i+1,length);

            brr[i] = 0;
            short1(array,brr,i+1,length);
        }
    }
}
