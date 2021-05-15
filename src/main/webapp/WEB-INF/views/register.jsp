<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>

<body>
<h1>Register</h1>

<form:form method="POST" action="/register" modelAttribute="registrationForm">
    <table>
        <div>
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>
        <div>
            <form:input type="text" path="firstName"
                        placeholder="First name"></form:input>
        </div>
        <div>
            <form:input type="text" path="lastName"
                        placeholder="Last name"></form:input>
        </div>
        <div>
            <form:input type="date" path="dateOfBirth"
                        placeholder="Date of birth"></form:input>
        </div>
        <button type="submit">Register</button>
    </table>
</form:form>

<a href="/index">Return to main page</a>
</body>