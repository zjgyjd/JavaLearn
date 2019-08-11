package com.github.zjgyjd.programchips.tomcat_like;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
//        String requestMessage = "";
//
//        InputStream is = new ByteArrayInputStream(requestMessage.getBytes());
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        Request request = Request.parse(is);
//        System.out.println(request.getMethod());
//        System.out.println(request.getUrl());
//        System.out.println(request.getRequestParams());
//        System.out.println(request.getProtocol());
//        System.out.println(request.getHanders());
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Request request = Request.parse(socket.getInputStream());
                Response response = Response.build(socket.getOutputStream());
                StaticController staticController = new StaticController();
                staticController.doGet(request, response);
                response.flush();
                socket.close();
                System.out.println("lalala");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }

    }
}
