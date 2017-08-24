<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>CONTACT UPDATE PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
        >>
    <a href="/Int/contacts">К контактам</a> <br>
        <table width="400" height="400">
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Skype</th>
                <th>Mail</th>
            </thead>
            <% Contact contact = (Contact) request.getAttribute("contact");%>
                <tr>
                    <td><%=contact.getId()%></td>
                    <td><%=contact.getName()%></td>
                    <td><%=contact.getPhone()%></td>
                    <td><%=contact.getSkype()%></td>
                    <td><%=contact.getMail()%></td>
                </tr>
            </table>
            <form>
                <input type="text" name="name" placeholder="Новое Имя">
                <input type="text" name="phone" placeholder="Новый Телефон">
                <input type="text" name="skype" placeholder="Новый Скайп">
                <input type="text" name="mail" placeholder="Новый Мэйл">
                <input type="submit" name="search">
            </form action="login" method="POST">
        </table>
</body>
</html>
