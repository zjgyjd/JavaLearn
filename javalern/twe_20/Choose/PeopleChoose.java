package com.github.zjgyjd.Chorus2.Choose;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class PeopleChoose {

    /**
     * 读入女生文件
     *
     * @return String
     */
    public static String newFile(File file) {
        StringBuilder list = new StringBuilder();
        //利用流输入读入数据
        try (FileInputStream in = new FileInputStream(file)) {
            Long size = file.length();
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                list.append(new String(buff, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toString();
    }

    /**
     * 计算女生的满意度
     *
     * @param man
     * @param girl
     * @return long 满意度数据
     */
    public static long clr(People man, People girl) {
        return man.getHopechar() * girl.getCharacter() + man.getHopelook() * girl.getLook() + (long) man.getHopemoney() * girl.getMoney();
    }

    public static int getNum(long[] sum, long[] all, long[] id) {
        long max = -1;
        int num = -1;
        for (int i = 0; i < sum.length; i++) {
            if (max < sum[i]) {
                max = sum[i];
                num = i;
            }
            if (max == sum[i]) {
                if (all[i] > all[num]) {
                    max = sum[i];
                    num = i;
                } else if (all[i] == all[num]) {
                    if (id[i] < id[num]) {
                        max = sum[i];
                        num = i;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        //创建双方对象储存位置
        List<People> listMan = new LinkedList<>();
        List<People> listGirl = new LinkedList<>();
        HashMap<People, People> choose = new HashMap<>();
        File maleFile = Paths.get("D:", "JavaLearn", "Java男女匹配作业(集合部分大作业)", "作业", "male.txt").toFile();
        File femaleFile = Paths.get("D:", "JavaLearn", "Java男女匹配作业(集合部分大作业)", "作业", "female.txt").toFile();
        String man = newFile(maleFile);
        String[] mans = man.split("\n");
        for (String m : mans) {
            listMan.add(new People(m));
        }
        String girl = newFile(femaleFile);
        String[] girls = girl.split("\n");
        for (String g : girls) {
            listGirl.add(new People(g));
        }
        //开始执行配对方法
        long[] sum = new long[listMan.size()];
        long[] all = new long[listMan.size()];
        long[] id = new long[listMan.size()];
        for (int i = 0; i < listMan.size(); i++) {
            for (int j = 0; j < listGirl.size(); j++) {
                //计算对所有女生的满意度
                sum[j] = clr(listMan.get(i), listGirl.get(j));
                //获取女生能力值和id
                all[j] = listGirl.get(j).getall();
                id[j] = listGirl.get(j).getall();
            }
            //获得所有女生中满意度最高的
            int num = getNum(sum, all, id);
            choose.put(listMan.get(i), listGirl.get(num));
        }
        int count = 0;

        Set<People> keySet = choose.keySet();
        for (People p : keySet) {
            System.out.println(p.getId() + ":" + choose.get(p).getId());
            count++;
        }
        System.out.println(count);
        System.out.println(keySet.size());
        System.out.println(listGirl.size());
        System.out.println(listMan.size());
    }
}

//1.创建一个代表男士的对象
class People {
    //2.属性代表该男士,和女士的数值
    private int id;//id
    private int look;//样貌
    private int character;//品质
    private int money;//财富
    private int hopelook;//期望颜值
    private int hopechar;//期望品格
    private int hopemoney;//期望财富

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id &&
                look == people.look &&
                character == people.character &&
                money == people.money &&
                hopelook == people.hopelook &&
                hopechar == people.hopechar &&
                hopemoney == people.hopemoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, look, character, money, hopelook, hopechar, hopemoney);
    }

    public int getId() {
        return id;
    }

    public int getLook() {
        return look;
    }

    public int getCharacter() {
        return character;
    }

    public int getMoney() {
        return money;
    }

    public int getHopelook() {
        return hopelook;
    }

    public int getHopechar() {
        return hopechar;
    }

    public int getHopemoney() {
        return hopemoney;
    }

    public People(int id, int look, int character, int money, int hopelook, int hopechar, int hopemoney) {
        this.id = id;
        this.look = look;
        this.character = character;
        this.money = money;
        this.hopelook = hopelook;
        this.hopechar = hopechar;
        this.hopemoney = hopemoney;
    }

    //创造一个提取String的构造器
    public People(String all) {
        String[] a = all.split(all);
        if (a.length == 7) {
            this.id = Integer.valueOf(a[0]);
            this.look = Integer.valueOf(a[1]);
            this.character = Integer.valueOf(a[2]);
            this.money = Integer.valueOf(a[3]);
            this.hopelook = Integer.valueOf(a[4]);
            this.hopechar = Integer.valueOf(a[5]);
            this.hopemoney = Integer.valueOf(a[6]);
        }
    }

    public long getall() {
        return (long) look + character + money;
    }
}

class FeMale {
    //2.属性代表该女士的数值
    int id;//id
    int look;//样貌
    int character;//品质
    int money;//财富
    int hopelook;//期望颜值
    int hopechar;//期望品格
    int hopemoney;//期望财富

    public FeMale(int id, int look, int character, int money, int hopelook, int hopechar, int hopemoney) {
        this.id = id;
        this.look = look;
        this.character = character;
        this.money = money;
        this.hopelook = hopelook;
        this.hopechar = hopechar;
        this.hopemoney = hopemoney;
    }

    public FeMale(String all) {
        String[] a = all.split(all);
        if (a.length == 7) {
            this.id = Integer.valueOf(a[0]);
            this.look = Integer.valueOf(a[1]);
            this.character = Integer.valueOf(a[2]);
            this.money = Integer.valueOf(a[3]);
            this.hopelook = Integer.valueOf(a[4]);
            this.hopechar = Integer.valueOf(a[5]);
            this.hopemoney = Integer.valueOf(a[6]);
        }
    }
}
