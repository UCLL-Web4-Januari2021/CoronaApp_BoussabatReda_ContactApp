<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Search by Date"/>
</jsp:include>

<main>
    <form>
        <table>
            <tr>
                <td><label for="date">Date</label></td>
                <td><input type="date" id="date" name="date"></td>
            </tr>
        </table>
        <input type="button" id="searchbydate" value="Search by date"/>
        <script type="text/javascript" src="js/searchByDate.js"></script>
    </form>

    <p id="searchbydateResult"></p>
</main>

</body>
</html>
