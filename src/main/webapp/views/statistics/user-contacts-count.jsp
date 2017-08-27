<%@ page import = "java.util.List" %>
<%@ page import = "ru.handbook.model.objects.User" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>LOGIN PAGE</title>
</head>
<body>
    <a href="/Int">К авторизации</a> <br>
    <a href="/Int/statistics">К выбору статистики</a> <br>
    <table width="400" height="400">
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Count</th>
            </thead>
        <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User user : users) {%>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getCount()%></td>
            </tr>
           <%}%>
        </table>
    </body>
</body>
</html>