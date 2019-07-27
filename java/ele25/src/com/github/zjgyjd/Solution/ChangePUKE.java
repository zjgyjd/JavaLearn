package com.github.zjgyjd.Solution;

public class ChangePUKE {
    //n个盒子,放n个扑克,即找到所有n个的排列组合,利用DFS深度遍历
    public static void DFS(int index, int n, int[] book, int[] box) {
        if(index >= n){
            //判断边界条件,输出结果,有1,2,3...代表不同的牌
            for (int i = 0; i < n ; i++) {
                System.out.print(box[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (book[i] == 0) {
                //代表这张牌没有被使用
                box[index] = i + 1;
                book[i] = 1;
                DFS(index + 1, n, book, box);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] box = {0,0,0};
        int[] book = {0,0,0};
        DFS(0,box.length,book,box);
    }
}
