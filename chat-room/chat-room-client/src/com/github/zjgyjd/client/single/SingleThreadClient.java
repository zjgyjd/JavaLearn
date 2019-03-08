package com.github.zjgyjd.client.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

//单线程聊天室客户端
public class SingleThreadClient {
    public static void main(String[] args) {
        try {
            //1.创建客户端,连接指定服务
            Socket socket = new Socket("127.0.0.1", 6666);
            System.out.println("客户端创建完毕:" + socket.getLocalSocketAddress());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            //2.发送接收数据
                            OutputStream outputStream = socket.getOutputStream();
                            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                            String message = "hello \n";

                            Scanner s = new Scanner(System.in);

                            message = s.nextLine();

                            System.out.println(message);

                            writer.write(message + "\n");
                            writer.flush();
                            if (message.equals("quit")) {
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            //2.2接收数据
                            InputStream inputStream = socket.getInputStream();
                            Scanner scanner = new Scanner(inputStream);
                            String messages = scanner.nextLine();
                            if (messages.equals("quit")) {
                                socket.close();
                                System.out.println("客户端关闭");
                                break;
                            }
                            System.out.println("接收服务器消息:" + messages);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
