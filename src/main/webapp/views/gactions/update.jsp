<%@ page import = "ru.handbook.model.objects.Group" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>GROUP UPDATE PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
        >>
    <a href="/Int/groups">Назад</a> <br>
    <form method="POST">
        <input type="text" name="id" placeholder="ID">
        <input type="text" name="name" placeholder="Новое Имя">
        <input type="submit" name="search">
    </form>
</body>
</html>