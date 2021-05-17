
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
<div>
    <c:if test="${!empty listStations}">
        <table border="1" class="tg">
            <tr>
                <th width="200">Station name</th>
            </tr>
            <c:forEach items="${listStations}" var="station">
                <tr>
                    <td><a href="/stationInfo/${station.id}">${station.stationName}</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>