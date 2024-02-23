<%--
  Created by IntelliJ IDEA.
  User: vannn
  Date: 21-Feb-24
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng hiển thị gia vị với Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" style="width: 25%;" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">
    <lable for="">Lettuce</lable>
    <input type="checkbox" name="condiment" value="Tomato">
    <lable for="">Tomato</lable>
    <input type="checkbox" name="condiment" value="Mustard">
    <lable for="">Mustard</lable>
    <input type="checkbox" name="condiment" value="Sprouts">
    <lable for="">Sprouts</lable>
    <hr>
    <input type="submit" value="Save">
</form>
<p>${result}</p>
</body>
</html>
