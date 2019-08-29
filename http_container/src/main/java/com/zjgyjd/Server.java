package com.zjgyjd;

import com.zjgyjd.controller.Controller;
import com.zjgyjd.controller.StaticController;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final String HOME = System.getenv("JM_HOME");
    public static final WebApp webApp = WebApp.webApp();
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);//监听8080端口
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Request request = Request.parse(socket.getInputStream());
                Response response = Response.build(socket.getOutputStream());
                Controller controller = null;
                try {
                    String fileName = getFilename(request.getUrl());
                    File file = new File(fileName);
                        //在这个地方进行一个判断看看是动态文件还是静态文件
                    if (file.exists()) {
                        controller = new StaticController();
                       // controller.doGet(request, response);
                    } else {
                        //此时为动态文件
                         controller = webApp.findController(request);
                    }
                    if(controller == null){
                        response.setStatus(Status.NOT_FOUND);
                        response.println(Status.NOT_FOUND.getReason());
                        continue;
                    }
                    switch (request.getMethod()){
                        case "POST":{
                            controller.doPost(request,response);
                            break;
                        }
                        case "GET":{
                            controller.doGet(request , response);
                            break;
                        }
                        default:{
                            response.setStatus(Status.NOT_ALLOWED);
                            response.println(Status.NOT_ALLOWED.getReason());
                        }
                    }

                } finally {

                    response.flush();
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
    private String getFilename(String url) {
        if(url.equals("/")){
            url = "/index.html";
        }
        return HOME + File.separator + "webapp"+ url.replaceAll("/","\\\\");
    }

    public static void main(String[] args) {
        try {
            new Server().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
