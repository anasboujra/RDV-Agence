<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Ajouter Publication</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href="inc/inc_Dashboard/css/publication.css" rel="stylesheet">
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">

	<!-- Include the header -->
	<c:import url="/inc/inc_Dashboard/header.jsp" />
	
	<div class="app-main">
	
	<!-- Include the side-bar -->
		<c:import url="/inc/inc_Dashboard/slidebar.jsp" />
		
		<div class="app-main__outer ml-4 mt-4">
		
			<!-- Add Employe -->

            <div class="signupForm-ontainer mx-auto px-3 px-sm-0">
			 	<div class="card card-5">
				    <div class="card-heading">
				        <h2 class="title">Ajouter Publication</h2>
				    </div>
				    <div class="card-body">
				        <form method="POST"  action="publication?action=enregistrer">
				            <div class="form-row m-b-55">
				                <div class="name">Titre</div>
				                <div class="value">
				                    <div class="input-group">
				                        <input class="input--style-5" type="text" name="titre" value="<c:out value='${publication.titre}' />">
				                        <span class="erreur">${form.erreurs['titre']}</span>
				                    </div>
				                </div>
				            </div>
				            <div class="form-row">
				                <div class="name">Contenu</div>
				                <div class="value">
				                    <div class="input-group">
				                        <textarea class="input--style-5" name="contenu" ><c:out value="${publication.contenu}" /></textarea>
				                        <span class="erreur">${form.erreurs['contenu']}</span>
				                    </div>
				                </div>
				            </div>
				             
				             
				              
				            <div class="form-row">
				            	<div class="name">Image</div>
				            	<div class="value custom-file">
							      	<input type="file" class="custom-file-input input--style-5" id="image" name="image">
							      	<label class="custom-file-label" for="image">Choose file</label>
							    </div>
				            </div>
				            <div>
				                <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
				            </div>
				        </form>
				    </div>
				</div>
			</div>  
		
		</div>
		
	</div>
</div>

<!-- Include our Footer with js scripts-->
<c:import url="/inc/inc_Dashboard/footer.jsp" />