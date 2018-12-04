package com.github.zjgyjd.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestByteStream {

    public static void code1() throws IOException {


        //输入流
        //1.1 准备文件
        //1.2 实例化input对象
        //1.3 read()读
        //1.4 业务处理
        //1.5 关闭输入流--finally

        //输出流
        //1.1 准备文件,不存在会自动创建但是目录不行
        //1.2 实例化output对象
        //1.3 write()写
        //1.4 业务处理
        //1.5 关闭流--finally
        //input.txt->output.txt
        File srcFile = Paths.get("D:","Test","input.txt").toFile();
        File outPutFile = Paths.get("D:","Test","outPutFile.txt").toFile();
        FileInputStream ins = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(outPutFile,true);//append默认false此时不增加文件内容
        //true时每次调用会增加相同内容
        int value = -1;
        while((value= ins.read())!=-1){//结尾返回-1
            value = value+32;
            out.write(value);
        }
        out.flush();//write要写的太多时,刷新到磁盘
        ins.close();
        out.close();//关闭数据流
    }
    public static void code2(){}

    public static void main(String[] args) throws IOException {
      File file = Paths.get("D:","Test","java6.txt").toFile();
      OutputStream out =null;
      out = new FileOutputStream(file);
      out.write(65);

      byte[] data = new byte[]{65,66,67};
      out.write(data);
      out.write(data,2,1);//写入一部分
      String msg = "java6 666";
        out.write('\n');
      out.write(msg.getBytes());
      out.close();
    }
}

