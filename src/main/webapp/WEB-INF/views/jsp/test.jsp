<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Test</title>
</head>
<body>
<table class="table table-hover">
<thead>
<tr>
    <th>Title</th>
    <th>Synopsis</th>
</tr>
</thead>
<tbody>

<c:forEach var="i" items="${movies}">
    <tr>
        <td>${i.title}</td>
        <td>${i.synopsis}</td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
