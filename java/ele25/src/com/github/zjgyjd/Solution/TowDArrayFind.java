package com.github.zjgyjd.Solution;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class TowDArrayFind {
    /*
    *  {1,2,8,9},
    *  {2,4,9,12},
    *  {4,7,10,13},
    *  {6,8,11,15}
    *  从左下角开始,如果目标大于该数,行减一,目标小于该数列减一,
    *  因为有序最下面的比目标小则这一列都不会比目标大
    *  同时最右面都比目标大则这一行之后都比目标大
    * */
    public boolean Find(int target, int [][] array) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
        };
        System.out.println(new TowDArrayFind().Find(5,test));
        System.out.println(new TowDArrayFind().Find(11,test));
    }
}
