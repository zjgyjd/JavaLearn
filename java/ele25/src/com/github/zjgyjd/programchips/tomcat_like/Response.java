package com.github.zjgyjd.programchips.tomcat_like;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private OutputStream os;
    private Status status = Status.OK;
    private Map<String, String> headers = new HashMap<>();
    private final byte[] buf = new byte[8192];
    private int offset = 0;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Response(OutputStream os) {
        this.os = os;
    }

    public static Response build(OutputStream os) {
        return new Response(os);
    }

    public void setContentType(String s) {
        setHeader("Content-Type", s + ";charset=UTF-8");
    }

    private void setHeader(String s, String s1) {
        headers.put(s, s1);
    }

    public void print(String line) {
        byte[] l = line.getBytes();
        int i;
        for (i = 0; i < line.length(); i++) {
            buf[offset + i] = l[i];
        }
        offset = offset + i;
    }

    public void println(String line) {
        byte[] l = line.getBytes();
        int i;
        for (i = 0; i < line.length(); i++) {
            buf[offset + i] = l[i];

        }
        buf[offset + i] = '\n';
        offset = offset + i + 1;
    }

    private void printf(String format, String... param) {

    }

    public void flush() throws IOException {
        sendLine(os);
        sendHead(os);
        sendBody(os);
    }

    private void sendBody(OutputStream os) throws IOException {
        String s = new String(buf) + "\r\n";
        os.write(s.getBytes(), 0, offset);
    }

    private void sendHead(OutputStream os) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\r\n");
        }
        os.write(sb.toString().getBytes());
        os.write('\r');
        os.write('\n');
    }

    private void sendLine(OutputStream os) throws IOException {
        os.write(("HTTP/1.0 " + status.getCode() + " " + status.getReason() + "\r\n").getBytes(StandardCharsets.UTF_8));
    }

    public void write(byte[] buffer, int offSet, int len) {
        System.arraycopy(buffer, offSet, buf, offset, len);
        offset += len;
    }
}
