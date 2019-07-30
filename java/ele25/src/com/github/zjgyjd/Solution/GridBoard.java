package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GridBoard {
    public static void main(String[] args) {
        new GridBoard().solve(null);
    }

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int row = board.length;
        if (row == 0) {
            return;
        }

        int col = board[0].length;
        //找到边界需要进去的地方
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                DFS(board, i, 0, row, col);
            }
            if (board[i][col - 1] == 'O') {
                DFS(board, i, col - 1, row, col);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                DFS(board, 0, i, row, col);
            }
            if (board[row - 1][i] == 'O') {
                DFS(board, row - 1, i, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void DFS(char[][] board, int x, int y, int row, int col) {
        if (x < 0 || x >= row
                || y < 0 || y >= col
                || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'P';
        DFS(board, x + 1, y, row, col);
        DFS(board, x, y + 1, row, col);
        DFS(board, x - 1, y, row, col);
        DFS(board, x, y - 1, row, col);
    }
}

class GridLength {
    public int sum = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    if ((i - 1 >= 0) && grid[i - 1][j] == 1) {
                        sum--;
                    }
                    if ((i + 1 < grid.length) && grid[i + 1][j] == 1) {
                        sum--;
                    }
                    if ((j - 1 >= 0) && grid[i][j - 1] == 1) {
                        sum--;
                    }
                    if ((j + 1 < grid[0].length) && grid[i][j + 1] == 1) {
                        sum--;
                    }
                }
            }
        }
        return sum;
    }
}

class GridNum {
    public int numIslands(char[][] grid) {
        //看看进行了多少次DFS
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int count = 0;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, row, col, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] grid, int row, int col, int x, int y) {
        if (x < 0 || x >= row
                || y < 0 || y >= col
                || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = 'X';
        DFS(grid, row, col, x + 1, y);
        DFS(grid, row, col, x, y + 1);
        DFS(grid, row, col, x - 1, y);
        DFS(grid, row, col, x, y - 1);
    }
}

class GridArea {
    public int maxAreaOfIsland(int[][] grid) {
        //遍历找到全部1
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int max = 0;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int t = DFS(grid, row, col, i, j);
                    if (t > max) {
                        max = t;
                    }
                }
            }
        }
        return max;
    }

    public int DFS(int[][] grid, int row, int col, int x, int y) {
        //需要返回一个1的个数
        if (x < 0 || x >= row
                || y < 0 || y >= col
                || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = -1;
        return 1 + DFS(grid, row, col, x + 1, y)
                + DFS(grid, row, col, x, y + 1)
                + DFS(grid, row, col, x - 1, y)
                + DFS(grid, row, col, x, y - 1);
    }
}

class node {
    int x;
    int y;
    int step;

    public node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    @Override
    public String
    toString() {
        return "node{" +
                "x=" + x +
                ", y=" + y +
                ", step=" + step +
                '}';
    }

    static class Num{
        public int num;
        public Num(int n){
            num = n;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) {
        ArrayList<Num> arrayList = new ArrayList<>();
        Num target = new Num(0);
        arrayList.add(target);
        target = new Num(8);
        arrayList.add(target);
        System.out.println(arrayList);
    }
    public static void changeNum(int t){
        t = 1;
    }
    public static void changeNum2(Num t){
        t.num = 1;
    }
}

