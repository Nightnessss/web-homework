<%--
  @author Nightessss 2020/5/12 16:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showProduct</title>
</head>
<body>
    <table border='1'>
        <tr>
            <td>商品号</td>
            <td>商品名</td>
            <td>品牌</td>
            <td>价格</td>
            <td>库存量</td>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.brand}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
        </tr>
    </table>
    <a href="http://localhost:8080/homework04/showIndex">返回首页</a>
</body>
</html>
