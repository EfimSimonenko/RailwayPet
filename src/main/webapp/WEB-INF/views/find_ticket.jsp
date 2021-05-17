<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search</title>
</head>

<body>
<h1>Look for a possible route</h1>

<form:form method="POST" action="/searchForTrain" modelAttribute="ticketSearchForm">
    <div>
        <form:input type="text" path="stationFrom" placeholder="From"></form:input>
    </div>
    <div>
        <form:input type="text" path="stationTo" placeholder="To"></form:input>
    </div>
    <div>
        <form:input type="datetime-local" path="departureTimeAfter" placeholder="Departure time"></form:input>
    </div>
    <div>
        <form:input type="datetime-local" path="arrivalTimeBefore" placeholder="Arrival time"></form:input>
    </div>
    <button type="submit">Find tickets</button>
</form:form>

<a href="/">Return to main page</a>
</body>

