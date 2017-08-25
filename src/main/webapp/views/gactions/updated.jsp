<%@ page import = "ru.handbook.model.objects.Group" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>GROUP UPDATED PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/groups">к Группам</a>
    <table width="400" height="400">
        <thead>
            <th>ID</th>
            <th>Name</th>
        </thead>
    <% Group group = (Group) request.getAttribute("group");%>
        <tr>
            <td><%=group.getId()%></td>
            <td><%=group.getName()%></td>
        </tr>
    </table>
</body>
</html>