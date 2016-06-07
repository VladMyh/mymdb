<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

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
                <li><a href="#">Movies</a></li>
                <li><a href="#">Genres</a></li>
                <li><a href="#">People</a></li>
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

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Search
                <small>${people.size()} results</small></h1>
        </div>
    </div>
    <!--Rows-->

    <c:forEach var="i" items="${people}" varStatus="stat">
        <c:if test="${stat.index % 3 == 0}">
            <div class="row">
        </c:if>
        <div class="col-md-4 portfolio-item">
            <a href="${contextPath}/mymdb/people/${i.id}">
                <c:if test="${i.imagesObjectIds == null}">
                    <img class="img-responsive" src="http://placehold.it/202x288" width="202" height="288" alt="">
                </c:if>
                <c:if test="${i.imagesObjectIds != null}">
                    <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${i.imagesObjectIds.get(0)}"
                         width="202" height="288" alt="">
                </c:if>
            </a>
            <h3>
                <a href="${contextPath}/mymdb/people/${i.id}">${i.name}</a>
            </h3>
        </div>
        <c:if test="${stat.index % 3 == 2}">
            </div>
        </c:if>
    </c:forEach>
    <c:if test="${people.size() % 3 != 0}">
</div>
</c:if>

<hr>

<!-- Pagination -->
<div class="row text-center">
    <div class="col-lg-12">
        <ul class="pagination">
            <li>
                <a href="#">&laquo;</a>
            </li>
            <li class="active">
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">&raquo;</a>
            </li>
        </ul>
    </div>
</div>
<!-- /.row -->

<hr>

<!-- Footer -->
<footer>
    <div class="row">
        <div class="col-lg-12">
            <p>Copyright &copy; MyMDB 2016</p>
        </div>
    </div>
    <!-- /.row -->
</footer>


<!-- /.container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
