<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/5/21
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%-- 声明方法和声明方法的Java代码--%>
    <%!
        int i ;
        int number ;
        int result ;
        public int sayHello(){
            number = 100;
            result = i + number;
            return result;
        }
    %>




     <%-- 表达式可以进行直接计算--%>
    result is <%=sayHello()%>
</body>
</html>
