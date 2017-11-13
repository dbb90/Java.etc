<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
        <head>
        <title>Billy Quizboy's Quizbot - Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body background="${pageContext.request.contextPath}/img/grid.jpg">
<nav role="navigation" class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand navbar-brand-centered" href="${pageContext.request.contextPath}/">QUIZBOT</a>
                </div>
                <div id="navbarCollapse" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li id="homeNav"><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li id="heroesNav"><a href="${pageContext.request.contextPath}/heroes">Heroes</a></li>
                        <li id="powersNav"><a href="${pageContext.request.contextPath}/powers">Powers</a></li>
                        <li id="sightingsNav"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></li>
                        <li id="locationsNav"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                        <li id="orgsNav"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                Edit<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Edit Heroes</a></li>
                                <li><a href="#">Edit Powers</a></li>
                                <li><a href="#">Edit Sightings</a></li>
                                <li><a href="#">Edit Locations</a></li>
                                <li><a href="#">Edit Organizations</a></li>
                            </ul>
                        </li>
      
                    </ul>


                </div>
            </div>
        </nav>
            <div class="col-md-9" style="background:rgba(255,255,255,.7)">
                <h2>-Cast List-</h2>
                <table id="castTable" class="table table-hover">
                    <tr>
                        <th width="25%">Date Sighted</th>
                        <th width="25%">location</th>
                        <th width="25%">heroes present</th>
                          <th width="25%">Buttons</th>
                    </tr>
                    <c:forEach var="thisSighting" items="${sightingsList}">
                        <tr>
                            <td>
                              <c:out value="${thisSighting.dateSighted}"/>
                              
                            </td>
                            <td>
                        
                                        
                  
                                    <c:out value="${thisSighting.loc}"/>
                                    
                                   

                        
                            </td>
                            <td>
                            
                                <c:forEach var="currentHero" items="${thisSighting.heroes}">
                                        
                  
                                    <c:out value="${currentHero.heroName}"/>
                                    <br/>
                                   

                                </c:forEach>
                            
                            </td>
                            <td>
                                                                    <c:out value="putbuttonshere"/>

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