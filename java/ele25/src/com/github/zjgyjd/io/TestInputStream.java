package com.github.zjgyjd.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class TestInputStream {
    public static void code1(){
        File file = Paths.get("D:","test","test.txt").toFile();
        File destFile = Paths.get("D:","Test","test2.txt").toFile();
        try(FileInputStream in = new FileInputStream(file);//放在try后可以自动关闭流
            FileOutputStream out = new FileOutputStream(destFile)
        ){
            byte[] buff = new byte[10];
            int len = -1;
            while( (len = in.read(buff))!= -1){//全读完返回-1
                System.out.println(new String(buff,0,len));

                out.write(buff,0,len);//写入test2,如果不写偏移量则abcdefgh,会输出abcdefghfg
            }
        }catch(IOException e){

        }

    }

    public static void copy(String srcFilePath,String destFilePath){
        //参数校验
        if(srcFilePath == null||srcFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFilePath nust be not null/empty");
        }

        if(destFilePath == null||destFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFilePath nust be not null/empty");
        }
        File srcFile = Paths.get(srcFilePath).toFile();
        File destFile = Paths.get(destFilePath).toFile();
        //文件校验
        if(!srcFile.exists()||!srcFile.isFile()){
            throw new IllegalArgumentException("srcFile nothing");
        }
        File parentFile = destFile.getParentFile();//输出流只会创造文件,所以要准备目录
        if(!parentFile.exists()){
            if(!parentFile.mkdirs()){
                throw new RuntimeException("can not get Path");
            }
        }
        //文件复制
        try(FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(destFile)
        ){
            byte[] buff = new byte[1024];//1k 2k 4k, 8k
            int len =-1;
            while((len = in.read(buff))!=-1){
                out.write(buff,0,len);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        // System.getProperties().list(System.out);//输出编码格式

    }
}
