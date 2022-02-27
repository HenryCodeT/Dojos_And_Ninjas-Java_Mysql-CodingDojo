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
	<main role="main">
		<div class="container mt-4 bg-dark rounded text-light">
			<div class="row">
				<button class="col btn btn-primary m-3" onclick="window.location.href='/dojos/new';">NEW DOJO</button>
				<button class="col btn btn-primary m-3" onclick="window.location.href='/ninjas/new';">NEW NINJA</button>
			</div>
			<table class="table text-light">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><strong>ID</strong></th>
						<th scope="col"><strong>Dojo</strong></th>
						<th scope="col"><strong>Action</strong></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${ dojos }">
					<tr>
						<td><c:out value="${ dojo.getId() }"></c:out></td>
						<td><c:out value="${ dojo.getName() }"></c:out></td>
						<td class="row align-items-center">
							<a href="/dojos/${ dojo.getId() }">show students</a>
						</td>					
					</tr>
					</c:forEach>
				</tbody>
			</table>
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