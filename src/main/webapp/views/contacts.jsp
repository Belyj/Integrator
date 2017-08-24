<%@ page import = "java.util.List" %>
<%@ page import = "ru.handbook.model.objects.Contact" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>CONTACTS PAGE</title>
</head>
<body>
    <a href="/Int/contacts/search">Найти</a>
    <a href="/Int/contacts/create">Создать</a>
    <a href="/Int/contacts/delete">Удалить</a>
    <a href="/Int/contacts/update">Обновить</a>
<table width="400" height="400">
    <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Skype</th>
        <th>Mail</th>
    </thead>
<%
List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
for (Contact contact : contacts) {%>
    <tr>
        <td><%=contact.getId()%></td>
        <td><%=contact.getName()%></td>
        <td><%=contact.getPhone()%></td>
        <td><%=contact.getSkype()%></td>
        <td><%=contact.getMail()%></td>
    </tr>
<%}%>
</table>
Hello contacts
</body>
</html>