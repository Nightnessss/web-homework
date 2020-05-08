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
    <title>main</title>
</head>
<body>
    <p>欢迎：
    <%
        out.println(session.getAttribute("username"));
    %>
    </p>
    <a id="logout" onclick="logout()">退出登录</a>
    <script>
        function logout() {
            window.location = ("exit.jsp")
        }
    </script>
</body>
</html>
