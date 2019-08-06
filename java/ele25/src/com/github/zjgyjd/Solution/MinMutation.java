package com.github.zjgyjd.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        int[] ans = {Integer.MAX_VALUE};
        helper(start,end,bank,new boolean[bank.length],ans,0);
        return ans[0]==Integer.MAX_VALUE ? -1 : ans[0];
    }
    private void helper(String now,String end,String[] bank,boolean[] flag,int[] ans,int res){
        if(now.equals(end)){
            ans[0] = Math.min(ans[0],res);
        }else{
            for(int i =0;i<bank.length;i++){
                if(!flag[i]&&mutation(now,bank[i])){
                    flag[i] = true;
                    helper(bank[i],end,bank,flag,ans,res+1);
                    flag[i] = false;
                }
            }
        }
    }


    private boolean mutation(String a,String b){
        int ans = 0;
        for(int i=0;i<8;i++)
            if(a.charAt(i)!=b.charAt(i))
                ans++;
        return ans==1;
    }

    public int minMutation1(String start, String end, String[] bank){
        // 使用队列进行广度优先搜索，分别记录探索的字符串与此时探索的深度
        Queue<String> queue_s = new LinkedList<String>();
        Queue<Integer> queue_times = new LinkedList<Integer>();
        int bank_length = bank.length;
        queue_s.offer(start);
        queue_times.offer(0);
        while (queue_s.peek() != null) {
            String last_s = queue_s.poll();
            int last_time = queue_times.poll();
            for (int k = 0; k < bank_length; k++){
                String s = bank[k];
                if (s == null){
                    continue;
                }
                int gap_num = 0;
                for (int i = 0; i < 8; i++){
                    if (last_s.charAt(i) != s.charAt(i)){
                        if (gap_num++ == 1){
                            break;
                        }
                    }
                }
                if (gap_num > 1){
                    continue;
                }else if (s.equals(end)){
                    return last_time + 1;
                }
                bank[k] = null;
                queue_s.offer(s);
                queue_times.offer(last_time + 1);
            }
        }
        return -1;
    }
}