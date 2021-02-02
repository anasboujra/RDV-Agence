<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Publications</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="inc/css/style.css">
	<link rel="stylesheet" type="text/css" href="inc/css/publications.css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
</head>
<body>
	<header>
		<!-- NavBar -->
		<div class="container-fluid p-0 fixed-top">
			<nav class="navbar navbar-expand-lg navbar-light bg-nav py-3">
				<a class="navbar-brand brand-color" href="#">SimplyBook<span>.me</span></a>
			  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			   		<span class="navbar-toggler-icon"></span>
			  	</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				    <ul class="navbar-nav ml-auto">
				    	<li class="nav-item mr-4">
				        	<a href="#" class="connexion-link" data-toggle="modal" data-target="#connexionModal">Connexion</a>
				      	</li>
				      	<li class="nav-item">
					        <a href="#" class="inscrire-link">S'inscrire</a>
					    </li>
				    </ul>
				</div>
			</nav>
		</div>

		<!-- Nav Menu -->
		<div class="container-fluid p-0">
			<nav class="py-3 nav-menu">
				<ul class="list-inline">
					<li class="list-inline-item mr-3">
						<a class="nav-menu-link" href="">Entreprise</a>
					</li>
					<li class="list-inline-item mr-3">
						<a class="nav-menu-link" href="">Fonctionnalités</a>
					</li>
					<li class="list-inline-item mr-3">
						<a class="nav-menu-link" href="">Tarification</a>
					</li>
				</ul>
			</nav>
		</div>

	</header>
	
  <section class="hero-section">
 	 <div class="card-grid">
 	 <c:forEach items="${publications}" var="item">
	    <a class="card" href="post?id=<c:out value='${item.id}' />&idEmp=<c:out value="${item.idEmploye}"/>">
	      <div class="card__background" style="background-image: url(inc/inc_Dashboard/assets/images/<c:out value="${item.image }"/>)"></div>
	      <div class="card__content">
	        <p class="card__category">${item.titre}</p>
	        <h3 class="card__heading">${item.titre}</h3>
	      </div>
	    </a>
    </c:forEach>
 	 <div>
</section>
	
</body>
</html>