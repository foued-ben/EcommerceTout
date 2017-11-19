<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/style.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<<<<<<< HEAD
<body style="background-image :   url(/images/herbe.jpg);">


	<div class="container">
		<img width="1350" height="500" src="images/animalerie.jpg" />
	</div>
	
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

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Quantité</th>
			<th>Catégorie</th>
		</tr>
		<c:forEach var="produit" items="${listeProduits}">
			<tr>
				<td>${produit.id}</td>
				<td>${produit.designation}</td>
				<td>${produit.description}</td>
				<td>${produit.prix}</td>
				<td>${produit.quantite}</td>
				<td>${produit.categorie.nomCategorie}</td>
			</tr>
		</c:forEach>
	</table>

	<form:form cssClass="form-horizontal" method="GET"
		action="pdf" modelAttribute="produit"
		enctype="multipart/form-data">
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Génerer le pdf des produits"
				class="btn btn-danger" />
		</div>
	</form:form>


	<IMG class="superpose" id="img_1" src="WEB-INF/images/petshop.png"
				width="200" height="200" />

=======
<body>
<!-- todo : copier les scripts quand on copiera la navbar -->
<nav class="navbar navbar-inverse">
  <ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/produit/accueil">Accueil</a></li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/panier/affiche">Voir le panier</a></li>
  <li role="presentation" class="dropdown">
  	<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Produits<span class="caret"></span></a>
  	<ul class="dropdown-menu">
  		<li role="presentation"><a href="${pageContext.request.contextPath}/produit/ajout">Ajout</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/produit/modif">Modification</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/produit/suppr">Suppression</a></li>
  	</ul>
  </li>
  <li role="presentation" class="dropdown">
  	<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Catégories<span class="caret"></span></a>
  	<ul class="dropdown-menu">
  		<li role="presentation"><a href="${pageContext.request.contextPath}/categorie/ajout">Ajout</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/categorie/modif">Modification</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/categorie/suppr">Suppression</a></li>
  	</ul>
  </li>
  <li role="presentation"><a href="${pageContext.request.contextPath}/client/recherche">Recherche</a></li>
</ul>
</nav>
<a href="${pageContext.request.contextPath}/mail">Mail</a>
<table class="table table-striped">
  <tr>
  	<th>ID</th>
  	<th>Nom</th>
  	<th>Description</th>
  	<th>Image</th>
  	<th>Prix</th>
  	<th>Quantité</th>
  	<th>Catégorie</th>
  </tr>
  <c:forEach var="produit" items="${listeProduits}">
  	<tr>
  		<td>${produit.id}</td>
  		<td>${produit.designation}</td>
  		<td>${produit.description}</td>
  		<td><img src="${pageContext.request.contextPath}/produit/photo?id=${produit.id}"/></td>
  		<td>${produit.prix}</td>
  		<td>${produit.quantite}</td>
  		<td>${produit.categorie.nomCategorie}</td>
  	</tr>
  </c:forEach>
</table>
>>>>>>> branch 'master' of https://github.com/foued-ben/EcommerceTout.git

</body>
</html>