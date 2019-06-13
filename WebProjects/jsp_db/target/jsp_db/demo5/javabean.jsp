<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="user" class="com.zjgyjd.vo.User" scope="request"/>
<jsp:setProperty name="user" property="username" value="zjgyjd"/>
<jsp:forward page="accept.jsp"/>
</body>
</html>
