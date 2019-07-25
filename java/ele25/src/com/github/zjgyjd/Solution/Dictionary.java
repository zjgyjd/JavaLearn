package com.github.zjgyjd.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String regex = "\\s+";
        while (s.hasNext()) {
            String[] targets = s.nextLine().split(regex);
            int num = Integer.parseInt(targets[0]);
            int n = Integer.parseInt(targets[num + 2]);
            String target = targets[num + 1];
            ArrayList<String> x = new ArrayList<>();
            for (int i = 1; i < num + 1; i++) {
                if (!target.equals(targets[i]) && target.length() == targets[i].length()) {
                    boolean has = true;
                    for (int j = 0; j < target.length(); j++) {
                        if (targets[i].indexOf(target.charAt(j)) == -1) {
                            has = false;
                        }
                    }
                    x.add(targets[i]);
                }
            }
            x.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(0) > o2.charAt(0)) {
                            return 1;
                        } else if (o1.charAt(0) < o2.charAt(0)) {
                            return -1;
                        }
                    }
                    return 0;
                }
            });
            System.out.println(x.size() + " " + x.remove(n -1));
        }
    }
}
