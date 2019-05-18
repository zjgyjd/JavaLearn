package com.zjgyjd.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/N")
public class NotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer =  resp.getWriter();

        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("<font color='red' size='50px'>")
                .append("对不起，登录失败，<a href='form'>点击回登录页面</a></br>")
                .append("</font>")
                .append("</body>")
                .append("</html>");

    }
}
