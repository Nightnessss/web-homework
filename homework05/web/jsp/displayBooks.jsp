<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="books" class="com.fehead.bean.BookDAO" scope="session" />
<html>
    <head>
        <title>diaplayBooks</title>
        <style>
            td
            {
                text-align:center;
            }
        </style>
    </head>
    <body>
    <table width="800" height="100" border="1" align="center">
        <tr>
            <th scope="col">bookid</th>
            <th scope="col">title</th>
            <th scope="col">author</th>
            <th scope="col">pulbisher</th>
            <th scope="col">price</th>
        </tr>
        <%
            try
            {
                ResultSet rs=books.result();
                while(rs.next()){%>
    <tr>
        <td><%=rs.getString(1)   %></td>
        <td><%=rs.getString(2)   %></td>
        <td><%=rs.getString(3)   %></td>
        <td><%=rs.getString(4)   %></td>
        <td><%=rs.getString(5)   %></td>
    </tr>

    <%  }
        rs.close();
    }catch(Exception e)
    {
        System.out.println(e.getStackTrace());
    } %>
</table>
</body>
</html>