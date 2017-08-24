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


    <% Group group = (Group) request.getAttribute("group");%>
    <h1><%=group.getName()%></h1>
    <table width="400" height="400">
        <thead>
            <th>ID</th>
            <th>Name</th>
        </thead>
    <% for (Contact contact : group.getInner()) {%>
        <tr>
            <td><%=contact.getId()%></td>
            <td><%=contact.getName()%></td>
            </tr>
        <%}%>
    </table>
</body>
</html>