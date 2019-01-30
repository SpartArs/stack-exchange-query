<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/query.css">
    <title>Query</title>
</head>
<body>

<div class="query">
    <spring:form method="post" modelAttribute="stackExchangeQuery" action="result">
        Query: <spring:input path="intitle" cssClass="search-input" required="required"/>

        <form:select path="order" cssClass="search-select" itemLabel="Order">
            <form:option value="asc">Asc</form:option>
            <form:option value="desc" selected="selected">Desc</form:option>
        </form:select>

        <form:select path="sort" cssClass="search-select" itemLabel="Sort">
            <form:option value="activity">Activity</form:option>
            <form:option value="votes">Votes</form:option>
            <form:option selected="selected" value="Creation">Creation</form:option>
            <form:option value="relevance">Relevance</form:option>
        </form:select>

        <spring:button id="search-button">Search</spring:button>
    </spring:form>
</div>
</body>
</html>