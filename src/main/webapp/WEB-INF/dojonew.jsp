<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Titulo</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- Estilos Locales -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<!-- //// HEADER /////////////////////////////////////////// -->
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="navbar-brand d-flex align-items-center"> <strong
					class="text-warning">DOJOS AND NINJAS</strong>
				</a><a class="btn btn-warning " href="/dojos">HOME</a>
			</div>
		</div>
	</header>
	<!-- //// MAIN AREA //////////////////////////////////////// -->
	<main role="main" >
		<div class="container mt-4 bg-dark rounded text-light ">
			<h1>New Dojo</h1>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<p class="form-group">
					<form:label path="name">Dojo name:</form:label>
					<form:input path="name" class="form-control mb-3"  />
					<form:errors path="name" class="alert alert-danger mb-3" />
				</p>
				<input class="btn btn-success" type="submit" value="Submit New Dojo" />
			</form:form>
		</div>
	</main>


	<!-- jQuery (No necesario en Bootstrap 5) -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/app.js"></script>
</body>
</html>