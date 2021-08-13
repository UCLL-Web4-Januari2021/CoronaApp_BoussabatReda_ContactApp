<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>
<main>

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Contact Overview"/>
    </jsp:include>


    <div>
        <h3>Teller</h3>
        <table>
            <thead>
            <tr>
            <th>Room</th>
            <th>Count</th>
            </tr>
            </thead>
            <tbody id="count"></tbody>
        </table>
        <input type="button" id="countPeople" value="count">
    </div>


</main>
</body>
</html>
