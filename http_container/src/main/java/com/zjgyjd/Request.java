package com.zjgyjd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String method;
    private String url;
    private String protocol;
    private Map<String, String> requestParams = new HashMap<>();
    private Map<String, String> handers = new HashMap<>();

    public static Request parse(InputStream is ) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)
        );
        Request request = new Request();
        parseRequestLine(reader, request);
        parseRequestHander(reader, request);
        return request;
    }

    private static void parseRequestHander(BufferedReader reader, Request request) throws Exception {
        String line;
        while ((line = reader.readLine()) != null && line.trim().length() != 0) {
            parseHanderLine(line, request);
        }
    }

    private static void parseHanderLine(String line, Request request) {
        String[] fragment = line.split(":");
        request.handers.put(fragment[0], fragment[1]);
    }

    private static void parseRequestLine(BufferedReader reader, Request request) throws Exception {
        String line = reader.readLine();
        System.out.println(line);
        if (line == null) {
            throw new Exception("读到了结尾");
        }
        String[] result = line.split(" ");
        if (result.length != 3) {
            throw new Exception("请求参数不对");
        }
        request.setMethod(result[0]);
        request.setUrl(result[1]);
        request.setProtocol(result[2]);
    }

    public Map<String, String> getHanders() {
        return handers;
    }

    public void setHanders(Map<String, String> handers) {
        this.handers = handers;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) throws Exception {
        this.method = method.toUpperCase();
        if (this.method.equals("POST") || this.method.equals("GET")) {
            return;
        }
        throw new Exception("不支持的异常");
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) throws UnsupportedEncodingException {
        String[] fragments = url.split("\\?");
        this.url = URLDecoder.decode(fragments[0], "UTF-8");
        System.out.println(this.url);
        if (fragments.length > 1) {
            parseParam(fragments[1]);
        }
    }

    private void parseParam(String queryString) throws UnsupportedEncodingException {
        Map<String, String> requestParams = getRequestParams();

        for (String kv : queryString.split("&")
        ) {
            String[] keyValue = kv.split("=");
            String key = keyValue[0];
            String value = "";
            if (keyValue.length > 1) {
                value = keyValue[1];
            }
            requestParams.put(key, value);
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) throws Exception {
        if (!protocol.toUpperCase().startsWith("HTTP")) {
            throw new Exception("错误的HTTP版本");
        }
        this.protocol = protocol;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }
}
