<%--
  @author Nightessss 2020/5/8 16:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <form action="main.jsp" method="get">
        <p>用户名：<input name="username" id="username" type="text"></p>
        <input type="submit" value="确定" />
    </form>
    <jsp:include page="subpage.jsp"/>
</body>
</html>
