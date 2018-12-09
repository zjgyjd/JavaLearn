package com.github.zjgyjd.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;


public class  TestSystemIO {

    public static void code1() {
//借助BufferedReader实现点名程序
//1.人员数据 2.读入到程序 3.生成随机数 4.输出目标人员
//技术点:
//1.爬虫//暂无利用javaStudent.txt代替
//2.I/O 字符流
//3.Random Array
//4.Out
        File studentDataFile = Paths.get("D:", "Test", "javaStudent.txt").toFile();
        try (InputStream inputStream = new FileInputStream(studentDataFile);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line = null;
            String[] student = new String[42];
            int index = -1;
            while ((line = reader.readLine()) != null) {
                index++;
                student[index] = line;
            }
            Random random = new Random();
            int selectIndex = random.nextInt(student.length);
            System.out.println("选择的学生是：" + student[selectIndex]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


