
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
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
    <title>All stations</title>
</head>

<body>

    <jsp:include page="header.jsp"/>

<h2>Stations</h2>
<div>
    <c:if test="${!empty listStations}">
        <table class="tg">
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


<div>
    <sec:authorize access="hasRole('ADMIN')">
        <h3> Add station</h3>
        <form:form method="POST"
                   action="addStation" modelAttribute="station">
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
    </sec:authorize>
</div>
</body>