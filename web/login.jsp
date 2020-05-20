<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<%--    Форма авторизации      --%>
<form method="post" action="login">
    <label for="loginField" style="margin:10px">Логин</label>
    <input id="loginField" name="login" style="margin:10px"> <br>
    <label for="passwordField" style="margin:10px">Пароль</label>
    <input id="passwordField" name="password" style="margin:10px"> <br>
    <button style="margin:10px" type="submit">Войти</button>
</form>
</body>
</html>
