package com.github.zjgyjd.DS.BinaryTree;


import java.lang.reflect.Array;
import java.util.*;


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

                root.left = reConstructBinaryTree(pre, pStart + 1,//根向后移动
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
        paint[row][line] = (char) (s.value + '0');
        if (s.left != null) {
            paint[row + 1][line - 1] = '/';
            draw(s.left, paint, row + 2, line - 1);
        }
        if (s.right != null) {
            paint[row + 1][line + 1] = '\\';
            draw(s.right, paint, row + 2, line + 1);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(height(root.left), height(root.left));
    }

    public static int kLevel(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevel(root.left, k - 1) + kLevel(root.right, k - 1);
    }

    public static TreeNode find(TreeNode root, int v) {
        if (root == null) {
            return null;
        }
        if (root.value == v) {
            return root;
        } else {
            TreeNode result = find(root.left, v);
            if (result == null) {
                return find(root.right, v);
            } else {
                return result;
            }
        }
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.value == q.value
                && isMirror(p.left, q.right)
                && isMirror(p.left, q.right);
    }


    /**
     * 判别一棵树是不是另一棵树的子树
     */
    //对s按层逐个和t对比，它们的值相同时，比较二者是否相同的树，如果是则返回true，否则继续对比
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while (q.peek() != null) {
            TreeNode r = q.poll();
            if (r.value == t.value) {
                if (isSame(r, t)) return true;
            }
            if (r.left != null) q.offer(r.left);
            if (r.right != null) q.offer(r.right);
        }
        return false;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int height = height(root.right) - height(root.left);
        if (height > 1 || height < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //对比两棵树是否相同，和判断两棵树是否对称很相似，需满足：
    //1.根值相同
    //2.每棵树的左子树与另一棵树的左子树相同
    //3.每棵树的右子树与另一棵树的右子树相同
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 != null && t2 != null) {
            return (t1.value == t2.value)
                    && isSame(t1.left, t2.left)
                    && isSame(t1.right, t2.right);
        }
        return false;
    }


    /**
     * 通过带空节点的前序遍历创建树
     *
     * @param preOrder
     * @return
     */
    public static Rv createTree(char[] preOrder) {
        if (preOrder.length == 0) {
            return new Rv(null, 0);
        }
        char rootT = preOrder[0];
        if (rootT == '#') {
            return new Rv(null, 1);
        }
        TreeNode root = new TreeNode(rootT);

        //2.创建左边节点
        int length = preOrder.length;
        char[] leftArray = Arrays.copyOfRange(preOrder, 1, length);
        Rv left = createTree(leftArray);
        //3.创建右边节点
        char[] rightArray = Arrays.copyOfRange(preOrder, 1 + left.used, length);
        Rv right = createTree(rightArray);
        //4.将左右连续起来
        root.left = left.node;
        root.right = right.node;
        return new Rv(root, left.used + right.used + 1);
    }

    /**
     * 用于返回两个返回值
     */
    public static class Rv {
        TreeNode node;
        int used;

        public Rv(TreeNode node, int used) {
            this.node = node;
            this.used = used;
        }
    }

    public int find(int[] s, int v) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int lengthI = inorder.length;
        int lengthP = postorder.length;
        if (lengthI == 0 && lengthP == 0) {
            return null;
        }

        int root = postorder[lengthP - 1];
        int leftCode = find(inorder, root);
        TreeNode rootP = new TreeNode(root);

        int[] forInorderL = Arrays.copyOfRange(inorder, 0, leftCode);
        int[] forPostorderL = Arrays.copyOfRange(postorder, 0, leftCode);
        rootP.left = buildTree(forInorderL, forPostorderL);

        int[] forInorderR = Arrays.copyOfRange(inorder, leftCode + 1, leftCode);
        int[] forPostorderR = Arrays.copyOfRange(postorder, leftCode, lengthP - 1);
        rootP.right = buildTree(forInorderR, forPostorderR);
        return rootP;
    }

    List<List<Integer>> listAll = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //dfs
        traverse(root, 0);
        //List反转
        Collections.reverse(listAll);
        return listAll;
    }

    public void traverse(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        //每个level一个List
        //若第一次访问该层次，则new一个新的list并加入listAll
        if (listAll.size() <= level) {
            List<Integer> listLevel = new LinkedList<>();
            listAll.add(listLevel);
        }
        //得到当前level的list
        List temp = listAll.get(level);
        //添加当前node的值到该list
        temp.add(root.value);
        //递归左子树
        traverse(root.left, level + 1);
        //递归右子树
        traverse(root.right, level + 1);
    }


    /**
     * 非递归写法的前序(需要掌握)
     */
    public static void perOrdeNoR(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();//此处改为peek造成第三次相遇,写出后序,有三种情况
            /*
            一开始定义一个TreeNode last = null;
            TreeNode peek = stack.peek();
            后序:1.右边为空,直接打印出栈
                if(peek.right == null){
                    打印stack.pop();
                    标记last = peek;
                }
                2.标记最后一个打印的节点,如果当前的右边为该节点,说明为第三次经过,打印出栈
                else if(peek.right == last){
                    打印stack.pop();
                    标记last = peek;
                }
                3.除去两种情况说明并不是第三次经过,还需要往右走 即 cur = peek.right
             */
            //若在此处打印就是中序,相当于第二次遇见时打印
            cur = pop.right;
        }
    }

    public static void main(String[] args) {
        List<Integer> s = new LinkedList<>();

        int[] test0 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] test1 = {4, 2, 7, 1, 5, 3, 8, 6};
        TreeNode test2 = reConstructBinaryTree(test0, test1);

        char[][] paint = new char[count * 2][count * 2];


        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint[i].length; j++) {
                paint[i][j] = ' ';
            }
        }


        draw(test2, paint, 0, count);

        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint[i].length; j++) {
                System.out.print(paint[i][j] + " ");
            }
            System.out.println();
        }

        paint(reConstructBinaryTree(test0, test1));
    }
}
