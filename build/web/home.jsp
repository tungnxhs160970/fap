<%-- 
    Document   : home
    Created on : Dec 14, 2022, 11:44:16 AM
    Author     : tung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Click
        <a href="logout">here</a> to logout.<br/>
        <a href="/MyProject/lecturer/timetable?lid=${sessionScope.account.lecturer.id}">View timetable</a><br/>
       
        <c:if test="${sessionScope.account eq null}">
            click
            <a href="login">here</a> to login.
        </c:if>
    </body>
</html>