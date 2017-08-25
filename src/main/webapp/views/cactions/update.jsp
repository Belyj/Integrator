<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>CONTACT UPDATE PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
        >>
    <a href="/Int/contacts">Назад</a> <br>
        <form method="POST">
            <input type="text" name="id" placeholder="ID">
            <input type="text" name="name" placeholder="Новое Имя">
            <input type="text" name="phone" placeholder="Новый Телефон">
            <input type="text" name="skype" placeholder="Новый Скайп">
            <input type="text" name="mail" placeholder="Новый Мэйл">
            <input type="submit" name="search">
        </form>
</body>
</html>