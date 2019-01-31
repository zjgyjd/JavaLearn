package com.github.zjgyjd.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class TestIoUtil {
    public static void code1() {
        File file1 = Paths.get("D:", "SAO", "SAObegin.avi").toFile();
        File file2 = Paths.get("D:", "SAO", "SAObegin2.avi").toFile();

        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2)
        ) {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            long result = IoUtil.copy(fileReader, fileWriter);
            if (result != -1) {
                System.out.println("复制成功,字节数为:" + result);
            } else {
                System.out.println("复制失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file1 = Paths.get("D:", "SAO", "SAO.jpg").toFile();
        File file2 = Paths.get("D:", "SAO", "SAO2.jpg").toFile();

        try (FileInputStream fileReader = new FileInputStream(file1);
             FileOutputStream fileWriter = new FileOutputStream(file2)
        ) {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            long result = IoUtil.copy(fileReader, fileWriter);
            if (result != -1) {
                System.out.println("复制成功,字节数为:" + result);
            } else {
                System.out.println("复制失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Dome1 {
    public static void main(String[] args) {
        File file1 = Paths.get("D:", "test.txt").toFile();
        File file2 = Paths.get("D:", "test2.txt").toFile();
        try (FileInputStream in = new FileInputStream(file1);
             FileOutputStream out = new FileOutputStream(file2)
        ) {
            int len = -1;
            byte[] buff = new byte[1024];
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Dome2 {
    public static void main(String[] args) {
        File file1 = Paths.get("D:", "test.txt").toFile();
        File file2 = Paths.get("D:", "test2.txt").toFile();
        try (BufferedReader in = new BufferedReader(new FileReader(file1));
             BufferedWriter out = new BufferedWriter(new FileWriter(file2))
        ) {
            //通过缓冲的方式进行高效读写
            String len = null;
            while((len = in.readLine())!=null){
                out.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Dome3{
    public static void main(String[] args) {
        File file1 = Paths.get("D:", "test.txt").toFile();
        Charset charset = Charset.forName("UTF-8");
        try (FileInputStream in  = new FileInputStream(file1);
             InputStreamReader toReader = new InputStreamReader(in,charset);
             BufferedReader reader = new BufferedReader(toReader)
        ){
            String len = null;
            while ((len=reader.readLine())!=null){
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}