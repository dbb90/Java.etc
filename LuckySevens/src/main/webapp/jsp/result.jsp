<%-- 
    Document   : result
    Created on : Oct 4, 2017, 10:34:19 AM
    Author     : dbb09
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Bet Slip</h1>
        <p>
            You spent $${initialStack}.00 on Lucky Sevens, and are now broke.
            <br/>
            You played ${totalRolls} times.
            <br/>
            You should've stopped after ${rollsAtMax} rounds.  You'd have walked
            with $${max}.00!
        </p>
    </body>
</html>
