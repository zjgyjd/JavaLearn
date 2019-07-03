<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2019/6/27
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function checkall() {
        var selItem = document.getElementsByName("selItem");
        var chooseAll = document.getElementsByName("chooseAll")[0].checked;
        for (var i = 0; i < selItem.length; i++) {
            selItem[i].checked = chooseAll;
        }
    }

    function operateData(param) {
        var selItem = document.getElementsByName("selItem");
        var itemsForm = document.getElementById("itemsForm")
        var index = 0;  //对操作数量进行定义
        for (var i = 0; i < selItem.length; i++) {
            //得到一个具体的checkbox对象
            if (selItem[i].checked) {
                index++;
            }
        }
        if (index == 0 && param == 'add') {
            //增加
            itemsForm.action = '/addTable.jsp';
            itemsForm.submit();//提交
        } else if (index != 0 && param == 'add') {
            alert(param+'不需要选中！');
        }else if(index>=1 && param=='delete'){
            //删除
            itemsForm.action='/deleteIds';
            itemsForm.submit();
        }else {
            alert(param+'不能选中多个或'+param+'不能没有选中！');
        }
    }
</script>
<body>
<form action="xxxx" id="itemsForm" method="post">
    <div align="right">
        <input type="button" value="Delete" onclick="operateData('delete')" class="btn">
        <input type="button" value="Add" onclick="operateData('add')" class="btn">
    </div>
    <table width="100%" border="1" align="center">
        <tr>
            <td>
                <input type="checkbox" name="chooseAll" onclick="checkall()"/>
            </td>
            <td>Name</td>
            <td>Price</td>
            <td>Detail</td>
            <td>CreateTime</td>
            <td>Operator</td>
        </tr>
        <c:forEach items="${itemslistKey}" var="items1">
            <tr>
                <td>
                    <input type="checkbox" name="selItem" value="${items1.id }"/>
                </td>
                <td>${items1.name}</td>
                <td>${items1.price}</td>
                <td>${items1.detail}</td>
                <td>
                    <fmt:formatDate value="${items1.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td align="center">
                    <a href="/u?id=${items1.id}">Modify</a>
                    | <a href="/d?id=${items1.id}">Del</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
