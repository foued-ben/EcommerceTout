<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<body>

	


	<h1 style="color: gold; text-align: center">Formulaire
		d'inscription</h1>
	<form:form class="form-horizontal" method="POST"
		action="envoyer" modelAttribute="client">
		<div class="form-group">
			<form:label path="nom" class="col-sm-2 control-label">Nom</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="nom" type="text"
					placeholder="Nom" />
				<form:errors path="nom" cssStyle="color:red" />
			</div>
		</div>
		<br />

		<div class="form-group">
			<form:label path="prenom" class="col-sm-2 control-label">Prenom</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="prenom" type="text"
					placeholder="Prenom" />
				<form:errors path="prenom" cssStyle="color:red" />
			</div>
		</div>
		<br />

		<div class="form-group">
			<form:label path="adresse" class="col-sm-2 control-label">Adresse</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="adresse" type="text"
					placeholder="Adresse" />
				<form:errors path="adresse" cssStyle="color:red" />
			</div>
		</div>
		<br />

		<div class="form-group">
			<form:label path="email" class="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="email" type="email"
					placeholder="Email" />
				<form:errors path="email" cssStyle="color:red" />
			</div>
		</div>
		<br />

		<div class="form-group">
			<form:label path="telephone" class="col-sm-2 control-label">Telephone</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="telephone" type="tel"
					placeholder="Telephone" />
				<form:errors path="telephone" cssStyle="color:red"></form:errors>
			</div>
		</div>
		<br />

		<div class="col-sm-offset-2 col-sm-8">
			<button type="submit" class="btn btn-default">S'inscrire</button>
		</div>
	</form:form>





</body>
</html>