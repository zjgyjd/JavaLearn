package com.zjgyjd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<form method='Post' action='/Log'>")//对应的doGet或doPost
                .append("请输出姓名：")
                .append("<input name='name' type='text' value=''/>")
                .append("<br/>")
                .append("请输入密码:")
                .append("<input name='password' type='password' value=''/>")
                .append("<input type='submit' value='提交'>")
                .append("</form>")
                .append("</body>")
                .append("</html>");
    }
}
