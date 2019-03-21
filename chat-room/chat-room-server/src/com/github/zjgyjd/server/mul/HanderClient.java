package com.github.zjgyjd.server.mul;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
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

    private static final File USERDATA_UP = new File("D:\\JavaLearn\\chat-room\\chat-room-server\\src\\com" +
            "\\github\\zjgyjd\\server\\mul\\userdata.txt");

    private static final Map<String, String> USERDATA_DOWN =
            new ConcurrentHashMap<>();


    private final Socket client;

    private int friends = 0;

    static {
        try (FileReader reader = new FileReader(USERDATA_UP);
             BufferedReader in = new BufferedReader(reader)
        ) {
            String lineTXT = "";
            while ((lineTXT = in.readLine()) != null) {
                String[] temp = lineTXT.split(":");
                USERDATA_DOWN.put(temp[0], temp[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HanderClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            InputStream clientInput = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);


            while (true) {
                String date = scanner.nextLine();
                if (date.startsWith("register:")) {
                    //检测是注册还是登陆
                    String[] strings = date.split(":");
                    if (strings[3].equals("1")) {
                        //登陆
                        login(strings);
                    } else {
                        //注册
                        register(strings);
                    }
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

    private void register(String[] strings) {
        if (USERDATA_DOWN.containsKey(strings[1])) {
            sendMessage(this.client, "用户名已存在请重新注册", false);
        } else {
            USERDATA_DOWN.put(strings[1], strings[2]);
            updateFile(strings);
            sendMessage(this.client, "创建成功!请选择登陆", false);
        }
    }

    private void updateFile(String[] strings) {
        try (FileWriter writer = new FileWriter(USERDATA_UP)) {
            writer.write(strings[1] + ":" + strings[2] + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(String[] strings) {
        for (Map.Entry<String, String> entry : USERDATA_DOWN.entrySet()) {
            String target = entry.getKey();
            if (target.equals(strings[1])) {
                if (strings[2].equals(entry.getValue())) {
                    sendMessage(this.client, "ok", false);
                    register(target);
                    return;
                } else {

                    sendMessage(this.client, "密码错误,请重新输入密码", false);
                    return;
                }
            }
        }

        sendMessage(this.client, "账号不存在!,请注册", false);
    }

    private void register(String username) {
        ONLINE_CLIENT_MAP.put(username, client);
        printOnlineClient();
        this.sendMessage(this.client, "欢迎:" + username + "登陆成功", false);
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
                System.out.println(entry.getKey() + "下线");
                sendMessage(target, "bye", false);
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
            this.sendMessage(target, message, true);
        }

    }

    private void groupChat(String message) {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                continue;
            }
            this.sendMessage(target, message, true);
        }
    }

    private void sendMessage(Socket target, String message, boolean s) {
        OutputStream clientOutput = null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            if (s) {
                writer.write(getCurrertUserName() + "<说>:" + message + "\n");
            } else {
                writer.write(message + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void printOnlineClient() {
        System.out.println("当前在线人数" + ONLINE_CLIENT_MAP.size());
        for (String username : ONLINE_CLIENT_MAP.keySet()) {
            System.out.println(username);
        }
    }
}
