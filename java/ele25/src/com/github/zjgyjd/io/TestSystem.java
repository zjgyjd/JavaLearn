package com.github.zjgyjd.io;

import java.util.Map;
import java.util.Properties;

public class TestSystem {
    public static void code1(){
        //系统属性
        Properties properties = System.getProperties();
        //常用的系统属性
        //user.home
        //user.dir
        //java.home
        //path.separator
        //file.separator
        String userHome = (String) properties.get("user.home");
        System.out.println(userHome);
    }
    public static void code2(){
        Map<String,String> env = System.getenv();
        for(Map.Entry<String,String> entry:env.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());//获得各种环境变量
        }
        //系统环境变量
        //JAVA_HOME
        //Path
        //TEMP//临时目录
        System.out.println(System.getenv("JAVA_HOME"));
    }
    public static void main(String[] args) {
        code1();
    }
}
