<%@ page import = "ru.handbook.model.objects.Group" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>CREATED PAGE</title>
</head>
<body>
    <a href="/Int/main">На главную</a>
    >>
    <a href="/Int/groups">к группам</a>
    Hello searched
    <table width="400" height="400">
    <% Group group = (Group) request.getAttribute("group");%>
        <tr>
            <td>Группа</td>
            <td><%=group.getName()%></td>
            <td>создана</td>
        </tr>
    </table>
</body>
</html>