<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>

<body>

<div>
    <form action="/login">
        <button type="submit">Sign in</button>
    </form>
    </br>
    <form action="/register">
        <button type="submit">Sign up</button>
    </form>
</div>
</br>
</br>
<div>
    <form action="/findTicket">
        <button type="submit">Find tickets</button>
    </form>
    </br>
    <form action="/stations">
        <button type="submit">Show all stations </button>
    </form>
</div>




</body>