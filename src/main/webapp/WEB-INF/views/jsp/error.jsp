<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<ul>
    <p>Oops ¯\_('o')_/¯</p>
    Dear <strong>${user}</strong>, You are not authorized to access this page
    <a href="<c:url value="/logout" />">Logout</a>
</ul>
</body>
</html>
