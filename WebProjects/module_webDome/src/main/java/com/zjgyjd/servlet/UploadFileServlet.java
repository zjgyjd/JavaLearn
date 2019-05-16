package com.zjgyjd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
        (location = "D:\\JavaLearn\\WebProjects\\out\\artifacts\\module_webDome_war_exploded\\upload",
                maxFileSize = 1048576, maxRequestSize = 5242880, fileSizeThreshold = 5242880)
public class UploadFileServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>上传的案例</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>上传图片</h1>\n" +
                "<form method=\"post\" action='/upload' enctype=\"multipart/form-data\">\n" +
                "<input type=\"file\" name=\"filename\">\n" +
                "<input type=\"submit\" value=\"上传文件\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("filename");
        if (part == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("<html>")
                    .append("<head>有问题!!")
                    .append("</head>")
                    .append("</html>");
        } else {
            InputStream is = part.getInputStream();

            String appUploadPath = request.getServletContext().getRealPath("/upload");
            System.out.println(appUploadPath);
            File file = new File(appUploadPath, part.getSubmittedFileName());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = is.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            out.close();
            is.close();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("<html>")
                    .append("<head>")
                    .append("<meta charset='UTF-8'>")
                    .append("<title>File</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<a href='")
                    .append("/upload/").append(part.getSubmittedFileName())
                    .append("'>")
                    .append("上传的文件")
                    .append("</a>")
                    .append("</body>")
                    .append("</html>");
        }
    }
}
