<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>CONTACT SEARCHED PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/contacts">к Контактам</a>
    <a href="/Int/contacts/search">к поиску</a>


    <% Contact contact = (Contact) request.getAttribute("contact");%>
    <h1><%=contact.getName()%></h1>
    <table width="400" height="400">
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Skype</th>
            <th>Mail</th>
        </thead>
        <tr>
            <td><%=contact.getId()%></td>
            <td><%=contact.getName()%></td>
            <td><%=contact.getPhone()%></td>
            <td><%=contact.getSkype()%></td>
            <td><%=contact.getMail()%></td>
        </tr>
    </table>
</body>
</html>