package com.github.zjgyjd.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WrongNote {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> node = new HashMap<>();
        while (!s.hasNext("0")) {
            String[] detail = s.nextLine().split("\\\\");
            String wrong = detail[detail.length - 1];
            String fName = wrong.split("\\s+")[0];
            String times = wrong.split("\\s+")[1];
            wrong = fName + " " + times;
            if (fName.length() > 16) {
                fName = fName.substring(15);
            }
            if (node.containsKey(wrong)) {
                node.put(wrong, node.get(wrong) + 1);
            }else {
                node.put(wrong,1);
            }
            if(node.size() > 8){
                node.keySet();
                String target = null;
                for(String t : node.keySet()){
                    target = t;
                    break;
                }
                node.remove(target);
            }
        }
        for (Map.Entry<String,Integer> t : node.entrySet()){
            System.out.println(t.getKey()+" "+t.getValue() );
        }
    }
}
