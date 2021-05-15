
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
<h2>Stations</h2>

<c:if test="${!empty listStations}">
    <c:forEach items="${listStations}" var="station">
        <option value="${station.id}">${station.stationName}</option>
        <td><a href="/stationInfo/${station.id}">${station.stationName}</a></td>
    </c:forEach>
</c:if>

</body>