<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать!</title>
</head>
<body>
<h2>Вы успешно авторизовались, ${sessionScope ['user']} </h2>
<br>
<% String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            userName = cookie.getValue();
        }
    }
%>
<h3>Cookie Name: <%=userName%>
</h3>
<form action="imagePage" method="get">
    <button style="margin: 10px">Изображение</button>
</form>
<form action="upload" method="get">
    <button style="margin: 10px">Отправить файл</button>
</form>
<form action="hello" method="post">
    <button style="margin: 10px">Выход</button>
</form>

</body>
</html>
