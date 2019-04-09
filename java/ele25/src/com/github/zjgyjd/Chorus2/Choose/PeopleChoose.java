package com.github.zjgyjd.Chorus2.Choose;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class PeopleChoose {
    static int end = 0;//控制程序退出
    static int count = 0;

    /**
     * 读入女生文件
     * 利用流输入读入数据
     *
     * @return String
     */
    public static String newFile(File file) {
        StringBuilder list = new StringBuilder();
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
     * 计算男 女生的满意度
     *
     * @param man
     * @param girl
     * @return long 满意度数据
     */
    public static long clr(People man, People girl) {
        return man.getHopechar() * girl.getCharacter() + man.getHopelook() * girl.getLook() + (long) man.getHopemoney() * girl.getMoney();
    }

    /**
     * 输入所有女生的被满意度,能力值,id
     *
     * @param sum 满意度
     * @param all 能力值
     * @param id  id
     * @return 返回最满意女生的下标
     */
    public static int getNum(long[] sum, long[] all, long[] id) {
        long max = -1;
        int num = -1;
        for (int i = 0; i < sum.length; i++) {
            if (max < sum[i]) {
                max = sum[i];//如果满意度有大的就覆盖max,并记录此时下标
                num = i;
            } else if (max == sum[i]) { //满意度相等时
                if (all[i] > all[num]) {//能力大的先
                    max = sum[i];
                    num = i;
                } else if (all[i] == all[num]) {//能力如果相同,就比id
                    if (id[i] < id[num]) { //id小优先
                        max = sum[i];
                        num = i;
                    }
                }
            }
        }
        return num;//返回下标
    }

    /**
     * 输入对象和一个链表,将此对象在链表中删除
     * 可能存在问题的地方
     *
     * @param p
     * @param people
     */
    public static void delet(People p, LinkedList<People> people) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).equals(p)) {
                people.remove(i);
                return;
            }
        }
    }

    /**
     * 匹配规则函数:选出一队男女并提出
     *
     * @param copyMan  所剩男生
     * @param copyGirl 所剩女生
     */
    public static void forChoose(LinkedList<People> copyMan, LinkedList<People> copyGirl) {
        HashMap<People, ArrayList<People>> choose = new HashMap<>();//创建以女生为键,男生为链表的HashMap
        long[] sum = new long[1001];//存储男生对女生满意度
        long[] all = new long[1001];//存储所有女生能力值
        long[] id = new long[1001];//存储该女生id

        for (int i = 0; i < copyMan.size(); i++) {
            for (int j = 0; j < copyGirl.size(); j++) {
                sum[j] = clr(copyMan.get(i), copyGirl.get(j));//计算该男生对所有女生的满意度
                all[j] = copyGirl.get(j).getall();//获取女生能力值和id
                id[j] = copyGirl.get(j).getId();//获取id
            }

            int num = getNum(sum, all, id);//获得所有女生中满意度最高的列表下标
            if (choose.get(copyGirl.get(num)) != null) {//判断当前这个键值是否存在
                choose.get(copyGirl.get(num)).add(copyMan.get(i));//存在则直接将男生加入对象
            } else { //该链表不存在,则直接创造新链表
                ArrayList<People> forMan = new ArrayList<>();
                forMan.add(copyMan.get(i));
                choose.put(copyGirl.get(num), forMan);
            }
        }

        Set<People> keySet = choose.keySet();//获取所有键值
        People max = null;//表示最受欢迎的一个
        int sizeMax = -1;//表示这个对象的下标
        for (People s : keySet) { //找到选票最多的那个女生
            if (choose.get(s).size() > sizeMax) {//先判断链表长度
                max = s;
                sizeMax = choose.get(s).size();
            } else if (sizeMax == choose.get(s).size()) {//此时可能有两个女生链表长度相同
                if (max == null) {
                    System.out.println("wrong!!!!");
                }
                if (max.getall() < s.getall()) {//判断两者总值是谁大
                    max = s;
                    sizeMax = choose.get(s).size();
                } else if (max.getall() == s.getall()) {//如果总值一样则比较id
                    if (max.getId() > s.getId()) {//id小的先
                        max = s;
                        sizeMax = choose.get(s).size();
                    }
                }
            }
        }


        ArrayList<People> temp = choose.get(max);//选出本轮女主角
        while (temp.size() != 1) {//通过对长度的判断,选出本轮男主角
            if (clr(max, temp.get(0)) > clr(max, temp.get(1))) {
                temp.remove(1);//此时代表第一个大,移出第二个
            } else if (clr(max, temp.get(0)) < clr(max, temp.get(1))) {
                temp.remove(0);
            } else { //此时满意度相等
                if (temp.get(0).getall() < temp.get(1).getall()) {
                    temp.remove(0);//比较能力
                } else if (temp.get(0).getall() > temp.get(1).getall()) {
                    temp.remove(1);
                } else {//两个能力值相等
                    if (temp.get(0).getId() < temp.get(1).getId()) {
                        temp.remove(1);//比id
                    } else {
                        temp.remove(0);
                    }
                }
            }
        }

        if (max.getId() == -1 || temp.get(0).getId() == -1) {//判断删除目标里面有没有主角Player
            System.out.println(temp.get(0).getId() + ":" + max.getId());
            end = 1;//将结束开关变为1,注意每个主角进场时都要重新变成0     !!!
        }

        delet(max, copyGirl);//此时HashMap里面已经一对一,之后将对应的元素在两个链表里面删除
        delet(temp.get(0), copyMan);

        choose = null;//重置所有
    }

    public static void start(Player p,LinkedList<People> listMan, LinkedList<People> listGirl){
        if (p.sex == 1) {
            //加入男性,放在第一个,注意保持始终100人
            listMan.add(0, p.properties);
        } else {
            listGirl.add(0, p.properties);
        }
        //开始执行配对方法
        while (end != 1) {
            if (listGirl.size() == 0 || listMan.size() == 0) {
                System.out.println("是个单身");
                break;
            }
            forChoose(listMan, listGirl);
        }
    }

    /**
     * 主函数调用方法
     *
     * @param args
     */
    public static void main(String[] args) {
        long start  = System.currentTimeMillis();
        //创建双方对象储存位置
        LinkedList<People> listMan = new LinkedList<>();
        LinkedList<People> listGirl = new LinkedList<>();
        LinkedList<Player> lisrPlayer = new LinkedList<>();
        File maleFile = Paths.get("D:","JavaLearn","Java男女匹配作业(集合部分大作业)","1000组待匹配数据", "male.txt").toFile();
        File femaleFile = Paths.get("D:","JavaLearn","Java男女匹配作业(集合部分大作业)","1000组待匹配数据", "female.txt").toFile();
        File playerFile = Paths.get("D:","JavaLearn","Java男女匹配作业(集合部分大作业)","1000组待匹配数据", "players.txt").toFile();
        String man = newFile(maleFile);

        String[] mans = man.split(System.lineSeparator());

        for (String m : mans) {
            listMan.add(new People(m));
        }
        String girl = newFile(femaleFile);
        String[] girls = girl.split(System.lineSeparator());
        for (String g : girls) {
            listGirl.add(new People(g));
        }
//
//        LinkedList<People> copyMan = (LinkedList<People>) listMan.clone();
//       LinkedList<People> copyWoman = (LinkedList<People>) listGirl.clone();
//        String p = "0,9,56,31,7,73,20";
//        Player s = new Player(p);
//        start(s,copyMan,copyWoman);
        //将主角加入配对
        String play = newFile(playerFile);
        String[] plays = play.split(System.lineSeparator());
        for (String p : plays) {
            lisrPlayer.add(new Player(p));
        }
       while(lisrPlayer.size()!=0){
           LinkedList<People> copyMan = (LinkedList<People>) listMan.clone();
           LinkedList<People> copyWoman = (LinkedList<People>) listGirl.clone();
           Player p = lisrPlayer.remove();
           start(p,copyMan,copyWoman);
           end =0;
       }

        System.out.println(end-start);
    }
}


