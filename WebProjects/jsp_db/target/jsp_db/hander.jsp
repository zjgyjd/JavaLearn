<%@ page import="com.zjgyjd.vo.User" %>
<%@ page import="com.zjgyjd.db.dbManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
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
    while (rs.next()) {
        db_username = rs.getString("username");
        db_password = rs.getString("password");
        if(user.getUsername().equals(db_username)&&user.getPassword().equals(db_password)){
            request.getSession().setAttribute("user_key",user);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }
    }
%>
</body>
</html>
