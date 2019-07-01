<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/7/1
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/t" method="post">
        <input type="hidden" name ="id" value="${items.id}">
        name:<input type="text" name="name" value="${items.name}"><br>
        price:<input type="text" name="price" value="${items.price}"><br>
        detail:<input type="text" name="detail" value="${items.detail}"><br>
        createTime:<input type="text" name="createTime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"><br>
        <input type="submit" value="Modify">
    </form>
</body>
</html>
