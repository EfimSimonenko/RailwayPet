<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Timetable management page </title>
</head>
<body>

<br/>

<div>
    <h2>Timetable for all stations</h2>

    <c:if test="${!empty fullTimetable}">
        <table class="tg">
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
<div>
    <h3> Add train</h3>
    <form:form method="POST"
               action="/addTrain" modelAttribute="train">
        <table>
            <tr>
                <td>
                    <form:label path="trainName">
                        <spring:message text="Train name:"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="trainName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="numberOfSeats">
                        <spring:message text="Number of seats:"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="numberOfSeats"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${empty train.trainName}">
                        <input type="submit"
                               value="<spring:message text="Add train"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<br/>
<br/>
<div>
    <h3> Add station</h3>
    <form:form method="POST"
               action="/addStation" modelAttribute="station">
        <table border="1">
            <tr>
                <td>
                    <form:label path="stationName">
                        <spring:message text="Station name:"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="stationName"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${empty station.stationName}">
                        <input type="submit"
                               value="<spring:message text="Add station"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<br/>
<br/>
<div>
    <h3> Add train stop</h3>
    <form:form method="POST" action="/addTrainStop" modelAttribute="trainStop">
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

</body>
</html>