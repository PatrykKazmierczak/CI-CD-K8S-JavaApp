<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>SAPP</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signin.css">
</head>
<body class="text-center">

<main class="form-signin">
    <form:form action="${pageContext.request.contextPath}/web/login/register" modelAttribute="user" method="post">
        <c:if test="${param.error != null}">
            <div class="form-group">
                <div class="col-xs-15">
                    <div class="alert alert-danger col-xs-offset-1 col-sx-15">
                        Invalid username or password.
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${param.loginAlreadyExists != null}">
            <div class="form-group">
                <div class="col-xs-15">
                    <div class="alert alert-danger col-xs-offset-1 col-sx-15">
                        Given login already exists.
                    </div>
                </div>
            </div>
        </c:if>
        <h1 class="h3 mb-3 fw-normal">Please register</h1>

        <div class="form-floating">
            <form:input cssClass="form-control" id="floatingInput" placeholder="Login" path="login"/>
            <label for="floatingInput">Login</label>
        </div>
        <div class="form-floating">
            <form:password cssClass="form-control" id="floatingPassword" placeholder="Password" path="password"/>
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-dark" type="submit">Register now!</button>

        <div style="clear: both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/web/login/login-page">Back to login</a>
        </p>

        <p class="mt-5 mb-3 text-muted">SAPP 2022</p>
    </form:form>
</main>
</body>
</html>
