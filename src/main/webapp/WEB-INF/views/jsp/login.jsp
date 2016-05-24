<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyMDB - Login</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <!--Context path-->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <sec:csrfMetaTags/>
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
            <h1 class="page-header">Login</h1>
        </div>
    </div>
    <!--Rows-->

    <div class="row">
        <div class="col-md-4">
            <div class="login-card">
                <div class="login-form">
                    <c:url value="/j_spring_security_check" var="loginUrl" />
                    <form action="${loginUrl}" method="post" class="form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                        </div>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

                        <div class="form-actions">
                            <input type="submit"
                                   class="btn btn-block btn-primary btn-default" value="Log in">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<hr>

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
