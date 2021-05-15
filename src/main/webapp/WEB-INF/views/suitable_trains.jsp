<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>All stations</title>
</head>

<body>
<h2>List of all trains</h2>
<div>


    <c:if test="${!empty routeList}">
        <form:form modelAttribute="selectedRoute"
                   method="POST" action="/buyTicket">
        <table class="tg">
            <tr>
                <th width="200">Train name</th>
                <th width="150">Departure station</th>
                <th width="180">Departure time</th>
                <th width="150">Arrival station</th>
                <th width="180">Arrival time</th>
                <th width="150"></th>

            </tr>
            <c:forEach items="${routeList}" var="route">
                <tr>
                    <td> <form:textarea path="trainId.trainName" value="${route.trainId.trainName}"/></td>
                    <td> <form:textarea path="stationFrom.stationName" value=${route.stationFrom.stationName}/></td>
                    <td> <form:textarea path="departureTime" value = "${route.departureTime}"/></td>
                    <td> <form:textarea path="stationTo.stationName" value=${route.stationTo.stationName}/></td>
                    <td> <form:textarea path="arrivalTime" value=${route.arrivalTime}/></td>
                    <td> <button type="submit">Buy ticket</button> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>