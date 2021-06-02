<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    .td {
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

    .tg .tg-4eph {
        background-color: #f9f9f9
    }

    input {
        border:1px solid #ccc;
        width:200px;
        padding:10px;
        margin:5px 15px;
        border-radius:5px;
    }
    .send {
        width:220px;
    }
</style>
<html>
<head>
    <title>All stations</title>
</head>

<body>
    <jsp:include page="header.jsp"/>
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
                    <td><a href="<c:url value='passengers/${train.trainName}'/>">Passengers</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div>
    <h3> Add train</h3>
    <form:form method="POST"
               action="addTrain" modelAttribute="train">
        <table style="border:0;  ">
            <tr>
                <td class="td">
                    <form:label path="trainName">
                        <spring:message text="Train name:"/>
                    </form:label>
                </td>
                <td class="td">
                    <form:input class="input" path="trainName"/>
                </td>
            </tr>
            <tr>
                <td class="td">
                    <form:label path="numberOfSeats">
                        <spring:message text="Number of seats:"/>
                    </form:label>
                </td>
                <td class="td">
                    <form:input class="input" path="numberOfSeats"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="td">
                    <c:if test="${empty train.trainName}">
                        <input type="submit"
                               value="<spring:message text="Add train"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>