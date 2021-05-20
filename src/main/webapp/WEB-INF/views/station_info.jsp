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
<div>
    <jsp:include page="header.jsp"/>
</div>
<h1>Station timetable</h1>
<div>
    <form method="GET" action="/stationInfo/${station.id}">
        <table align="center">
            <tr>
                <td> <input type="date" name="timetableDate"/> </td>
                <td>
                    <input type="submit" value="<spring:message text="Get timetable"/>"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<br/>
<br/>
<div>
    <c:if test="${!empty timetableList}">
        <table class="table-cell" border="1" align="center">
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
</div>


</body>
</html>