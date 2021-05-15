<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>All stations</title>
</head>

<body>
<h2>List of all trains</h2>
<div>
    <c:if test="${!empty trainList}">
        <table border="1" class="tg">
            <tr>
                <th width="200">Train No</th>
                <th width="120">Capacity</th>
                <th width="200">Get train passengers</th>

            </tr>
            <c:forEach items="${trainList}" var="train">
                <tr>
                    <td>${train.trainName}</td>
                    <td>${train.numberOfSeats}</td>
                    <td><a href="<c:url value='/passengers/${train.trainName}'/>">Passengers</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>