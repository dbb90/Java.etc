<%-- 
    Document   : contacts
    Created on : Oct 5, 2017, 10:12:33 AM
    Author     : dbb09
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h1>Company Contacts</h1>
            <hr/>
            <div class ="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactsPage">
                            Contacts
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaySearchPage">
                            Search
                        </a>
                    </li>
                </ul>
            </div>
            <!--Main page content strt-->

            <!--Main page content stop-->
        </div>
        <!--bootstrap/jquery/etc-->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js></script>
                <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js>
    </script>


</body>
</html>
