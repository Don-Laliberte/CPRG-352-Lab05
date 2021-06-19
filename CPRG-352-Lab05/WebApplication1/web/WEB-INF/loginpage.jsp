<%-- 
    Document   : loginpage
    Created on : Jun 18, 2021, 4:34:50 PM
    Author     : toesl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="usernameInput" value="${usernameValue}"></input><br>
            <label>Password:</label>
            <input type="text" name="passwordInput" value="${passwordValue}"></input><br>
            <input type="submit" value="Log in"></input>
        </form>
        <c:if test="${outputmessage}">
            <p>${message}</p>
        </c:if>
    </body>
</html>
