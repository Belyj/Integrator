<%@ page import = "ru.handbook.model.objects.Group" %>
<%@ page import = "java.util.List" %>
<%@ page import = "ru.handbook.model.objects.Contact" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>SEARCHED GROUP PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/groups">к группам</a>
    >>
    <a href="/Int/groups/search">к поиску</a>


    <table width="400" height="400">
        <thead>
            <th>ID</th>
            <th>Name</th>
        </thead>

    <% List<Group> groups = (List<Group>) request.getAttribute("groups");
        for (Group group : groups) {
            for (Contact contact : group.getInner()) {%>
        <tr>
            <td><%=contact.getId()%></td>
            <td><%=contact.getName()%></td>
            </tr>
        <%}%>
    <%}%>
    </table>
</body>
</html>