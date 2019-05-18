package com.zjgyjd.servlet;

import com.zjgyjd.service.QueryService;
import com.zjgyjd.user.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HandleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //        UserInfo userInfo = req.getSession().getAttribute();
//        String name =(String) req.getSession().getAttribute("key_username");
//        String password =(String) req.getSession().getAttribute("key_password");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer =  resp.getWriter();

        List<UserInfo> userInfoList = (List<UserInfo>) req.getSession().getAttribute("user_Info");

        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<body>")
                .append("<font color='green' size='20px'>")
                .append("登录成功，你的用户名和密码如下：</br>")
                .append("</font>")
                .append("<table border='1' width='200' height=\"50\">");
        for(UserInfo userInfo : userInfoList) {
            writer.append("<tr>")
                    .append("<td>username</td>")
                    .append("<td>'" + userInfo.getUsername() + "'</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>password</td>")
                    .append("<td>'" + userInfo.getPassword() + "'</td>")
                    .append("</tr>");
        }
        writer.append("</table>")
                .append("</body>")
                .append("</html>");
    }
}
