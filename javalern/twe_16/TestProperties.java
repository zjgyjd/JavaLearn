package com.github.zjgyjd.JCF;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        //用于属性文件
        //读取文件 lode 流操作
        //写入文件 store
        Properties properties = new Properties();
        try {
            InputStream inputStream = TestProperties.class.getClassLoader().getResourceAsStream("com/github/zjgyjd/JCF/hello.properties");
            //此时文件要传从根目录开始路径

            //通过文件
            properties.load(new FileInputStream("D:\\JavaLearn\\java\\ele25\\src\\com\\github\\zjgyjd\\JCF\\hello.properties"));
            System.out.println( properties.get("java"));//继承自Hash的方法
            System.out.println(properties.getProperty("php"));
            System.out.println(properties.getProperty("PHP","PHP is best"));//没有时传入默认
            //修改属性
            properties.put("php","PHP is best");
            properties.setProperty("GO","Go is better");

            //存储
           // properties.store(new FileOutputStream("D:\\JavaLearn\\java\\ele25\\src\\com\\github\\zjgyjd\\JCF\\hello.properties"),"写入");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
