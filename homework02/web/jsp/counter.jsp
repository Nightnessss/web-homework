<%--
  Created by IntelliJ IDEA.
  User: 19487
  Date: 2020/5/8
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>counter</title>
</head>
<body>
    <%
        int count = 0;
        synchronized (application) {
            if (application.getAttribute("count") == null) {
                count = 1;
            } else {
                count = (int) application.getAttribute("count");
                count++;
            }
            application.setAttribute("count", count);
            out.println("访问量：" + count);
        }
    %>
</body>
</html>
