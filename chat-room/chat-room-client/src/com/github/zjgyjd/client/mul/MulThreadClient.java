package com.github.zjgyjd.client.mul;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MulThreadClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 6666);
            modeMap("hhh", client);

            if (start(client)) {
                /*操作模块*/
                modePrint(client);
                /*聊天模块线程*/
                new ReadData(client).start();
                new WriteData(client).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void modePrint(Socket client) throws IOException {
        InputStream message = client.getInputStream();
        Scanner scanner1 = new Scanner(message);
        modeMap("放大镜了", client);
    }

    private static void modeMap(String s, Socket client) {
        String begin = "                                  ";
        char[] temp_0 = begin.toCharArray();
        char[] temp_1 = s.toCharArray();
        for (int i = 0; i < temp_1.length && i < temp_0.length - 1; i++) {
            temp_0[i] = temp_1[i];
        }
        int friend = 0;
//        try {
//            friend = getFriend(client);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("+--__-------------------------------------------------+");
        System.out.println("| |00|       用户名:" + new String(temp_0));
        System.out.println("|/|ZZ|\\                                               |");
        System.out.println("| |__|                                                |");
        System.out.println("|/|\\/|\\                                               |");
        System.out.println("|                     我的好友:" + 3 + "/" +friend);
        System.out.println("|                     选1查看好友" + "                     |");
        System.out.println("|                     选2添加好友" + "                     |");
        System.out.println("|                     选3创建群聊" + "                     |");
        System.out.println("|                     选4注销账号" + "                     |");
        System.out.println("+----------------------------------------------------+");

    }

    private static int getFriend(Socket client) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
        writer.write("getFriend");
        InputStream message = client.getInputStream();
        Scanner scanner1 = new Scanner(message);
        int result = 0;
        try {
            result = scanner1.nextInt();
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }


    private static boolean start(Socket client) {
        try {
            OutputStream clientOutput = client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);

            InputStream message = client.getInputStream();
            Scanner scanner1 = new Scanner(message);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                loginMap();
                int choice = 0;
                try {
                    choice = scanner.nextInt();
                } catch (Exception e) {
                    scanner.next();
                }
                while (choice != 1 && choice != 2 && choice != 3) {
                    try {

                        loginMap();
                        System.out.println("请输入数字1或2和3!");
                        choice = scanner.nextInt();
                    } catch (Exception e) {
                        scanner.next();
                    }

                }
                if (choice == 3) {
                    System.out.println("谢谢使用");
                    client.close();
                    return false;
                }
                String result = register(choice);
                String data;

                data = "register" + ":" + result + ":" + choice;

                writer.write(data + "\n");
                writer.flush();
                String m1 = scanner1.nextLine();
                System.out.println(m1);
                if (m1.equals("ok")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    private static String register(int choice) {
        Scanner s = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("请输入用户名:");
            String name = s.nextLine();

            System.out.println("请输入密码:");
            String passWord = s.nextLine();

            return name + ":" + passWord;
        } else {
            System.out.println("请输入要注册的用户名:");
            String name = s.nextLine();
            System.out.println("请输入注册密码:");
            String passWord = s.nextLine();
            return name + ":" + passWord;
        }
    }

    private static void loginMap() {
        System.out.println("****************************************");
        System.out.println("**-----|---+    1.登录     +----|-----**");
        System.out.println("*******|---+    2.注册     +----|*******");
        System.out.println("**-----|---+    3.退出     +----|-----**");
        System.out.println("****************************************");
    }
}
