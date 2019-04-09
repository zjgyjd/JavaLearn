package com.github.zjgyjd.io;

import javafx.scene.PerspectiveCamera;

import java.io.*;
import java.nio.file.Paths;

public class TestSerializable {
    /*
    1.Object (In Memory)->byte[](网络中传输,保存文件)序列化
    byte[]            ->Object反序列化
    2.Object    -> XML(XML文件)
    XML         -> Object
    3.Object    -> JSON
    JSON        -> Object
     */
    public static void code1() {
        //1.准备序列化输出的文件
        //2.准备要参与的序列化对象
        //3.业务操作不依赖构造器
        //反序列化打印属性
        File objFile = Paths.get("D:", "Test", "person.obj").toFile();
        Person person = new Person("JAck", 18, "1515");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objFile));
        ) {
            out.writeObject(person);
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {

    }

}

class Person implements Serializable {//标识接口,什么都不用干标识可以序列化
    private String name;
    private Integer age;
    private String email;//利用transient可以使某一个属性序列化

    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}