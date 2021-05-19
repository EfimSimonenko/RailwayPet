<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="window-header">
    <table align="left">
        <tr align="left">
            <th width="100"><a href="/search" style="color: #ae257c; text-decoration: none;"> Find tickets </a></th>
            <th><a href="/stations" style="color: #ae257c; text-decoration: none;"> Show all stations</a></th>
        </tr>
    </table>
    <table align="right">
        <tr align="right">
            <th align="right">
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/admin/editTimetable" style="color: #2527ae; text-decoration: none;">Admin page</a>
                </sec:authorize>
            </th>
            <th align="right">
                <sec:authorize access="!isAuthenticated()">
                    <a href="/login" style="color: #2527ae; text-decoration: none;">Sign in</a>
                </sec:authorize>
            </th>
            <th>
                <sec:authorize access="isAuthenticated()">
                    <a href="/performLogOut" style="color: #2527ae; text-decoration: none;">Log out</a>
                </sec:authorize>
            </th>
        </tr>
    </table>
</div>
<br/>
<br/>
<br/>


