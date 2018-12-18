package com.github.zjgyjd.util;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Paths;
import java.util.List;

public class TestFileUtil {
    public static void test1(){
        if(FileUtil.isWindows()){
            System.out.println("Is Windows");
        }

//      File[] files =  FileUtil.ls("D:"+File.separator+"JavaLearn"+File.separator+"javalern");
//       for(File i : files){
//           System.out.println(i.getName());
//       }

        if(FileUtil.isDirEmpty(Paths.get("D:","Test"))){
            System.out.println("目录是空的");
        }else{
            System.out.println("目录不是空的");
        }

        File file = Paths.get("D:","JavaLearn","javalern").toFile();
        System.out.println(FileUtil.getAbsolutePath(file));
        System.out.println(FileUtil.isAbsolutePath("D:"+File.separator+"JavaLearn"+File.separator+"javalern"));

        System.out.println("临时文件路径为:");
        System.out.println(FileUtil.getTmpDirPath());
        System.out.println("用户文件路径为:");
        System.out.println(FileUtil.getUserHomePath());
        System.out.println(FileUtil.lastModifiedTime(file));
        System.out.println(FileUtil.size(file));
        File file1 = Paths.get("D:","Test.txt").toFile();
        System.out.println(FileUtil.size(file1));
    }
    public static void test2(){
        File file =Paths.get("D:","Test").toFile();
        System.out.println("时间对比");

        if(FileUtil.newerThan(file,System.currentTimeMillis()-3600000)){
            //是否比当前时间晚一天
            System.out.println("文件在一小时之内被改动过");
        }else{
            System.out.println("文件一小时内无改动");
        }
    }

    public static void test3(){
        System.out.println("创建父目录");
        File file =Paths.get("D:","Test").toFile();
        File parentFile =  FileUtil.mkParentDirs(file);


        List<File> list = FileUtil.loopFiles("D:"+File.separator+"Test", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
        System.out.println(list);
    }

    public static void test4(){
        File file =Paths.get("D:","Test","新建文件夹").toFile();
        FileUtil.touch(file);
        if(FileUtil.del(file)){
            System.out.println("删除成功!!");
        }
        if(FileUtil.clean(file)){
            System.out.println("文件夹已经清空");
        }

    }

    public static void test5(){
        File dest =Paths.get("D:","新建文件夹1").toFile();
        File src =Paths.get("D:","Test").toFile();
        FileUtil.move(src,dest,true);
    }

    public static void main(String[] args) {
        File dest =Paths.get("D:","新建文件夹1").toFile();
       FileUtil.rename(dest,"小可爱.txt",true,true);
    }
}