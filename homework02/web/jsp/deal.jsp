<%--
  Created by IntelliJ IDEA.
  User: 19487
  Date: 2020/5/8
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equals("admin") && password.equals("123456")) {
        session.setAttribute("username", username);
        response.sendRedirect("main.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }

%>
<html>
<head>
    <title>deal</title>
</head>
<body>

</body>
</html>
