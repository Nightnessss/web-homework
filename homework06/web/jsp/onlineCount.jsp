<%--
  @author Nightessss 2020/5/14 14:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>onlineCount</title>
</head>
<body>
欢迎您，您的IP地址是${pageContext.request.remoteAddr}<br>
<p>自应用程序启动以来，该页面被访问了
    <span style="color:blue">${applicationScope.count}
    </span>次<br>
</body>
</html>
