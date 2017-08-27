<%@ page import = "ru.handbook.model.objects.Contact" %>
<%@ page import = "java.util.List" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>IIINDEX</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/contacts">Назад</a> <br>
    <form method="POST">
        <input type="text" name="name" placeholder="Имя">
        <input type="submit" name="search">
    </form>
</body>
</html>