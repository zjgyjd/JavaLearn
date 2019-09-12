package com.github.zjgyjd.DS.BinaryTree;

import java.util.*;

public class Main {
    //中序和后序的
    public static void case1(String[] args) {
        Scanner s = new Scanner(System.in);
        String inner = s.nextLine();
        String back = s.nextLine();
        TreeNode result = reConstructTree(inner.toCharArray(), back.toCharArray());
        //进行前序遍历
        preScan(result);

        //读入二维数组
        int n = Integer.parseInt(s.nextLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = s.nextInt();
            }
        }
        maxArray(array);
    }

    public static void preScan(TreeNode s) {
        if (s == null) {
            return;
        }
        System.out.print(s.value);
        preScan(s.left);
        preScan(s.right);
    }

    public static TreeNode reConstructTree(char[] inner, char[] back) {
        return reConstructBinaryTree
                (inner, 0, inner.length - 1, back, 0, back.length - 1);
    }

    public static TreeNode reConstructBinaryTree(char[] inner, int iStart, int iEnd, char[] back
            , int bStart, int bEnd) {
        //通过递归建一颗树,后序求树
        if (bStart > bEnd || iStart > iEnd) {
            return null;
        }
        //在后序中找到根节点找到根节点
        TreeNode root = new TreeNode(back[bEnd]);
        //在中序中遍历找到节点位置区分左右
        for (int i = iStart; i <= iEnd; i++) {
            if (inner[i] == back[bEnd]) {
                //中序:4,7,2,1,5,3,8,6   -->4,7,2 is= 0,ie= 3        --> 4,7,2 is= 0,ie= 2
                //后序:7,4,2,5,8,6,3,1
                root.left = reConstructBinaryTree(inner, iStart, i - 1, back, bStart, bStart + i - iStart - 1);
                root.right = reConstructBinaryTree(inner, i + 1, iEnd, back, bStart + i - iStart, bEnd - 1);
            }
        }
        return root;
    }

    public static void maxArray(int[][] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int max = 0;
        int col = array[0].length;
        int row = array.length;
        for (int i = 0; i < col; i++) {
            int arr[] = new int[col];
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    arr[k] += array[j][k];
                }
                max = Math.max(maxArraySum(arr), max);
            }
        }
        System.out.println(max);
    }

    private static int maxArraySum(int[] array) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        //动态规划 F(i , j) = min{F(i - 1 , j) , F(i , j -1 )} + A(i , j)
        Scanner s = new Scanner(System.in);
        int m = Integer.parseInt(s.nextLine());
        int n = Integer.parseInt(s.nextLine());
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = s.nextInt();
            }
        }
        System.out.println(getMin(map));
    }

    public static int getMin(int[][] map) {
        if (map == null) {
            return 0;
        }
        int[][] resultMap = new int[map.length][map[0].length];
        resultMap[0][0] = map[0][0];
        for (int i = 0; i < resultMap.length; i++) {
            for (int j = 0; j < resultMap[0].length; j++) {
                if (i - 1 < 0 && j - 1 < 0) {
                } else if (i - 1 < 0) {
                    resultMap[i][j] = resultMap[i][j - 1] + map[i][j];
                } else if (j - 1 < 0) {
                    resultMap[i][j] = resultMap[i - 1][j] + map[i][j];
                } else {
                    resultMap[i][j] = Math.min(resultMap[i - 1][j], resultMap[i][j - 1]) + map[i][j];
                }
            }
        }
        return resultMap[map.length - 1][map[0].length - 1];
    }
}


