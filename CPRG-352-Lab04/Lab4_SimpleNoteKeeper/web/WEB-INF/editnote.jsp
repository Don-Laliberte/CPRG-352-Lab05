<%-- 
    Document   : editnote
    Created on : Jun 7, 2021, 8:25:47 PM
    Author     : toesl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <lable>Title:</label>
            <input type="text" name="titleinput" value="${note.getTitle()}"></input>
            <br>
            <label>Contents:</label>
            <textarea name="contentsinput">${note.getContents()}</textarea>
            <br>
            <input type="Submit" value="Submit">
        </form>
    </body>
</html>
