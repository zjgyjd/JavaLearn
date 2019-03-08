package com.github.zjgyjd.server.single;
//单线程聊天室服务端

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) {
        try {
            //1.创建服务端的ServerSocket,监听6666端口
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器启动: "+serverSocket.getLocalSocketAddress());

            //2.接收客户端连接
            while(true){

            final Socket socket = serverSocket.accept();
                System.out.println("接收到客户端连接: "+socket.getRemoteSocketAddress());

            new Thread(new Runnable() {
                @Override
                public void run() {
                  try{
                      while(true) {
                          //3.接收和发送数据
                          InputStream inputStream = socket.getInputStream();
                          Scanner scanner = new Scanner(inputStream);
                          String message = scanner.nextLine();
                          System.out.println("收到客户端"+socket.getPort()+"消息: " + message);
                          if(message.equals("quit")){
                              OutputStream outputStream = socket.getOutputStream();
                              OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                              writer.write("quit\n");
                              writer.flush();
                              break;
                          }
                      }

                  }catch (IOException e){
                      e.printStackTrace();
                  }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3.2发送数据
                        OutputStream outputStream = socket.getOutputStream();
                        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                        writer.write("你好,客户端,我很好. \n");
                        writer.flush();

                        //4. 关闭
                        //socket.close();
                        //System.out.println("服务器关闭");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
