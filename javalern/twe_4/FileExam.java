package com.github.zjgyjd.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExam {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Test.txt");
        File files = new File("D:"+File.separator+"a");
        File filess = new File("D:"+File.separator+"SAO");
        tree(filess);
        if (!files.exists()) {
            File parentfiles = files.getParentFile();
            if(!parentfiles.exists()){
                if(parentfiles.mkdirs()){
                    System.out.println("目录生成成功");
                    if (!files.exists()) {
                        if (files.createNewFile()) {
                            System.out.println("创建成功");
                        }
                    }
                }
            }
        }
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建成功");
            }
        }
        print(file);
        tree(file);

        print(files);
        tree(files);
    }

    public static void print(File f) {
        if (f.exists()) {
            if (f.isFile()) {
                System.out.println("File:" +f.getName()+" "+ f.length() + " " + new Date(f.lastModified()));
            } else {
                System.out.println("Directory: " + f.getName()+" " + new Date(f.lastModified()));
            }
        }
    }

    public static void tree(File f) {
     if(f.exists()){
         if(f.isFile()){
             System.out.println(f.getName());
         }else{
             System.out.println("+ "+f.getName());
             File[] files = f.listFiles();
             for(File s:files){
                tree(s);
             }
         }
     }
    }
}
