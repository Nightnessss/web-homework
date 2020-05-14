<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean  id="book" class="com.fehead.bean.BookBean" scope="session"/>
<jsp:setProperty name="book" property="*"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<body>
书号：<jsp:getProperty name="book" property="bookId"/><br><br>
书名：<jsp:getProperty name="book" property="title"/><br><br>
作者：<jsp:getProperty name="book" property="author"/><br><br>
出版社：<jsp:getProperty name="book" property="publisher"/><br><br>
价格：<jsp:getProperty name="book" property="price"/><br><br>
</body></html>