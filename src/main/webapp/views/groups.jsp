<%@ page import = "java.util.List" %>
<%@ page import = "ru.handbook.model.objects.Group" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>GROUPS PAGE</title>
</head>
<body>
    <a href="/Int/groups/search">Найти</a>
    <a href="/Int/groups/create">Создать</a>
    <a href="/Int/groups/delete">Удалить</a>
    <a href="/Int/groups/update">Обновить</a>
<table width="400" height="400">
    <thead>
        <th>ID</th>
        <th>Name</th>
    </thead>
<%
List<Group> groups = (List<Group>) request.getAttribute("groups");
for (Group group : groups) {%>
    <tr>
        <td><%=group.getId()%></td>
        <td><%=group.getName()%></td>
    </tr>
<%}%>
</table>
Hello contacts
</body>
</html>