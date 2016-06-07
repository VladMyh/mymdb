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

    <title>MyMDB - ${person.name}</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <!--Context path-->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="img_width" value="242"/>
    <c:set var="img_height" value="328"/>
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

    <!-- Portfolio Item Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${person.name}</h1>
        </div>
    </div>
    <!-- /.row -->

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-md-8">
            <c:if test="${person.imagesObjectIds == null}">
                <img class="img-responsive" src="http://placehold.it/${img_width}x${img_height}" width="${img_width}" height="${img_height}" alt="">
            </c:if>
            <c:if test="${person.imagesObjectIds != null}">
                <img class="img-responsive" src="${contextPath}/mymdb/media/get?id=${person.imagesObjectIds.get(0)}" width="${img_width}" height="${img_height}" alt="">
            </c:if>
        </div>

        <div class="col-md-4">
            <c:if test="${person.description != null}">
                <h3>Description</h3>
                <p>${person.description}</p>
            </c:if>
            <c:if test="${person.dateOfBirth != null}">
                <h3>Date of birth</h3>
                <p><fmt:formatDate pattern="dd/MM/yyyy" value="${person.dateOfBirth}"/></p>
            </c:if>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="${contextPath}/mymdb/people/${person.id}/edit" class="btn btn-default" role="button">Edit</a>
                <a href="${contextPath}/mymdb/people/${person.id}/delete" class="btn btn-danger" role="button">Delete</a>
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

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
