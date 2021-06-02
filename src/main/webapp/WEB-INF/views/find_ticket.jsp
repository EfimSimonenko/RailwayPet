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
        border-width: 0px;
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
        border-width: 0px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #f0f0f0;
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
    <title>Search</title>
</head>

<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<h1>Find ticket</h1>

<form:form method="POST" action="/searchForTrain" modelAttribute="ticketSearchForm">
    <div align="center">
        <table class="tg">
            <tr>
                <td align="right">
                    <spring:message text="From:"/>
                </td>
                <td>
                    <form:input class="input" type="text" path="stationFrom" placeholder=""></form:input>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <spring:message text="To:"/>
                </td>
                <td>
                    <form:input class="input" type="text" path="stationTo" placeholder=""></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message text="Earliest departure time:"/>
                </td>
                <td>
                    <form:input class="input" type="datetime-local" path="departureTimeAfter" placeholder="Departure time"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message text="Latest arrival time:"/>
                </td>
                <td>
                    <form:input class="input" type="datetime-local" path="arrivalTimeBefore" placeholder="Arrival time"></form:input>
                </td>
            </tr>
        </table>
        <button class="send" type="submit">Find tickets</button>
    </div>
</form:form>

</body>

