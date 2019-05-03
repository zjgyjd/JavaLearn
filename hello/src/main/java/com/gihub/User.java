package com.gihub;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String id;
    private String name;
    private static List<User> users = new ArrayList<>();
    private static File f = null;//所有id地址

    private User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //只允许通过文件构造对象
    public static List<User> createObjct(File s) {
        System.out.println("用户文件读取中.......");
        try (
                LineNumberReader lnr = new LineNumberReader(new FileReader(s));
        ) {
            String temp = null;
            while ((temp = lnr.readLine()) != null) {//不为空行
                users.add(new User((temp.split(":")[0]), temp.split(":")[1]));
            }

        } catch (Exception e) {
            System.out.println("文件有误");
        }
        System.out.println("用户文件读入成功");
        return users;
    }

}
