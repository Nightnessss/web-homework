<%--
  @author Nightessss 2020/5/14 11:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*,javax.sql.*" %>
<%
    DataSource dataSource =
            (DataSource)application.getAttribute("dataSource");
    Connection conn = dataSource.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rst = stmt.executeQuery("SELECT * FROM book");
%>
<html>
<head>
    <title>contextListenerTest</title>
</head>

<body>
<h4>书本表中信息</h4>
<table border="1">
    <tr>
        <td>书本编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>出版社</td>
        <td>价格</td>
    </tr>
    <% while (rst.next()){ %>
    <tr><td><%= rst.getInt(1) %></td>
        <td><%= rst.getString(2) %></td>
        <td><%= rst.getString(3) %></td>
        <td><%= rst.getString(4) %></td>
        <td><%= rst.getFloat(5) %></td></tr>
    <% } %>
</table>
</body>
</html>
