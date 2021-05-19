<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Passengers</title>
</head>

<body>
<div>
    <jsp:include page="header.jsp"/>
</div>

<h2>Train ${train.getTrainName()}</h2>
<div>
    <c:if test="${empty ticketList}">
        <label>No passengers registered</label>
    </c:if>
    <c:if test="${!empty ticketList}">
        <table border="1" class="tg">
            <tr>
                <th width="300">Name</th>
                <th width="200">Date of birth</th>
                <th width="200">From</th>
                <th width=""200>To</th>

            </tr>
            <c:forEach items="${ticketList}" var="ticket">
                <tr>
                    <td>${ticket.passenger.firstName} ${ticket.passenger.lastName}</td>
                    <td>${ticket.passenger.dateOfBirth}</td>
                    <td>${ticket.stationFrom}</td>
                    <td>${ticket.stationTo}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>