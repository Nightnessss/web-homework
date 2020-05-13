<%--
  @author Nightessss 2020/5/12 16:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<table border='1'>
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <%--        <td>品牌</td>--%>
        <td>价格</td>
        <%--        <td>库存量</td>--%>
        <td>加入购物车</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="status">
        <form method="post" action="/homework04/addToCart">
            <tr>
                <td><input name="id" value="${product.id}"/></td>
                <td>${product.name}</td>
                    <%--            <td>${product.brand}</td>--%>
                <td>${product.price}</td>
                    <%--            <td>${product.stock}</td>--%>
                <td><input type="submit" value="+" /></td>
            </tr>
        </form>
    </c:forEach>
</table>
<p><a href="homework04/showCart">前往购物车</a></p>
</body>
</html>