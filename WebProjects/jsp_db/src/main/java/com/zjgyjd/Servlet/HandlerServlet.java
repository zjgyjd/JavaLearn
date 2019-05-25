package com.zjgyjd.Servlet;

import com.zjgyjd.db.dbManager;
import com.zjgyjd.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("/Handler")
public class HandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        dbManager db = new dbManager();
        Connection conn = null;
        conn = db.getConn();
        String db_username = null;
        String db_password = null;
        String strSql = "select * from t_userinfo";
        ResultSet rs = db.queryFunction(strSql);
        try {
            while (rs.next()) {
                db_username = rs.getString("username");
                db_password = rs.getString("password");
                if (user.getUsername().equals(db_username) && user.getPassword().equals(db_password)) {
                    request.getSession().setAttribute("user_key", user);
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("fail.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {

        }
    }
}
