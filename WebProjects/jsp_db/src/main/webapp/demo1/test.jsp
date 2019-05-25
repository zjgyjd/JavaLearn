<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is test Page<br>
<jsp:include page="include.jsp?myname=tom"/>
<%--include.jsp?username传参可以,但可以直接在页面上写?username不行
但如果在include页面里
会生成两个class文件
--%>
</body>
</html>
