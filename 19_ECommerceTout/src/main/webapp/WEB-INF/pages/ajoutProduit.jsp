<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout de produit</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<body>


	<h2>Ajout d'un produit</h2>


	<form:form cssClass="form-horizontal" method="POST"
		action="ajouterProduit" modelAttribute="produit"
		enctype="multipart/form-data">
		<div class="form-group">
		<div class="col-sm-2 control-label">
			<form:label path="designation" cssClass="col-sm-2 control-label">Designation</form:label>
			</div>
			<div class="col-sm-4">
				<form:input path="designation" />
				<form:errors path="designation" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="description" class="col-sm-2 control-label">Description</form:label>
			<div class="col-sm-4">
				<form:input path="description" />
				<form:errors path="description" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="prix" class="col-sm-2 control-label">Prix</form:label>
			<div class="col-sm-4">
				<form:input path="prix" />
				<form:errors path="prix" />
			</div>
		</div>

		<form:label path="quantite" class="col-sm-2  control-label">Quantité</form:label>
		<div class="col-sm-4">
			<form:input path="quantite" />
			<form:errors path="quantite" />
		</div>

<br />

		<form:label path="" class="col-sm-2 control-label">Image</form:label>
		<div class="col-sm-4">
			<input type="file" name="file" />
			<form:errors path="" />
		</div>
<br />
		<form:label path="categorie.id" class="col-sm-2 control-label">Catégorie</form:label>
		<div class="col-sm-2">
			<form:select class="form-control" path="categorie.id">
				<form:options items="${listeCategories}" itemLabel="nomCategorie"
					itemValue="id"></form:options>


			</form:select>
		</div>
		<br />
		<br />
		<br />
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter le produit" class="btn btn-info" />
		</div>
	</form:form>
	<p style="color: red">${message}</p>

</body>
</html>