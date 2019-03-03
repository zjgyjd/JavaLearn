package com.github.zjgyjd.io;

import com.github.zjgyjd.generic.Coffee;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class TestFileChannel {

    public static void code0() {
        List<People> test0 = new ArrayList<>();
        test0.add(new People("Lise", 18));
        test0.add(new Boy("Ake", 15));

        List<Boy> test1 = new ArrayList<>();
        test1.add(new Boy("Mark", 18));
        test1.add(new Boy("Sandy", 15));

        System.out.println(min(test0));
        System.out.println(min(test1));
    }

    public static boolean copy(File start, File end) {
        try (
                FileInputStream in = new FileInputStream(start);
                FileOutputStream out = new FileOutputStream(end);
                FileChannel fIn = in.getChannel();
                FileChannel fOut = out.getChannel();
        ) {
            fIn.transferTo(0, fIn.size(), fOut);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static <T extends Comparable<? super T>> T min(List<T> numberArray) {
        if (numberArray == null) {
            return null;
        }
        int len = numberArray.size();
        T min = numberArray.get(0);
        for (int i = 0; i < len; i++) {
            if (min.compareTo(numberArray.get(i)) > 0) {
                min = numberArray.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args)  {
        File s = new File("C:\\Users\\Thinkpad\\Desktop\\test.txt");
        File s2 = new File("C:\\Users\\Thinkpad\\Desktop\\题.txt");
        StringBuilder s3 = new StringBuilder();
        try (
                FileReader test = new FileReader(s);

        ) {
            char[] buff = new char[1024];
            int len = -1;

            while ((len = test.read(buff)) != -1) {
                s3.append(buff,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String d  = s3.toString();

        s3.delete(0,s3.length());
        for (int i = 0; i < d.length(); i++) {
            s3.append(d.charAt(i));
            if(d.charAt(i) == '？'){
               s3.append('\r');
            }
        }

        try(FileWriter test1 = new FileWriter(s2)){
            test1.write(s3.toString().toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class People implements Comparable<People> {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(People o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Boy extends People {
    public Boy(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}