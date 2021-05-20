<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<h2>List of all trains</h2>
<div>
    <c:if test="${!empty routeList}">
        <table border="1" class="tg">
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
                            <form:input path="train.trainName" value="${route.train.trainName}"/>
                            <form:hidden path="train.numberOfSeats" value="${route.train.numberOfSeats}"/>
                        </td>
                        <td>
                            <form:hidden path="departureStation.id" value="${route.departureStation.id}"/>
                            <form:input path="departureStation.stationName" value="${route.departureStation.stationName}"/>
                        </td>
                        <td>
                            <form:input path="departureTime" value = "${route.departureTime}"/>
                        </td>
                        <td>
                            <form:hidden path="arrivalStation.id" value="${route.arrivalStation.id}"/>
                            <form:input path="arrivalStation.stationName" value="${route.arrivalStation.stationName}"/>
                        </td>
                        <td> <form:input path="arrivalTime" value="${route.arrivalTime}"/></td>
                        <td> <button type="submit">Buy ticket</button> </td>
                    </tr>
                </form:form>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>