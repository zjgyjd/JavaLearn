<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2020/1/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: red">查询了所有账户信息</h3>
<c:forEach items="${list}" var="account" >
    ${account.name}
    ${account.money}<br>
</c:forEach>
</body>
</html>
