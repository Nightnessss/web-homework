<%--
  Created by IntelliJ IDEA.
  User: 19487
  Date: 2020/5/8
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>staytime</title>
</head>
<body>
    <p>
        <label for="clock">现在的时间是：</label>
        <span id="clock"></span>
    </p>
    <p>
        <label for="counter">你已在本页面停留</label>
        <span id="counter"></span>秒
    </p>
    <script type="text/javascript">
        var clock_int = self.setInterval("clock()", 1000);
        var c = 0;
        document.getElementById("counter").innerText = c;
        var counter_int = self.setInterval("counter()", 10000);
        function clock()
        {
            var d = new Date();
            var t = d.toLocaleTimeString();
            document.getElementById("clock").innerText = t;
        }
        function counter() {
            c = c + 10;
            document.getElementById("counter").innerText = c;
            // console.log(c);
        }
    </script>
</body>
</html>
