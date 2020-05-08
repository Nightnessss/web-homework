<%--
  @author Nightessss 2020/5/8 15:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <%--方法一--%>
    <form action="hello.jsp" method="get">
        <p>用户名：<input name="username" id="username" type="text"></p>
        <input type="submit" value="确定" />
    </form>
    <%@include file="response.jsp"%>
    <%--方法二--%>
<%--    <%--%>
<%--        pageContext.setAttribute("username", "admin");--%>
<%--    %>--%>
<%--    <%@include file="response.jsp"%>--%>

</body>
</html>