class People {
    private int id;//id
    private int money;//财富
    private int look;//样貌
    private int character;//品质
    private int hopemoney;//期望财富
    private int hopelook;//期望颜值
    private int hopechar;//期望品格

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
        this.money = money;
        this.look = look;
        this.character = character;
        this.hopelook = hopelook;
        this.hopechar = hopechar;
        this.hopemoney = hopemoney;
    }

    //创造一个提取String的构造器
    public People(String all) {
        String[] a = all.split(",");
        if (a.length == 7) {
            this.id = Integer.valueOf(a[0]);
            this.money = Integer.valueOf(a[1]);
            this.look = Integer.valueOf(a[2]);
            this.character = Integer.valueOf(a[3]);
            this.hopemoney = Integer.valueOf(a[4]);
            this.hopelook = Integer.valueOf(a[5]);
            this.hopechar = Integer.valueOf(a[6]);
        }
    }

    public People(int id, String player) {
        String[] a = player.split(",");
        if (a.length == 7) {
            this.id = id;
            this.money = Integer.valueOf(a[1]);
            this.look = Integer.valueOf(a[2]);
            this.character = Integer.valueOf(a[3]);
            this.hopemoney = Integer.valueOf(a[4]);
            this.hopelook = Integer.valueOf(a[5]);
            this.hopechar = Integer.valueOf(a[6]);
        }
    }

    public long getall() {
        return (long) look + character + money;
    }
}

class Player {
    People properties;
    int sex;

    public Player(String s) {//设置主角
        String[] a = s.split(",");
        if (Integer.valueOf(a[0]) == 0) {//Player没有id 0代表女性 1代表男性
            properties = new People(-1, s); //设置主角id为-1
        } else {
            properties = new People(-1, s);
            sex = 1;
        }
    }
}
