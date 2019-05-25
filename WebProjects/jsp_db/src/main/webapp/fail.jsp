<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/25
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fail</title>
</head>
<body>
<form action="/Handler" method="post">
    username<input type="text" name = "username"><span name ="message"><font color="red">用户名或密码错误!!</font></span><br>
    password<input type="password" name = "password"><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

</body>
</html>
