package com.github.zjgyjd.Solution;

import com.github.zjgyjd.DS.SomeTalked.Main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class FakeMap {
    public  HashMap<String , String> map = new HashMap<>();
    public  LinkedList<String> newTime = new LinkedList<>();

    public static void main(String[] args) {
        //先读入N
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        FakeMap fakeMap = new FakeMap();
        HashMap<String , String> map = fakeMap.map;
        LinkedList<String> newTime = fakeMap.newTime;
        while (s.hasNextLine()){
            String t = s.nextLine();
            String[] resource = t.split(" ");
            //得到key value , 存入对列中,触发情况选择,先判断是否存在
            if(map.containsKey(resource[0])){
                if(Long.parseLong(map.get(resource[0])) < Long.parseLong(resource[1])){
                    map.put(resource[0],resource[1]);
                    newTime.remove(resource[0]);//更新会到最前面
                    newTime.add(resource[0]);
                }
            }
            //如果不存在
            else if(map.size() < n){
                map.put(resource[0],resource[1]);
                newTime.add(resource[0]);
            }else if(map.size() == n){
                //此时要除掉最早的,再put
                fakeMap.remove();
                map.put(resource[0],resource[1]);
                newTime.add(resource[0]);
            }
        }
    }

    private  void remove() {
        String target = newTime.removeFirst();//取出第一个
        String s =  map.remove(target);//找到要删除的
        System.out.println(target + " " + s);
    }
}
