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
<div>
    <jsp:include page="header.jsp"/>
</div>
<h1>Find ticket</h1>

<form:form method="POST" action="/searchForTrain" modelAttribute="ticketSearchForm">
    <div>
        <table>
            <tr>
                <td>
                    <spring:message text="From:"/>
                </td>
                <td>
                    <form:input type="text" path="stationFrom" placeholder=""></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message text="To:"/>
                </td>
                <td>
                    <form:input type="text" path="stationTo" placeholder=""></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message text="Earliest departure time:"/>
                </td>
                <td>
                    <form:input type="datetime-local" path="departureTimeAfter" placeholder="Departure time"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message text="Latest arrival time:"/>
                </td>
                <td>
                    <form:input type="datetime-local" path="arrivalTimeBefore" placeholder="Arrival time"></form:input>
                </td>
            </tr>
        </table>

    </div>
    <button type="submit">Find tickets</button>
</form:form>

</body>

