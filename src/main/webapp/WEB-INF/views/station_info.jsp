<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>This is station ${station.stationName}</title>
</head>
<body>
<h1>Station timetable</h1>
<c:if test="${!empty timetableList}">
    <table class="tg">
        <tr>
            <th width="200">Train name</th>
            <th width="200">Arrival time</th>
            <th width="200">Departure time</th>
        </tr>
        <c:forEach items="${timetableList}" var="timetable">
            <tr>
                <td>${timetable.trainId.trainName}</td>
                <td>${timetable.arrivalTime}</td>
                <td>${timetable.departureTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>