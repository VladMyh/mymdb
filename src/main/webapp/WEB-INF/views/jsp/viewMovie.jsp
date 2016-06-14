<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyMDB - ${movie.title}</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">
    <link href="navbar-fixed-top.css" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <!--Context path-->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${contextPath}/mymdb">MyMDB</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${contextPath}/mymdb/movies?page=0">Movies</a></li>
                <li><a href="#">Genres</a></li>
                <li><a href="${contextPath}/mymdb/people?page=0">People</a></li>
                <form class="navbar-form navbar-left" role="search" action="${contextPath}/mymdb/search" method="get">
                    <div class="form-group">
                        <input type="text" name="query" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin tools<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">Content</li>
                            <li><a href="${contextPath}/mymdb/movies/add">Add movie</a></li>
                            <li><a href="${contextPath}/mymdb/people/add">Add person</a></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${user}</a></li>
                <sec:authorize access="isAnonymous()">
                    <li><a href="${contextPath}/mymdb/login">Login</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="${contextPath}/mymdb/logout">Logout</a></li>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Portfolio Item Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${movie.title}
                    <c:if test="${movie.runtimeMinutes != null}">
                        <small>${movie.runtimeMinutes} min</small>
                    </c:if>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">

            <div class="col-md-4">
                <c:if test="${movie.imagesObjectIds == null}">
                    <img class="img-responsive" src="http://placehold.it/242x328" width="242" height="328" alt="">
                </c:if>
                <c:if test="${movie.imagesObjectIds != null}">
                    <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${movie.imagesObjectIds.get(0)}" width="242" height="328" alt="">
                </c:if>
            </div>

            <div class="col-lg-6">
                <c:if test="${movie.synopsis != null}">
                    <h3>Synopsis</h3>
                    <p>${movie.synopsis}</p>
                </c:if>
                <c:if test="${movie.releaseDate != null}">
                    <h3>Release date</h3>
                    <p><fmt:formatDate pattern="dd/MM/yyyy" value="${movie.releaseDate}"/></p>
                </c:if>
                <c:if test="${movie.genres != null}">
                    <h3>Genres</h3>
                    <ul>
                    <c:forEach var="i" items="${movie.genres}">
                        <li>${i.name()}</li>
                    </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${movie.crew != null}">
                    <h3>People</h3>
                    <c:forEach var="i" items="${movie.crew}">
                        <h4>${i.key}</h4>
                        <c:forEach var="j" items="${movie.crew.get(i.key)}">
                            <a href="${contextPath}/mymdb/people/${j}">${peopleNames.get(j)}</a>
                        </c:forEach>
                    </c:forEach>
                </c:if>
                <sec:authorize access="hasRole('ADMIN')">
                    <a href="${contextPath}/mymdb/movies/${movie.id}/edit" class="btn btn-default" role="button">Edit</a>
                    <a href="${contextPath}/mymdb/movies/${movie.id}/addpeople" class="btn btn-default" role="button">Edit people</a>
                    <a href="${contextPath}/mymdb/movies/${movie.id}/delete" class="btn btn-danger" role="button">Delete</a>
                </sec:authorize>
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
