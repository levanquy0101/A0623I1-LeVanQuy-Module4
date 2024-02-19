<%--
  Created by IntelliJ IDEA.
  User: vannn
  Date: 19-Feb-24
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Chuyển đổi tiền tệ: </h3>
<form action="/convert" method="post">
    <div>
        USD: <input name="usd">
    </div>
    <div>
        Rate: <input name="rate" value="24000">
    </div>
    <button>Submit</button>
</form>
</body>
</html>
