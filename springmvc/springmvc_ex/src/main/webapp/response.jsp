<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2020/1/20
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery.min.js"></script>
    <script>
        //页面加载,绑定单击事件
        $(function(){
            $("#btn").click(function () {
                // alert("hello btn")
                //发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"sandy","password":"123","age":"20"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data是服务器端响应的json的数据,进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            })
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br>
    <a href="user/testVoid">testVoid</a>

    <br>
    <a href="user/testModelAndView">testModelAndView</a>

    <br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br>
    <button id="btn">发送ajax请求</button>

</body>
</html>
