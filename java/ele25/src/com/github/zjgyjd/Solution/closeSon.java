package com.github.zjgyjd.Solution;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class closeSon {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        String[] tree = s.nextLine().split(" ");
        String[] num = s.nextLine().split(" ");
        int[] array = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            array[i] = Integer.parseInt(tree[i]);
        }
        System.out.println(findSon(array, Integer.parseInt(num[0]), Integer.parseInt(num[1])));
    }
    public static int findSon(int[] tree , int n , int k){
        if(tree == null){
            return -1;
        }
        //因为是查找数有唯一路径
        List<Integer> nRoad = findRoad(tree , n);
        List<Integer> kRoad = findRoad(tree , k);
        if(nRoad== null || kRoad == null){
            return -1;
        }
        //先让短的走
        if(kRoad.size() < nRoad.size()){
           return find(nRoad , kRoad);
        }else {
           return find(kRoad , nRoad);
        }
    }

    private static int find(List<Integer> small, List<Integer> big) {
        while(small.size() != big.size()){
             int temp = small.remove(small.size() - 1);
             if(temp == big.get(big.size() - 1)){
                 return big.get(big.size() - 1);//此时找到了
             }
        }
        while (small.size() != 0){
            int temp1 = small.remove(small.size() - 1);
            int temp2 = big.remove(big.size() - 1);
            if(temp1 == temp2){
                return temp1;
            }
        }
        return -1;
    }

    private static List<Integer> findRoad(int[] tree, int n) {
        List<Integer> result = new ArrayList<>();
        int i = 0 ;
        boolean flag = false;
        while(i < tree.length){
            if (tree[i] < n){
                if(tree[i] == -1){
                    break;//走到头了
                }
                //向右
                result.add(tree[i]);
                i = i * 2 + 2;
            }else if(tree[i] == n){
                //本身
                result.add(n);
                flag = true;//走到了
                break;
            }else {
                //向左
                result.add(tree[i]);
                i = i * 2 + 1;
            }

        }
        if(!flag){
            return null;
        }else {
            return result;
        }
    }
}
