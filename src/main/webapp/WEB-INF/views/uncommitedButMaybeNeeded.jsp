<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Suitable trains if more then one
<body>
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
                           method="POST" action="/buyTicket/${route.train.trainName}">
                    <tr>
                        <td> <form:input path="train.trainName" value="${route.train.trainName}"/> </td>
                        <td> <form:input path="departureStation.stationName" value="${route.departureStation.stationName}"/>  </td>
                        <td> <form:input path="departureTime" value = "${route.departureTime}"/> </td>
                        <td> <form:input path="arrivalStation.stationName" value="${route.arrivalStation.stationName}"/></td>
                        <td> <form:input path="arrivalTime" value="${route.arrivalTime}"/></td>
                        <td> <button type="submit">Buy ticket</button> </td>
                    </tr>
                </form:form>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
_________
suitable trains

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

__________
Manage railway before changes
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
<div>
    <jsp:include page="header.jsp"/>
</div>

<br/>

<div>
    <h2>Timetable for all stations</h2>

    <c:if test="${!empty fullTimetable}">
        <table border="2" class="table-row-cell" bgcolor="#00ffff">
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
<div align="center">
    <h3> Add train</h3>
    <form:form method="POST"
               action="addTrain" modelAttribute="train">
        <table class="tg">
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
               action="addStation" modelAttribute="station">
        <table class="tg">
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

</body>
</html>