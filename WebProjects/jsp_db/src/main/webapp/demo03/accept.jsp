<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    this is accept page;<br>
    <%=
        request.getParameter("name")
    %>
</body>
</html>
