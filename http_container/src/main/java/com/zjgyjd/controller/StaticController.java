package com.zjgyjd.controller;

import com.zjgyjd.Request;
import com.zjgyjd.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class StaticController extends Controller{
    public static final String HOME = System.getenv("JM_HOME");
    public static final HashMap<String , String> CTYPE = new HashMap<String, String>(){
        {
            put("html","text/html");
            put("css","text/css");
            put("js","application/javascript");
            put("ico","image/x-icon");
            put("jpg","application/x-jpg");
        }
    };
    public void doGet(Request request , Response response) throws Exception {
        //根据url找到文件路径
        String filename = getFilename(request.getUrl());
        //根据文件名的后缀决定content-type --->getSuffix
        String s = getSuffix(filename);
        response.setContentType(CTYPE.get(s));
        System.out.println(s);
        //把文件的所有内容作为response的body发送
        InputStream is = new FileInputStream(filename);
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer))!= -1){
            response.write(buffer , 0 , len);
        }
    }

    private String getSuffix(String filename) throws Exception {
        int index = filename.lastIndexOf(".");
        if(index == -1){
            throw new Exception("类型错误");
        }

        return filename.substring(index + 1);
    }

    private String getFilename(String url) {
        if(url.equals("/")){
            url = "/index.html";
        }
        return HOME + File.separator + "webapp"+ url.replaceAll("/","\\\\");
    }
}
