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

    <title>3 Col Portfolio - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/themes/css/bootstrap.min.css" var="CoreCss"/>
    <link href="${CoreCss}" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/resources/themes/css/3-col-portfolio.css" var="CustomCss"/>
    <link href="${CustomCss}" rel="stylesheet">

    <spring:url value="/resources/themes/img/gr_web.jpg" var="image"/>

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
                <a class="navbar-brand" href="#">MyMDB</a>
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
                <small>${movies.size()} results</small></h1>
            </div>
        </div>
        <!--Rows-->

        <c:forEach var="i" items="${movies}" varStatus="stat">
            <c:if test="${stat.index % 3 == 0}">
                <div class="row">
            </c:if>
                <div class="col-md-4 portfolio-item">
                    <a href="${pageContext.request.contextPath}/mymdb/movies/view?id=${i.id}">
                        <img class="img-responsive" src="${image}" alt="">
                    </a>
                    <h3>
                        <a href="${pageContext.request.contextPath}/mymdb/movies/view?id=${i.id}">${i.title}</a>
                    </h3>
                    <p>${i.synopsis}</p>
                </div>
            <c:if test="${stat.index % 3 == 2}">
                </div>
            </c:if>
        </c:forEach>
        <c:if test="${movies.size() % 3 != 0}">
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

    <!-- jQuery -->
    <script:url  value="/resources/themes/js/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <!-- Bootstrap Core JavaScript -->
    <script:url  value="/resources/theme/js/bootstrap.min.js" var="JavaScript"/>
    <script src="${JavaScript}"></script>

</body>

</html>
