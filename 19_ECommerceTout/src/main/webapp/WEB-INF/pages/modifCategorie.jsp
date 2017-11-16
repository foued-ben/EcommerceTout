<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification de catégorie</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<body>
	<h2>Modification d'une catégorie</h2>


	<form:form class="form-horizontal" method="POST"
		action="modifierCategorie" modelAttribute="categorieModifiee">
		<div class="form-group">
			<form:label path="id" class="col-sm-2 control-label">Catégorie à modifier</form:label>
			<div class="col-sm-4">
				<form:select cssClass="form-group" path="id" >
					<form:options items="${listeCategories}" itemLabel="nomCategorie" itemValue="id"></form:options>
					
				</form:select>
			</div>
			<form:errors path="id" />

		</div>
		<div class="form-group">
			<form:label path="nomCategorie" class="col-sm-2 control-label">Nom</form:label>
			<div class="col-sm-4">
				<form:input path="nomCategorie" />
			</div>
			<form:errors path="nomCategorie" />

		</div>
		<div class="form-group">
			<form:label path="description" class="col-sm-2 control-label">Description</form:label>
			<div class="col-sm-4">
				<form:input path="description" />
				<form:errors path="description" />
			</div>
		</div>

		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Modifier catégorie" class="btn btn-info" />
		</div>
	</form:form>
	<p style="color: red">${message}</p>
</body>
</html>