<%@ page import = "java.util.List" %>
<%@ page import = "ru.handbook.model.objects.User" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>AVERAGE COUNT OF CONTACTS PAGE</title>
</head>
<body>
    <a href="/Int">К авторизации</a> <br>
    <a href="/Int/statistics">К выбору статистики</a> <br>
    <%Float count = (Float) request.getAttribute("count");%>
    <h2><%=count%></h2>
</body>
</html>