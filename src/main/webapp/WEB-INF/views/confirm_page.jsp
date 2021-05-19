<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm purchase</title>
</head>

<body>
<h2>The ticket, you chose</h2>
<div>
        <table border="1" class="tg">
            <tr>
                <th width="200">Train name</th>
                <th width="150">Departure station</th>
                <th width="180">Departure time</th>
                <th width="150">Arrival station</th>
                <th width="180">Arrival time</th>
            </tr>
            <tr>
                <td> ${route.train.trainName}" </td>
                <td> ${route.departureStation.stationName}"  </td>
                <td> ${route.departureTime}" </td>
                <td> ${route.arrivalStation.stationName}"</td>
                <td> ${route.arrivalTime}</td>
            </tr>
        </table>
</div>
<div>
    <form:form method="POST" action="/confirm" modelAttribute="passenger">
        <div>
            <spring:message text="First name:"/>
            <form:input type="text" path="firstName" placeholder="First name"></form:input>
        </div>
        <div>
            <spring:message text="Last name:"/>
            <form:input type="text" path="lastName" placeholder="Last name"></form:input>
        </div>
        <div>
            <spring:message text="Date of birth:"/>
            <form:input type="date" path="dateOfBirth" placeholder=""></form:input>
        </div>
        <button type="submit">Buy ticket</button>
    </form:form>
</div>

</body>