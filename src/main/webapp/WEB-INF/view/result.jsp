<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/result.css">
    <title>Result</title>
</head>
<body>

<div>
    <a href="<c:url value="/"/>">Back to search menu</a>
</div>

<c:if test="${!empty questions}">
    <table class="table-questions">
        <tr>
            <th>Creation Date</th>
            <th>Title</th>
            <th>Owner</th>
        </tr>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.creationDate}</td>
                <td><a href="${question.link}" target="_blank"/>${question.title}</td>
                <td>${question.owner}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>