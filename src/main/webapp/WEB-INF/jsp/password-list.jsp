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
    <jsp:include page="navbar-section.jsp" />
</header>

<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Passwords list</h1>
        <p class="lead">Here you can manage your passwords. By clicking the <code class="small">View</code>
            button you will decrypt your password.</p>
        <input type="button" value="Add Password" onclick="window.location.href = 'add'; return false;"
               class="btn btn-dark"/>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Password</th>
                <th scope="col">Web Page</th>
                <th scope="col">Login</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <c:forEach var="tmpPassword" items="${passwords}">
                <c:url var="view" value="/web/app/password/view">
                    <c:param name="passwordId" value="${tmpPassword.id}"/>
                </c:url>
                <c:url var="update" value="/web/app/password/update">
                    <c:param name="passwordId" value="${tmpPassword.id}"/>
                </c:url>
                <c:url var="delete" value="/web/app/password/delete">
                    <c:param name="passwordId" value="${tmpPassword.id}"/>
                </c:url>
                <tr>
                    <td scope="row">${tmpPassword.password}</td>
                    <td scope="row">${tmpPassword.webPage}</td>
                    <td scope="row">${tmpPassword.login}</td>
                    <td scope="row">
                        <a href="${view}">View</a>
                        | <a href="${update}">Update</a>
                        | <a href="${delete}"
                             onclick="if(!(confirm('Are you sure you want to delete this password?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
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
