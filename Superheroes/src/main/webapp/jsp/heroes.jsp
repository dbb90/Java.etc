<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cast List</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body background="${pageContext.request.contextPath}/img/bg.jpg">
        <div class="container-fluid">
            <center><h1>Billy Quizboy's QUiZBOT - Cast List</h1></center>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/heroes">Characters</a></li>
                </ul>    
            </div>
            <div class="col-md-9" style="background:rgba(255,255,255,.7)">
                <h2>-Cast List-</h2>
                <table id="castTable" class="table table-hover">
                    <tr>
                        <th width="25%">Character</th>
                        <th width="50%">Description</th>
                        <th width="25%">Powers</th>
                    </tr>
                    <c:forEach var="thisHero" items="${heroesList}">
                        <tr>
                            <td>
                                <c:out value="${thisHero.heroName}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${thisHero.heroDesc}"/>
                            </td>
                            <td>
                            
                                <c:forEach var="currentPower" items="${thisHero.powers}">
                                        
                  
                                    <c:out value="${currentPower.powerName}"/>
                                    <br/>
                                   

                                </c:forEach>
                            
                            </td>
                        </tr>
                    </c:forEach>
                </table>


            </div>
                <br/>
                <br/>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>