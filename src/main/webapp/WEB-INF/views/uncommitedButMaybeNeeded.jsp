Suitable trains if more then one
<body>
<h2>List of all trains</h2>
<div>
    <c:if test="${!empty routeList}">
        <table border="1" class="tg">
            <tr>
                <th width="200">Train name</th>
                <th width="150">Departure station</th>
                <th width="180">Departure time</th>
                <th width="150">Arrival station</th>
                <th width="180">Arrival time</th>
                <th width="150"></th>
            </tr>
            <c:forEach items="${routeList}" var="route">
                <form:form modelAttribute="selectedRoute"
                           method="POST" action="/buyTicket/${route.train.trainName}">
                    <tr>
                        <td> <form:input path="train.trainName" value="${route.train.trainName}"/> </td>
                        <td> <form:input path="departureStation.stationName" value="${route.departureStation.stationName}"/>  </td>
                        <td> <form:input path="departureTime" value = "${route.departureTime}"/> </td>
                        <td> <form:input path="arrivalStation.stationName" value="${route.arrivalStation.stationName}"/></td>
                        <td> <form:input path="arrivalTime" value="${route.arrivalTime}"/></td>
                        <td> <button type="submit">Buy ticket</button> </td>
                    </tr>
                </form:form>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>
_________
