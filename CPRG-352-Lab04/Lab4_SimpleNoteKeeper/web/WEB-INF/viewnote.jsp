<%-- 
    Document   : viewnote
    Created on : Jun 7, 2021, 8:25:25 PM
    Author     : toesl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP View Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <span><b>Title: </b></span><span name="title">${note.getTitle()}</span>
        <br>
        <span><b>Contents: </b></span><br><span name="content">${note.getContents()}</span>
        <br>
        <a href="note?edit">Edit</a>
    </body>
</html>
