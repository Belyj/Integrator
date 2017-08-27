<%@ page import = "ru.handbook.model.objects.Contact" %>
<%@ page import = "java.util.List" %>

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

    <table width="400" height="400">
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Skype</th>
            <th>Mail</th>
        </thead>
<% List<Contact> contacts = (List<Contact>) request.getAttribute("contacts"); %>
    <% for (Contact contact : contacts) {%>
        <tr>
            <td><%=contact.getId()%></td>
            <td><%=contact.getName()%></td>
            <td><%=contact.getPhone()%></td>
            <td><%=contact.getSkype()%></td>
            <td><%=contact.getMail()%></td>
        </tr>
       <%}%>
    </table>
</body>
</html>