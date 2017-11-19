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

<div class="container">
		<img id="im" width="1350" 
	height="450" src="<c:url value="/resources/animalerie.jpg"></c:url>" />
	</div>
	
	<IMG class="superpose" id="img_1" src="<c:url value="/resources/petshop.png"></c:url>"
				width="300" height="150" />
	
	<!-- todo : copier les scripts quand on copiera la navbar -->
	<nav class="navbar navbar-inverse"> 
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a
				href="${pageContext.request.contextPath}/produit/accueil">Accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/panier/affiche">Voir le
					panier</a></li>
			<li role="presentation" class="dropdown"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">Produits<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/produit/ajout">Ajout</a></li>
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/produit/modif">Modification</a></li>
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/produit/suppr">Suppression</a></li>
				</ul></li>
			<li role="presentation" class="dropdown"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">Catégories<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/categorie/ajout">Ajout</a></li>
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/categorie/modif">Modification</a></li>
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/categorie/suppr">Suppression</a></li>
				</ul></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/client/recherche">Recherche</a></li>
		</ul>
	</nav>
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
	<br/>
	<h2>Rechercher directement un produit avec son nom</h2>
	<br/>
	
	<form method="get" action="rechercheProduitMot">
	<br/>
		<input type="text" name="motRech" />
		<div class="col-sm-offset-2 col-sm-8">
		<br/>
			<input type="submit" value="Lancer la recherche"
				class="btn btn-success" />
		</div>
	</form>



	<p style="color: red">${message}</p>
  
</body>
</html>