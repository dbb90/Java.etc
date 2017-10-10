<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>RSVP</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" 
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/jsp/rsvp.jsp">
                            Guest List
                        </a>
                    </li>
                </ul>    
            </div>
            <h2>Coming to my party!?</h2>
                <form action="rsvpAnswer" METHOD="POST">
                    <INPUT TYPE="radio" NAME="radios" VALUE="rsvpYes" CHECKED>
                    Yes
                    <BR>
                    <INPUT TYPE="radio" NAME="radios" VALUE="rsvpNo">
                    No
                    <BR>
                </form>
                <form method = "POST" action ="rsvpAnswer">
                    <input type="text" name="rsvpName"/>
                    <input type="submit" value="rsvpName"/>
                </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
