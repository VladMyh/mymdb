<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<h1>Error</h1>
<ul>
    <p>Oops ¯\_('o')_/¯</p>
    Dear <strong>${user}</strong>, You are not authorized to access this page
    <a href="${contextPath}/mymdb/logout"/>Logout</a>
</ul>
</body>
</html>
