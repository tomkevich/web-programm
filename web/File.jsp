<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправка файла</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Отправить</button>
</form>
</body>
</html>
