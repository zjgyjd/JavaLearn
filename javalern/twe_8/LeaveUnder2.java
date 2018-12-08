package com.github.zjgyjd.Chorus2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeaveUnder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //给定地牢长度
        int n = scanner.nextInt();//行
        int m = scanner.nextInt();//列
        //创建地牢
        char underMap[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            underMap[i] = scanner.next().toCharArray();
        }
        //附图存入到达最小步数
        int spetMap[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                spetMap[i][j] = Integer.MAX_VALUE;
            }
        }
        //输入入口
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        spetMap[startX][startY] = 0;//定义入口为零
        //输入最大步长
        int k = scanner.nextInt();
        //创建每次步长允许长度
        int kLimt[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            kLimt[i][0] = scanner.nextInt();
            kLimt[i][1] = scanner.nextInt();
        }

        //开始处理数据,创建一个内部类
        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Node toNext(int k) {
                return new Node(x + kLimt[k][0], y + kLimt[k][1]);
            }

            public Boolean isPoint() {
                return x >= 0 && y >= 0 && x < n && y < m && underMap[x][y] == '.';
            }
        }
        //创建入口对象,以及队列
        Node start = new Node(startX, startY);
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node now = queue.poll();//删除当前的第一个元素赋予now,表示当前操作点
            for (int i = 0; i < k; i++) {
                //遍历所有步数到达的值
                Node next = now.toNext(i);
                if (next.isPoint()) {//排除障碍
                    if (spetMap[next.x][next.y] > spetMap[now.x][now.y] + 1) {
                        spetMap[next.x][next.y] = spetMap[now.x][now.y] + 1;
                        queue.add(next);//将可行点入队3
                    }
                }

            }
        }
        int result =0;
        for(int i =0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(underMap[i][j] == '.') result = Math.max(result, spetMap[i][j]);
                //到达某个点最小的的步数长中最大的一个
            }
        }
        //如果在整个地牢中存在一个无法到达的点则将返回-1
        System.out.println(result == Integer.MAX_VALUE?-1:result );
    }
}
