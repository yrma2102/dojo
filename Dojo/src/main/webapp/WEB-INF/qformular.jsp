<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK API</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
		<h1>What is your question? </h1>
		<form:form action="/questions/new" method="post"
			modelAttribute="question" class="mt-5">
			<p class="d-flex justify-content-between mx-3">
				<form:label path="pregunta" class="fs-5">Question:</form:label>
				<form:errors path="pregunta" class="text-danger" />
				<form:textarea path="pregunta" />
		
			</p>
			<p class="d-flex justify-content-between mx-3">
				<form:label path="tags" class="fs-5">Tags:</form:label>
				<form:errors path="tags" class="text-danger" />
				<form:input path="tags" />
			</p>
			<div class="d-flex justify-content-end me-3">
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
		</form:form>
	</div>

</body>
</html>