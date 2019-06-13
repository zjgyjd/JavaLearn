<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
时间:<%=new Date().toString()%>
<%=
request.getParameter("name")
%>
<%=
request.getParameter("username")
%>
</body>
</html>
