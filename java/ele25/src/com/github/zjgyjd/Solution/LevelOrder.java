package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LevelOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node ch5 = new Node(5, null);
        Node ch4 = new Node(4, null);
        LinkedList<Node> t = new LinkedList<>();
        t.add(ch5);
        t.add(ch4);
        Node ch2 = new Node(2, t);
        Node ch3 = new Node(3, null);
        t.clear();
        t.add(ch2);
        t.add(ch3);
        Node root = new Node(1, t);
        new LevelOrder().levelOrder(root);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> newFloor = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            newFloor.clear();
            for (int i = 0; i < size; i++) {
                Node target = queue.getFirst();
                newFloor.add(target.val);
                List<Node> child = target.children;
                if (child != null && !child.isEmpty()) {
                    queue.addAll(target.children);
                }
                queue.remove();
            }
            if (!newFloor.isEmpty())
                result.add(newFloor);
        }
        return result;
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        return BFS(grid);
    }

    class Node1 {
        int x;
        int y;
        public Node1(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int BFS(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] book = new int[m][n];
        LinkedList<Node1> queue = new LinkedList<>();

        //将所有腐烂的橘子存进队列
        boolean s = false;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    queue.add(new Node1(i , j));
                }
                if(grid[i][j] == 1){
                    s = true;
                }
            }
        }
        if(!s){
            return 0;//没有新鲜的了
        }
        int[][] p = {{1,0},{0,1},{-1,0},{0,-1}};
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            while(size-- != 0){
                Node1 t = queue.remove();

                for(int i = 0 ; i < 4 ; i++){
                    int nx = t.x + p[i][0];
                    int ny = t.y + p[i][1];
                    if(nx < 0 || nx >= m
                            ||ny < 0 || ny >= n){
                        continue;
                    }
                    if(grid[nx][ny] == 1){
                        flag = true;
                        grid[nx][ny] = 2;
                        queue.add(new Node1(nx , ny));
                    }
                }
            }
            if(flag)
                step++;
        }

        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    queue.add(new Node1(i , j));
                }
                if(grid[i][j] == 1){
                    s = false;
                }
            }
        }
        if(!s){
            return -1;//还有新鲜的了
        }
        return step;
    }
}
