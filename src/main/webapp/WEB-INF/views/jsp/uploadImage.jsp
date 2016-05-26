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

    <title>MyMDB - Upload image</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <!--Context path-->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
                </li
                <sec:authorize access="hasAnyRole('ADMIN', 'USER')">>
                <li>
                    <a href="#">${user}</a><!--TODO:replace-->
                </li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <li>
                        <a href="${contextPath}/mymdb/login">Login</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ADMIN', 'USER')">
                    <li>
                        <a href="${contextPath}/mymdb/logout">Logout</a>
                    </li>
                </sec:authorize>
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
            <h1 class="page-header">Upload image</h1>
        </div>
    </div>

    <div class="row">

        <p>${id}</p>


        <div class="col-lg-6">
            <div class="input-group">
                <form action="${contextPath}/mymdb/media/upload" method="post" enctype="multipart/form-data">
                    Image: <input type="file" name="file"/>
                    Title: <input type="text" name="title"/>
                    <span class="input-group-btn">
                        <input type="submit" class="btn btn-default" value="Upload"/>
                    </span>
                </form>
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

    <!-- jQuery -->
    <script:url  value="/resources/themes/js/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <!-- Bootstrap Core JavaScript -->
    <script:url  value="/resources/theme/js/bootstrap.min.js" var="JavaScript"/>
    <script src="${JavaScript}"></script>

</body>

</html>
