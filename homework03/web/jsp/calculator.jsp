<%--
  @author Nightessss 2020/5/8 16:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fehead.beans.*" %>
<%
    String first = request.getParameter("first");
    String second = request.getParameter("second");
    String operator = request.getParameter("operator");
    SimpleCalculator simpleCalculator = null;
    if (operator!=null && first!=null && second!=null) {
        simpleCalculator = new SimpleCalculator(Double.valueOf(first), Double.valueOf(second), operator);
    }
%>
<html>
<head>
    <title>calculator</title>
</head>
<body>
    <form action="calculator.jsp">
        <input type="text" name="first" />
        <select name="operator">
            <option value=+>+</option>
            <option value=->-</option>
            <option value=*>*</option>
            <option value=/>/</option>
        </select>
        <input type="text" name="second" />
        <input type="submit" value="计算" />
    </form>
    <p>
        <%
            if (simpleCalculator != null) {
                out.print(simpleCalculator.calculator());
            }
        %>
    </p>
</body>
</html>
