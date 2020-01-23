<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2020/1/22
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>传统文件上传</h3><br>
<form action="/user/fileUpload_1" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload" /><br>
    <input type="submit" value="上传"/>
</form>
<h3>SpringMVC文件上传</h3><br>
<form action="/user/fileUpload_2" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload" /><br>
    <input type="submit" value="上传"/>
</form>
<h3>SpringMVC跨服务器文件上传</h3><br>
<form action="/user/fileUpload_3" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload" /><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
