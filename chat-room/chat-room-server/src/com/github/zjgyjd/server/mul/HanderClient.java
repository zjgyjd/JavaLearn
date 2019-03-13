package com.github.zjgyjd.server.mul;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class HanderClient implements Runnable {
    /*
    维护所有连接到服务端的客户端对象
    static final 则名字大写
     */
    private static final Map<String, Socket> ONLINE_CLIENT_MAP =
            new ConcurrentHashMap<>();

    private final Socket client;

    public HanderClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            InputStream clientInput = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);

            /*
            消息按行读取
            1.register:<username>  例如:register:张三                        注册
            2.groupChat:<message>   例如:groupChat:大家好                    群聊
            3.privateChat:<username>:<message> 例如:privateChat:张三:你好    私聊
            4.bye                                                           退出
             */
            while (true) {
                String date = scanner.nextLine();
                if (date.startsWith("register:")) {
                    //注册
                    String username = date.split(":")[1];
                    register(username);
                    continue;
                }
                if (date.equals("bye")) {
                    //退出
                    bye();
                    break;
                }
                if (date.startsWith("groupChat:")) {
                    String message = date.split(":")[1];
                    groupChat(message);
                    continue;
                }

                if (date.startsWith("privateChat:")) {
                    String[] segment = date.split(":");
                    String targetUser = segment[1];
                    String message = segment[2];
                    privateChat(targetUser, message);
                    continue;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getCurrertUserName() {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void bye() {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                sendMessage(target, "bye");
                ONLINE_CLIENT_MAP.remove(entry.getKey());
                break;
            }
        }
    }

    private void privateChat(String targetUser, String message) {
        Socket target = ONLINE_CLIENT_MAP.get(targetUser);
        if (target == null) {
            System.out.println("没有这个用户");
        } else {
            this.sendMessage(target, message);
        }

    }

    private void groupChat(String message) {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                continue;
            }
            this.sendMessage(target, message);
        }
    }

    private void sendMessage(Socket target, String message) {
        OutputStream clientOutput = null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void register(String username) {
        ONLINE_CLIENT_MAP.put(username, client);
        printOnlineClient();
        this.sendMessage(this.client, "恭喜:" + username + "注册成功");
    }

    private void printOnlineClient() {
        System.out.println("当前在线人数" + ONLINE_CLIENT_MAP.size());
        for (String username : ONLINE_CLIENT_MAP.keySet()) {
            System.out.println(username);
        }
    }
}
