<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>StudentID</td>
                <td>StudentName</td>
                <td>Gender</td>
                <td>DOB</td>
            </tr>
            <c:forEach items="${requestScope.student}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender}</td>
                    <td>${s.dob}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>