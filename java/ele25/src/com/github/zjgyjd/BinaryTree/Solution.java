package com.github.zjgyjd.BinaryTree;


public class Solution {
    private static int count = 0;

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return reConstructBinaryTree
                (pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode reConstructBinaryTree
            (int[] pre, int pStart, int pEnd, int[] in, int inStart, int inEnd) {

        //前序:1,2,4,7,3,5,6,8   -->2,4,7 ps= 1,pe= 4  i = 2;--> 4,7 ps= 2,pe= 3  i=0;-->ps= 3,pe=3--> X 左完
        //中序:4,7,2,1,5,3,8,6   -->4,7,2 is= 0,ie= 3        --> 4,7,2 is= 0,ie= 2
        /*
                         1
                        / \
                      2    3
                    /     / \
                  4      5   6
                   \        /
                    7       8
         */

        if (pStart > pEnd
                || inStart > inEnd) {
            return null;
        }



        TreeNode root =
                new TreeNode(pre[pStart]);
        count++;

        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[pStart]) {//pre[pStart] 永远指向当前根节点
                //找到中序遍历根所在位置

                root.left = reConstructBinaryTree(pre, pStart + 1,//根向后左移动
                        pStart + i - inStart,//找到前序根的左半边
                        in, inStart, i - 1);//找到中序根的左半边

                root.right = reConstructBinaryTree(pre, i - inStart + pStart + 1,//根向后右移动
                        pEnd,//找到前序根的右半边
                        in, i + 1, inEnd);//找到中序根的左半边
                break;
            }
        }
        return root;
    }

    public static void paint(TreeNode s) {
        if (s == null) {
            return;
        }

        paint(s.left);
        System.out.print(s.value + " ");
        paint(s.right);
    }

    public static void draw(TreeNode s, char[][] paint, int row, int line) {
        paint[row][line] =(char) (s.value + '0');
        if (s.left != null) {
            paint[row + 1][line - 1] = '/';
            draw(s.left, paint, row + 2, line - 1);
        }
        if (s.right != null) {
            paint[row + 1][line + 1] = '\\';
            draw(s.right, paint, row + 2, line + 1);
        }
    }

    public static void main(String[] args) {
        int[] test0 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] test1 = {4, 2, 7, 1, 5, 3, 8, 6};
        TreeNode test2 = reConstructBinaryTree(test0,test1);

        char[][] paint = new char[count*2][count*2];


        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint[i].length; j++) {
                paint[i][j] = '*';
            }
        }


        draw(test2,paint,0,count);

        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint[i].length; j++) {
                System.out.print(paint[i][j]+" ");
            }
            System.out.println();
        }

        paint(reConstructBinaryTree(test0, test1));
    }
}
