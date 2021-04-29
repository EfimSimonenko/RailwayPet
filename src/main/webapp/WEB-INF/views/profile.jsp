<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Profile</h1>
<form method="GET">
    <c:out value="${passenger.firstName}" /><br/>
    <c:out value="${passenger.lastName}" /><br/>
    <c:out value="${passenger.dateOfBirth}" />
</form>
</body>
</html>