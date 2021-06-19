<%-- 
    Document   : welcomepage
    Created on : Jun 18, 2021, 4:33:59 PM
    Author     : toesl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${username}.</h3>
        
        <a href="login?param">Logout</a>
    </body>
</html>
