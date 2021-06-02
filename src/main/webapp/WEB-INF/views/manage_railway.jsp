<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<style type="text/css">
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
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
</style>
<html>
<head>
    <title>Timetable management page </title>
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>

<br/>
<div>
    <h3> Add train stop</h3>
    <form:form method="POST" action="addTrainStop" modelAttribute="trainStop">
        <table>
            <tr>
                <form:select path="trainId.trainName">
                    <form:option value="0" label="--- Select One ---"></form:option>
                    <form:options items="${trainList}" var="trainName"></form:options>
                </form:select>
            </tr>
            <tr>
                <form:select path="stationId.stationName">
                    <form:option value="0" label="--- Select One ---"></form:option>
                    <form:options items="${stationList}" var="stationName"></form:options>
                </form:select>
            </tr>
            <td>
                <form:input type="datetime-local" path="arrivalTime"/>
            </td>
            <td>
                <form:input type="datetime-local" path="departureTime"/>
            </td>
            <tr>
                <td>
                    <input type="submit"
                           value="<spring:message text="Add stop"/>"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<div>
    <h2>Timetable for all stations</h2>

    <c:if test="${!empty fullTimetable}">
        <table border="2" class="tg">
            <tr>
                <th width="200">Train No</th>
                <th width="120">Station</th>
                <th width="200">Arrival time</th>
                <th width="200">Departure time</th>
            </tr>
            <c:forEach items="${fullTimetable}" var="timetable">
                <tr>
                    <td>${timetable.trainId.trainName}</td>
                    <td>${timetable.stationId.stationName}</td>
                    <td>${timetable.arrivalTime}</td>
                    <td>${timetable.departureTime}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<br/>
</body>
</html>