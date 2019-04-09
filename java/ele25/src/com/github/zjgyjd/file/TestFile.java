package com.github.zjgyjd.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;//由静态方法组成,是Path的辅助类
import java.util.Date;


public class TestFile {
    public static void code1() {
        File file = new File("D:" + File.separator + "a" + File.separator + "hello.txt");
        if (!file.exists()) {
            File parentfile = file.getParentFile();//找到父类目录a
            if (parentfile.exists()) {
                if (parentfile.mkdirs()) {//创建目录以及上级目录
                    System.out.println("Success");
                }
            }
            try {
                if (file.createNewFile()) {
                    System.out.println("Success");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void code2() {
        File file = new File("D:" + File.separator + "a" + File.separator + "hello.txt");
        file.isDirectory();//是否是目录
        file.isFile();//是否是文件
        new Date(file.lastModified());//修改时间 需要date获取时间
        file.length();//文件大小 目录时不可用
    }

    public static void code3() {
        File file = new File("D:" + File.separator + "a" + File.separator + "hello.txt");
        //对目录操作
        // file.list();//返回路径
        File[] files = file.listFiles();//返回目录下文件实例化对象,有几个就是几个数组,当时file是文件时会返回null
        if (files != null) {
            file.getName();//返回文件名
            file.getAbsolutePath();//返回绝对路径
        }
    }

    public static void code4() {
        //Paths辅助类;用于创建Path
        Path path = Paths.get("D:", "test");
        //D://test/a
        Path path1 = Paths.get("D:", "test", "a");
        File file = path.toFile();

        //Files辅助File,对文件进行各种判断删除操作
    }

    public static void findFile(File file, int level) {
        if (file.isFile()) {
            System.out.println(file.getName());
        } else {
            System.out.println("+ " + file.getName());
            File[] files = file.listFiles();
            for (File f : files) {
                findFile(f, level + 2);//递归查找遍历
            }
        }

    }

    public static void main(String[] args) {
        // File file = new File("D:" + File.separator + "a" + File.separator + "hello.txt");

    }
}

