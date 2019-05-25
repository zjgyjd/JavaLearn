<%@ page import="com.zjgyjd.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Congratulation! you logName is:</h3>
<%
    User user = (User) request.getSession().getAttribute("user_key");
    out.println(user.getUsername());
%>
</body>
</html>
