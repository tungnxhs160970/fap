<%-- 
    Document   : login
    Created on : Dec 12, 2022, 9:13:57 AM
    Author     : tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value='${username}'>
            <br>Password: <input type="text" name="password" value='${password}'>
            <br><input type="submit" name="login" value="Login">
        </form>
    </body>
</html>
