<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển Anh - Việt</title>
</head>
<body>
<h1>Từ điển Anh - Việt :</h1>
<form action="/translate" method="post">
    <input type="text" name="englishWord" placeholder="Nhập từ Tiếng Anh">
    <button type="submit">Dịch</button>
</form>
<p>${result}</p>
</body>
</html>
