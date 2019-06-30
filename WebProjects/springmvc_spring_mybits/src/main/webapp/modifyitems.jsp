<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/6/30
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify</title>
</head>
<body>
<form action="xxxx" method="post">
    <table width="100%" border="1" align="center">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Detail</td>
            <td>CreateTime</td>
        </tr>
                <tr>
                    <td><%= request.getParameter("name")%></td>
                    <td><%= request.getParameter("price")%></td>
                    <td><%= request.getParameter("detail")%></td>
                    <td>
                        <%=
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                    .format(new Date(request.getParameter("createtime")))
                        %>
                    </td>
                </tr>
    </table>
</form>
</body>
</html>
