package com.github.zjgyjd.Solution;

public class EditDistance {
    /**
     * 编辑距离，又称Levenshtein距离（也叫做Edit Distance），
     * 是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。
     * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，
     * 删除一个字符。
     * 例如将kitten一字转成sitting：
     * sitten （k->s）
     * sittin （e->i）
     * sitting （->g）
     * 所以kitten和sitting的编辑距离是3。俄罗斯科学家
     * Vladimir Levenshtein在1965年提出这个概念。
     * 给出两个字符串a,b，求a和b的编辑距离。
     *
     * @param strN
     * @param strM
     * @return
     */
    public int editDistance(String strN, String strM) {
        int[][] distanceMap = new int[strN.length() + 1][strM.length() + 1];
        //对边框进行初始化
        for (int i = 0; i < distanceMap.length; i++) {
            distanceMap[i][0] = i;
        }
        for (int i = 0; i < distanceMap[0].length; i++) {
            distanceMap[0][i] = i;
        }
        for (int i = 1; i < distanceMap.length; i++) {
            for (int j = 1; j < distanceMap[0].length; j++) {
                if (strN.charAt(i - 1) == strM.charAt(j - 1)) {
                    distanceMap[i][j] = distanceMap[i - 1][j - 1];
                } else {
                    int max = Math.min(distanceMap[i][j - 1], distanceMap[i - 1][j - 1]);
                    max = Math.min(distanceMap[i - 1][j], max);
                    distanceMap[i][j] = max + 1;
                }
            }
        }
        return distanceMap[strN.length()][strM.length()];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().editDistance("kitten", "sitting"));
    }
}
