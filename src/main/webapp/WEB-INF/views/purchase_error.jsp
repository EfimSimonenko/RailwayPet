<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Passengers</title>
</head>

<body>
<div>
    <jsp:include page="header.jsp"/>
</div>

<div>
<spring:message text="${message}"/>
</div>
<div>
    <a href="/search" style="color: #2527ae; text-decoration: none;">Back to ticket search page</a>
</div>

</body>