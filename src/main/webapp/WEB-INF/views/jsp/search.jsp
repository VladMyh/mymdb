<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Search</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <!--Context path-->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="img_width" value="42"/>
    <c:set var="img_height" value="54"/>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${contextPath}/mymdb">MyMDB</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">All movies</a>
                </li>
                <li>
                    <a href="#">Genres</a>
                </li>
                <li>
                    <a href="#">People</a>
                </li>
                <li>
                    <a href="#">${user}</a><!--TODO:replace-->
                </li>
                <li>
                    <a href="${contextPath}/mymdb/login">Login</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Search
                <small>${movies.size() + people.size()} results</small></h1>
        </div>
    </div>
    <!--Rows-->

    <c:if test="${movies.size() > 0}">
        <div class="panel panel-default">
            <div class="panel-heading">Movies, <a href="${contextPath}/mymdb/movies/search?query=${query}">see all...</a></div>
            <div class="panel-body">

            <table class="table">
                <tbody>
                <c:forEach var="i" items="${movies}" varStatus="stat">
                    <tr>
                        <td>
                            <a href="${contextPath}/mymdb/movies/${i.id}">
                                <c:if test="${i.imagesObjectIds == null}">
                                    <img class="img-responsive" src="http://placehold.it/${img_width}x${img_height}" width="${img_width}" height="${img_height}" alt="">
                                </c:if>
                                <c:if test="${i.imagesObjectIds != null}">
                                    <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${i.imagesObjectIds.get(0)}"
                                         width="${img_width}" height="${img_height}" alt="">
                                </c:if>
                            </a>
                        </td>
                        <td>
                            <h3>
                                <a href="${contextPath}/mymdb/movies/${i.id}">${i.title}</a>
                            </h3>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </c:if>

    <c:if test="${people.size() > 0}">
    <div class="panel panel-default">
        <div class="panel-heading">People, <a href="${contextPath}/mymdb/people/search?query=${query}">see all...</a></div>
        <div class="panel-body">

            <table class="table">
                <tbody>
                <c:forEach var="i" items="${people}" varStatus="stat">
                    <tr>
                        <td>
                            <a href="${contextPath}/mymdb/movies/${i.id}">
                                <c:if test="${i.imagesObjectIds == null}">
                                    <img class="img-responsive" src="http://placehold.it/${img_width}x${img_height}" width="${img_width}" height="${img_height}" alt="">
                                </c:if>
                                <c:if test="${i.imagesObjectIds != null}">
                                    <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${i.imagesObjectIds.get(0)}"
                                         width="${img_width}" height="${img_height}" alt="">
                                </c:if>
                            </a>
                        </td>
                        <td>
                            <h3>
                                <a href="${contextPath}/mymdb/movies/${i.id}">${i.name}</a>
                            </h3>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </c:if>

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

<!-- jQuery -->
<script:url  value="/resources/themes/js/jquery.js" var="jQuery"/>
<script src="${jQuery}"></script>

<!-- Bootstrap Core JavaScript -->
<script:url  value="/resources/theme/js/bootstrap.min.js" var="JavaScript"/>
<script src="${JavaScript}"></script>

</body>

</html>
