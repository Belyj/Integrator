<%@ page import = "ru.handbook.model.objects.Contact" %>
<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>ADD IN GROUP PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/contacts">Назад</a> <br>
    <form method="POST">
        <input type="text" name="contactid" placeholder="Id">
        <input type="text" name="groupid" placeholder="Id">
        <input type="submit" name="search">
    </form>
</body>
</html>