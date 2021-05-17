<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>

<body>
<div>
    <button style="color: #245ab8; text-decoration: cyan;"><a href="/search" style="color: #ae257c; text-decoration: none;"> Find tickets </a></button>
</div>
<div>
    <button><a href="/stations" style="color: #ae257c; text-decoration: none;"> Show all stations</a></button>
</div>
<div align="right">
    <sec:authorize access="hasRole('ADMIN')">
        <button style="color: #20354a; text-decoration: tomato;"> <a href="/admin/editTimetable" style="color: #2527ae; text-decoration: none;">Admin page</a> </button>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <button style="color: #20354a; text-decoration: tomato;"> <a href="/login" style="color: #2527ae; text-decoration: none;">Sign in</a> </button>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <button style="color: #20354a; text-decoration: tomato;"> <a href="/performLogOut" style="color: #2527ae; text-decoration: none;">Log out</a> </button>
    </sec:authorize>
</div>
</body>