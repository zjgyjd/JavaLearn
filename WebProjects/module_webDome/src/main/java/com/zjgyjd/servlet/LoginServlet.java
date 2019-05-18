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

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户请求的参数
        String username= req.getParameter("name");
        String password =req.getParameter("password");
//        req.getSession().setAttribute("key_username",username);
//        req.getSession().setAttribute("key_password",password);
        UserInfo userInfo = new UserInfo();//对象化
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        List<UserInfo> list = new QueryService().queryDb(userInfo);
 //       req.getSession().setAttribute("Handle",userInfo);//放前面一个
        //返回结果
        if(list !=null){
            req.getSession().setAttribute("user_Info",list);
            req.getRequestDispatcher("H").forward(req,resp);
        }else{
            req.getRequestDispatcher("N").forward(req,resp);
        }
    }
}
