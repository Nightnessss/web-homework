<%--
  Created by IntelliJ IDEA.
  User: 19487
  Date: 2020/5/8
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="deal.jsp" method="post" id= "from">
        <div>
            <p>用户名：<input name="username" id="username" type="text"></p>
            <p>密码：<input name="password" id="password" type="password"></p>
        </div>
        <br>
        <div>
            <button>登录</button>
            <button>取消</button>
        </div>
    </form>
</body>
</html>
