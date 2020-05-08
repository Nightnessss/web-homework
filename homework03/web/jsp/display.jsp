<%--
  @author Nightessss 2020/5/8 16:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fehead.beans.UserBean" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    UserBean userBean = new UserBean(username, password, email);
%>
<html>
<head>
    <title>display</title>
</head>
<body>
    UserName: <%out.print(userBean.getName());%><br>
    Password: <%out.print(userBean.getPassword());%><br>
    Email:    <%out.print(userBean.getEmail());%><br>
</body>
</html>
