<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>CREATED PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/contacts">к Контактам</a>
    Hello searched
    <table width="400" height="400">
    <% Contact contact = (Contact) request.getAttribute("contact");%>
        <tr>
            <td>Контакт</td>
            <td><%=contact.getName()%></td>
            <td>создан</td>
        </tr>
    </table>
</body>
</html>