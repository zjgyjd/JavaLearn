package com.github.zjgyjd.Solution;

public class GetNumber {
    public int getSqareNum(int[][] map) {
        int[][] resultMap = new int[map.length + 1][map.length + 1];
        for (int i = 1; i < resultMap.length; i++) {
            for (int j = 1; j < resultMap.length; j++) {
                resultMap[i][j] = Math.max(resultMap[i - 1][j], resultMap[i][j - 1]) + map[i - 1][j - 1];
            }
        }
        return resultMap[map.length][map.length];
    }

    public static void main(String[] args) {
        System.out.println(new GetNumber().getSqareNum(new int[][]{
                {1,3,3},{2,1,3},{3,1,1}
        }));
    }
}
