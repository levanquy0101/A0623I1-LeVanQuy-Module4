<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Chương trình lưu giữ cấu hình hòm thư điện tử</title>
</head>
<body>
<f:form action="/handel" modelAttribute="emailModel" method="post">
    <lable>Languge:
        <f:select path="language">
            <f:option value="lang1">English</f:option>
            <f:option value="lang2">Vietnamese</f:option>
            <f:option value="lang3">Japanese</f:option>
            <f:option value="lang4">Chinese</f:option>
        </f:select>
    </lable><br>
    <lable>Page Size:
        <f:select path="pageSize">
            <f:option value="5">5</f:option>
            <f:option value="10">10</f:option>
            <f:option value="15">15</f:option>
            <f:option value="25">25</f:option>
            <f:option value="50">50</f:option>
            <f:option value="100">100</f:option>
        </f:select>
    </lable><br>
    <lable>Spams filler: <f:checkbox path="spams" /></lable><br>
    <lable>Signaturn: <f:textarea path="signature" /></lable><br>
    <input type="submit">
    <input type="reset">
</f:form>
<p>${message}</p>
</body>
</html>
