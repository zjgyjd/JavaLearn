package com.github.zjgyjd.io;

import java.io.*;
import java.nio.file.Paths;

public class TestMemoryStream {
    public static void code1() {
        String data = "hello world";//转换城大写
        //字节内存流  整个过程在内存里完成

        try (InputStream in = new ByteArrayInputStream(data.getBytes());
             OutputStream out = new ByteArrayOutputStream()//默认32字节缓冲
        ) {
            byte[] buff = new byte[3];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                //业务逻辑,小写转大写,还需要判断是否为小写字母
                for (int i = 0; i < len; i++) {
                    if (buff[i] >= 'a' && buff[i] <= 'z') {
                        buff[i] = (byte) (buff[i] - 32);//注意加强转
                    }
                }
                out.write(buff, 0, len);
            }
            byte[] newData = ((ByteArrayOutputStream) out).toByteArray();//需要向下转型
            System.out.println(new String(newData));
        } catch (IOException e) {

        }
    }

    public static void mergeFile() {
        //内存流合并两个文件
        //data-a.txt data-b.txt =>data.txt
        //InputStream,InputStream=>ByteArrayOutputStream(内存里)-->OutputStream
        File file1 = Paths.get("D:", "test", "data-a.txt").toFile();
        File file2 = Paths.get("D:", "test", "data-b.txt").toFile();
        File file3 = Paths.get("D:", "test", "data.txt").toFile();
        try (
                FileInputStream in1 = new FileInputStream(file1);
                FileInputStream in2 = new FileInputStream(file2);
                ByteArrayOutputStream memoryOut = new ByteArrayOutputStream();
                FileOutputStream out = new FileOutputStream(file3)
        ) {
            byte[] buff = new byte[3];
            int len = -1;
            //读文件写入内存流
            while ((len = in1.read(buff)) != -1) {
                memoryOut.write(buff, 0, len);
            }

            while ((len = in2.read(buff)) != -1) {
                memoryOut.write(buff, 0, len);
            }
            //写出
            out.write(memoryOut.toByteArray());

        } catch (IOException e) {

        }
    }

    public static void mergeFileBetter(String[] mergePaths, String outPath) {
        //要对参数进行校验,这里没做
        //校验完毕后
        File[] files = new File[mergePaths.length];
        //初始化
        for (int i = 0; i < mergePaths.length; i++) {
            files[i]= new File(mergePaths[i]);//将所有路径创建对象
        }

        try (ByteArrayOutputStream memoryOut = new ByteArrayOutputStream();
                     FileOutputStream out = new FileOutputStream(outPath)
        ) {


            for (File f : files) {
                try (FileInputStream in = new FileInputStream(f)
                ) {
                    byte[] buff = new byte[3];
                    int len = -1;
                    //读文件写入内存流
                    while ((len = in.read(buff)) != -1) {
                        memoryOut.write(buff, 0, len);
                    }
                } catch (IOException e) {
                //写一个关闭一次输入流
                }
            }
            //所有文件读完
            out.write(memoryOut.toByteArray());
            //此时完成将n个文件,合成到一个文件中
        } catch (IOException e) {
            e.printStackTrace();
            //最后关闭输出流
        }
    }

    public static void main(String[] args) {

    }

}
