package com.zjgyjd.vo;

/**
 * POJO:简单(只有GetSet)  原始(没有继承) Java对象
 */
public class User {
    private int Id;
    private String username;
    private String password;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
