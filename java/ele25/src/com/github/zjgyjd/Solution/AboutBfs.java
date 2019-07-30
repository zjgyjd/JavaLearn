package com.github.zjgyjd.Solution;

import java.util.LinkedList;

class AboutBfs {

    public static void main(String[] args) {
        int[][] map =
                {{0,0,0}
                ,{0,0,0}
                ,{1,0,0}};
        new AboutBfs().BFS(map , 0 ,0,2,2);
    }

    public void BFS(int[][] map, int startx, int starty, int destx, int desty) {
        int m = map.length;
        int n = map[0].length;
        LinkedList<node> queue = new LinkedList<>();
        int[][] book = new int[m][n];

        queue.add(new node(startx, starty, 0));
        book[startx][starty] = 1;
        int[][] next = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean flag = false;
        while (!queue.isEmpty()) {
            int step = queue.getFirst().step;
            for (int i = 0; i < 4; i++) {
                int nx = queue.getFirst().x + next[i][0];
                int ny = queue.getFirst().y + next[i][1];

                if (nx < 0 || nx >= m
                        || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 0 && book[nx][ny] == 0) {

                    queue.add(new node(nx, ny, step + 1));
                    book[nx][ny] = 1;
                }
                if (nx == destx && ny == desty) {
                    System.out.println(step + 1);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            queue.remove();
        }
    }
}
