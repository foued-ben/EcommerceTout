<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification de produit</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<body>


	<h2>Modification d'un produit</h2>


	<form:form class="form-horizontal" method="POST"
		action="modifierProduit" modelAttribute="produitModif">
		<div class="form-group">
			<form:label path="id" class="col-sm-2 control-label">Id</form:label>
			<div class="col-sm-4">
				<form:input path="id" class="form-control"/>
				<form:errors path="id" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="designation" class="col-sm-2 control-label">Designation</form:label>
			<div class="col-sm-4">
				<form:input path="designation" class="form-control"/>
				<form:errors path="designation" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="description" class="col-sm-2 control-label">Description</form:label>
			<div class="col-sm-4">
				<form:input path="description" class="form-control"/>
				<form:errors path="description" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="prix" class="col-sm-2 control-label">Prix</form:label>
			<div class="col-sm-4">
				<form:input path="prix" class="form-control"/>
				<form:errors path="prix" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="quantite" class="col-sm-2 control-label">Quantit�</form:label>
			<div class="col-sm-4">
				<form:input path="quantite" class="form-control"/>
				<form:errors path="quantite" />
			</div>
		</div>

	<form:label path="categorie.id" class="col-sm-2 control-label">Cat�gorie</form:label>
			<div class="col-sm-2">
		<form:select class="form-control" path="categorie.id">
					<form:options items="${listeCategories}" itemLabel="nomCategorie" itemValue="id"></form:options>

	
		</form:select>
		</div>
		<br/>
		<br/>
		<br/>
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Modifier le produit" class="btn btn-info" />
		</div>
	</form:form>
	<p style="color: red">${message}</p>

</body>
</html>