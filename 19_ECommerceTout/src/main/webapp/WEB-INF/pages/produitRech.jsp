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


	<h2>Recherche des produits d'une catégorie</h2>


	<form:form class="form-horizontal" method="POST"
		action="rechercheProduit" modelAttribute="categorieDemande">

		<form:label path="id" class="col-sm-2 control-label">Catégorie</form:label>
		<div class="col-sm-2">
			<form:select class="form-control" path="id">
				<form:options items="${listeCategories}" itemLabel="nomCategorie"
					itemValue="id"></form:options>


			</form:select>
		</div>
		<br />
		<br />
		<br />
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Lancer la recherche"
				class="btn btn-success" />
		</div>
	</form:form>

	<h2>Rechercher directement un produit avec son nom</h2>
	<form method="GET" action="rechercheProduitMot">
		<input type="text" name="motRech" />
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Lancer la recherche"
				class="btn btn-success" />
		</div>
	</form>



	<p style="color: red">${message}</p>
 
</body>
</html>