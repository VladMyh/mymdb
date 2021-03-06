<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyMDB - Edit ${movie.title}</title>

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

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Edit movie</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <h3>Current poster</h3>
            <c:if test="${movie.imagesObjectIds == null}">
                <img class="img-responsive" src="http://placehold.it/242x328" width="242" height="328" alt="">
            </c:if>
            <c:if test="${movie.imagesObjectIds != null}">
                <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${movie.imagesObjectIds.get(0)}" width="242" height="328" alt="">
            </c:if>
        </div>

        <div class="col-lg-6">
            <div class="input-group">
                <form:form action="${contextPath}/mymdb/movies/update" method="post" enctype="multipart/form-data" modelAttribute="genreForm">
                    <input type="hidden" name="id" value="${movie.id}"/>
                    <fieldset class="form-group">
                        <label>Title</label>
                        <input type="text" name="title" class="form-control" value="${movie.title}">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Release date</label>
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${movie.releaseDate}" var="date"/>
                        <input type="date" name="releaseDate" class="form-control" value="${date}">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Runtime</label>
                        <input type="text" name="runtime" class="form-control" value="${movie.runtimeMinutes}">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Synopsis</label>
                        <input type="text" name="synopsis" class="form-control" value="${movie.synopsis}">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Genres</label>
                        <ul>
                            <c:forEach var="i" items="${movie.genres}">
                                <li>${i.name()}</li>
                            </c:forEach>
                        </ul>
                        <form:checkboxes path="genres" items="${genreList}"/>
                    </fieldset>
                    <fieldset>
                        <label>Poster</label>
                        <label class="file">
                            <input type="file" name="image">
                            <span class="file-custom"></span>
                        </label>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Poster title</label>
                        <input type="text" name="imageTitle" class="form-control">
                    </fieldset>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a href="${contextPath}/mymdb/movies/${movie.id}" class="btn btn-default" role="button">Back</a>
                </form:form>
            </div>
        </div>
    </div>

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
