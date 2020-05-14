<%--
  @author Nightessss 2020/5/14 16:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="../CheckUserServlet" method="post">
        <div>用户名：<input type="text" name="username"></div>
        <div>口&#12288;令：<input type="password" name="password"></div>
        <div><label for="isAutoLogin">自动登录</label><input type="checkbox" name="autoLogin" id="isAutoLogin"></div>
        <input type="submit" value="登录">
    </form>
</body>
</html>
