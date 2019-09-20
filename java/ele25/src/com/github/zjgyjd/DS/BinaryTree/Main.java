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

    public static void haha(String[] args) {
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

    public void test(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] line1 = s.nextLine().split(" ");
        Node end = new Node(Integer.parseInt(line1[0]), Integer.parseInt(line1[1]));
        int time = Integer.parseInt(line1[2]);
        Node[] map = new Node[time];
        for (int i = 0; i < time; i++) {
            String[] line = s.nextLine().split(" ");
            map[i] = new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        System.out.println(smallStep(map, end));
    }

    public static int smallStep(Node[] map, Node end) {
        //                                    1,1 2,1
        //2 0 3                   (x,y)  0,0  1,0 2,0
        //                                    1,-1
        //1 0
        //1 1
        //1 -1
        //6
        //先利用队列
        LinkedList<Node> result = new LinkedList<>();
        result.add(new Node(0, 0));//将起点存入其中,可以从这个点向上下左右四个方向走
        int[][] array = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (true) {
            int size = result.size();
            while (size-- != 0) {
                Node target = result.removeFirst();
                target.run = true;
                for (int i = 0; i < 4; i++) {
                    Node test = new Node(target.x + array[i][0], target.y + array[i][1]);
                    if (!isBlock(map, test)) {
                        result.add(test);
                    }
                    if (test.x == end.x && test.y == end.y) {
                        return ++step;
                    }
                }
            }
            step++;
        }
    }

    private static boolean isBlock(Node[] map, Node test) {
        if (test.run) {
            return true;
        }
        for (Node aMap : map) {
            if (test.x == aMap.x && test.y == aMap.y) {
                return true;
            }
        }
        return false;
    }

    public static void hah(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().split(" ")[1]);
        String[] target = s.nextLine().split(" ");
        findMin(target, n);
    }

    public static void findMin(String[] target, int n) {
        Integer[] temp = new Integer[target.length];
        for (int i = 0; i < target.length; i++) {
            temp[i] = Integer.parseInt(target[i]);
        }
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int sum = 0;
        int start = temp.length - 1;
        for (int i = 0; i < n; i++) {
            if (i >= temp.length) {
                System.out.println(0);
                continue;
            }
            int t = temp[start - i];
            int x = t - sum;
            if (x == 0) {
                n++;
                continue;
            }
            System.out.println(t - sum);
            sum += (t - sum);
        }
    }
    //    4 6 0 0 3 3
    //    0 5 6 5 0 3
    //    4 9  10 9  4 7
    //    6 11 12 11 6 9
    //    0 5  6  5  0 3
    //    0 5  6  5  0 3
    //    3 8  9  8  3 6
    //    3 8  9  8  3 6

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] num1 = s.nextLine().split(" ");
        String[] num2 = s.nextLine().split(" ");
        Long[] num = parseTwoNum(num1, num2, n);
        parseNum(num);
    }


    public static Long[] parseTwoNum(String[] n1, String[] n2, int n) {
        if(n != n1.length || n != n2.length){
            System.out.println(5);
        }
        Long[] result = new Long[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i * n + j] = Long.parseLong(n1[i]) + Long.parseLong(n2[j]);
            }
        }
        return result;
    }

    public static void parseNum(Long[] num) {
        if(num == null){
            return;
        }
        Long sum = num[0];
        for (int i = 1; i < num.length; i++) {
            sum = sum ^ num[i];
        }
        System.out.println(sum);
    }
}

class Node {
    public int x;
    public int y;
    public boolean run = false;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


