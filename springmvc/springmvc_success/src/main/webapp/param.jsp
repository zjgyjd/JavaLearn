<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2020/1/13
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>
<a href="param/testParam?username=hehe">请求参数绑定</a><br>
<h3>将数据封装到Account</h3>
<form action="param/save" method="post">
    姓名:<input type="text" name="username"/><br>
    密码:<input type="text" name="password"/><br>
    金额:<input type="text" name="money"/><br>
    用户姓名:<input type="text" name="user.uname"/><br>
    用户年龄:<input type="text" name="user.age"/><br>
    <input type="submit" value="提交"/><br>
</form>
<br>
<h3>在Account中加入集合类进行绑定</h3>
<form action="param/save" method="post">
    姓名:<input type="text" name="username"/><br>
    密码:<input type="text" name="password"/><br>
    金额:<input type="text" name="money"/><br>
    用户姓名:<input type="text" name="user.uname"/><br>
    用户年龄:<input type="text" name="user.age"/><br>

    用户姓名:<input type="text" name="list[0].uname"/><br>
    用户年龄:<input type="text" name="list[0].age"/><br>

    用户姓名:<input type="text" name="map['one'].uname"/><br>
    用户年龄:<input type="text" name="map['one'].age"/><br>
    <input type="submit" value="提交"/><br>
</form>

<br>
<h3>设置自定义类型转换器</h3>

<form action="param/saveUser" method="post">
    用户姓名:<input type="text" name="uname"/><br>
    用户年龄:<input type="text" name="age"/><br>
    用户生日:<input type="text" name="date"/><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</html>
