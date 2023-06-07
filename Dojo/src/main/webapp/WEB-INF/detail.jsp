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
<div class="container pt-5 w-50">
		<div class="card-body bg-light">
			<h2 class="text-center">Information</h2>
					
		
			<div class="row mt-3">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h1 class="card-text"><c:out value="${question.pregunta}"></c:out></h1>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
		<div class="col-6 mt-3">
			<h4>Tags : </h4>
			
			<ul class="list-group list-group-horizontal">
			  <c:forEach items="${question.tags}" var="tag">
				<li class="list-group-item">${tag.subject }</li>
			</c:forEach>  
			</ul>
		</div>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Answers :</th>
		    </tr>
		  </thead>
		  <tbody>
		    
			   <c:forEach items="${question.respuestas}" var="res">
			   <tr>
			      <td>${res.respuesta }</td>
			    </tr>
					
				</c:forEach> 
		  </tbody>
		</table>
	
		<form:form action="/answers/new" method="post" modelAttribute="respuesta_add">
			<form:errors class="text-danger" path="respuesta" />
			<div class="form-group">
			<form:input type="hidden" path="pregunta" value="${question.id }" />
		        <form:label path="respuesta">Answer:</form:label>
		        <form:textarea class="form-control" path="respuesta"/>
		    </div>
		    <button>Answer it!</button>
		</form:form>
		
		
	</div>



</body>
</html>