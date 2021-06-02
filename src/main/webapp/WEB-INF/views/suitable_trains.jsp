<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style type="text/css">
    .tg {
        border-collapse: separate;
        border-spacing: 0 8px;
        border-color: #ccc;
    }

    .tg td {
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #fff;
    }

    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #f0f0f0;
    }

    .tg .tg-4eph {
        background-color: #f9f9f9
    }

    input {
        border:0;
        padding:10px;
        margin:5px 15px;
    }
    .send {
        width:220px;
    }
</style>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<h2>List of all trains</h2>
<div>
    <c:if test="${!empty routeList}">
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
                <form:form modelAttribute="selectedRoute"
                           method="POST" action="/buyTicket">
                    <tr>
                        <td>
                            <form:hidden path="train.id" value="${route.train.id}"/>
                            <form:input class="input" path="train.trainName" value="${route.train.trainName}" readonly="true"/>
                            <form:hidden path="train.numberOfSeats" value="${route.train.numberOfSeats}"/>
                        </td>
                        <td>
                            <form:hidden path="departureStation.id" value="${route.departureStation.id}"/>
                            <form:input class="input"  path="departureStation.stationName" value="${route.departureStation.stationName}" readonly="true"/>
                        </td>
                        <td>
                            <form:input class="input" path="departureTime" value = "${route.departureTime}" readonly="true"/>
                        </td>
                        <td>
                            <form:hidden path="arrivalStation.id" value="${route.arrivalStation.id}"/>
                            <form:input class="input" path="arrivalStation.stationName" value="${route.arrivalStation.stationName}" readonly="true"/>
                        </td>
                        <td> <form:input class="input" path="arrivalTime" value="${route.arrivalTime}" readonly="true"/></td>
                        <td> <button type="submit">Buy ticket</button> </td>
                    </tr>
                </form:form>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>