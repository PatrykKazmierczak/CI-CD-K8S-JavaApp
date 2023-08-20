<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>SAPP</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sticky-footer-navbar/">

    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/assets/dist/css/bootstrap.min.css">

    <!-- Favicons -->
    <meta name="theme-color" content="#7952b3">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/sticky-footer-navbar.css" rel="stylesheet">
</head>

<body class="d-flex flex-column h-100">
<header>
    <jsp:include page="navbar-section.jsp">
        <jsp:param name="disableSearch" value="true"/>
    </jsp:include>
</header>

<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Password form</h1>
        <p class="lead">Fill the form to add your new password.</p>
        <form:form action="save" modelAttribute="pass" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>Web Page:</label></td>
                    <td><form:input path="webPage" cssClass="w-600 mb-1 form-control"/></td>
                </tr>
                <tr>
                    <td><label>Login:</label></td>
                    <td><form:input path="login" cssClass="w-600 mb-1 form-control"/></td>
                </tr>
                <tr>
                    <td><label>Password:</label></td>
                    <td><form:password path="password" cssClass="w-600 mb-1 form-control"/></td>
                </tr>
                <tr>
                    <td><label>Submit</label></td>
                    <td><input type="submit" value="Save" class="btn mb-3 btn-lg btn-dark"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/web/app/password/list">Back to list</a>
        </p>
    </div>
</main>

<footer class="footer mt-auto py-3 bg-dark">
    <div class="container">
        <span class="text-muted">SAPP 2022</span>
    </div>
</footer>

<script src="${pageContext.request.contextPath}/resources/assets/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
