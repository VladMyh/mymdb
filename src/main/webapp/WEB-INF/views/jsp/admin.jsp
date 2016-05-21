<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h1>Admin page</h1>

Dear <strong>${user}</strong>, Welcome to Admin Page.
<a href="<c:url value="/mymdb/logout" />">Logout</a>

</body>
</html>
