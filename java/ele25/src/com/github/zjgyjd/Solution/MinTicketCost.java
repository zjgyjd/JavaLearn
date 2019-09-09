package com.github.zjgyjd.Solution;

public class MinTicketCost {

    public int minCost(int[] days, int[] costs) {

        int weeks = 0, months = 0;
        int[] result = new int[days.length];

        for (int i = 0; i < days.length; i++) {

            while (days[weeks] < days[i] - 7) weeks++; //找到最近7天
            while (days[months] < days[i] - 30) months++; // 找到最近30天
            result[i] = Math.min(Math.min(result[i] + costs[0], result[weeks] + costs[1]), result[months] + costs[3]);
        }
        return result[days.length - 1];

    }


}
