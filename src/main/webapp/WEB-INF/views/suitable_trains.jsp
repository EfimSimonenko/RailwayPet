<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find ticket</title>
</head>

<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<h2></h2>
<div>
    <form method="post" action="/buyTicket/${route.train.trainName}">
        <table border="1" class="tg">
            <tr>
                <th width="200">Train name</th>
                <th width="150">Departure station</th>
                <th width="180">Departure time</th>
                <th width="150">Arrival station</th>
                <th width="180">Arrival time</th>
                <th width="150"></th>
            </tr>
                <tr>
                    <td> ${route.train.trainName} </td>
                    <td> ${route.departureStation.stationName} </td>
                    <td> ${route.departureTime} </td>
                    <td> ${route.arrivalStation.stationName}</td>
                    <td> ${route.arrivalTime}</td>
                    <td> <button type="submit">Buy ticket</button> </td>
                </tr>
        </table>
    </form>
</div>

</body>