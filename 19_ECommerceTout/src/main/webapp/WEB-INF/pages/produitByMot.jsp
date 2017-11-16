<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche de produit</title>
<link href="<c:url value="/resources/css/bootstrap.css"></c:url>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"></c:url>"></script>
</head>
<body>


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

</body>
</html>