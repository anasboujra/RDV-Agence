<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Réservations acceptées</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href='inc/inc_Dashboard/assets/lib-calendrier/main.css' rel='stylesheet' />
<link href="inc/inc_Dashboard/css/commentaires.css" rel="stylesheet">
</head>
<body>
	<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
	<c:import url="/inc/inc_Dashboard/header.jsp" />
		<div class="app-main">
			<c:import url="/inc/inc_Dashboard/slidebar.jsp" />
			<div class="app-main__outer">
				<div class="app-main__inner">
				    <div class="app-page-title">
				        <div class="page-title-wrapper">
				            <div class="page-title-heading">
				                <div class="page-title-icon">
				                    <i class="pe-7s-car icon-gradient bg-warm-flame">
				                    </i>
				                </div>
				                <div>Réservations acceptées
				                    <div class="page-title-subheading">Les Réservations acceptées</div>
				                </div>
				            </div>
				            <div class="page-title-actions">
				                <button type="button" class="btn mr-3 btn-success" data-toggle="modal" data-target=".ajouter-reservation">Ajouter une Réservation</button>			                    
			                    <div class="dropdown d-inline-block">
		                           <button type="button" aria-haspopup="true" aria-expanded="false" data-toggle="dropdown" class="mb-2 mr-2 dropdown-toggle btn btn-info">Liste des réservations</button>
		                           <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu">
		                               <a href="?action=enAttente" tabindex="0" class="	dropdown-item">Réservations en attente (3)</a>
		                               <a href="?action=acceptee" tabindex="0" class="	dropdown-item">Réservations acceptées</a>
		                               <a href="?action=validee" tabindex="0" class="	dropdown-item">Réservations validées</a>
		                               <a href="?action=refusee" tabindex="0" class="	dropdown-item">Réservations refusées</a>
		                           </div>
		                       	</div>
				       		</div>
						</div>
					</div>
				    <div class="tab-content">
				        <div class="tab-pane tabs-animation fade show active" id="tab-content-0" role="tabpanel">
				            <div class="main-card mb-3 card">
				                <div class="card-body"> 
				                    <div class="row"><br>
			                          <div class="table100 ver1 m-b-110">
                                        <div class="table100-head">
	                                        <table>
	                                           <thead>
	                                           <tr class="row100 head">
	                                           <th class="cell100 column1">ID</th>
	                                           <th class="cell100 column2">Date</th>
	                                           <th class="cell100 column3">Heure</th>
	                                           <th class="cell100 column4">Client</th>
	                                           </tr>  
	                                           </thead>                     
	                                       </table>
                                       </div>
                                       <div class="table100-body js-pscroll">
	                                       <table>
	                                           <c:forEach var="reservation" items="${listeReservations}">
	                                           <tr class="row100 body">
	                                                <td class="cell100 column1"><c:out value="${reservation.idReservation}" /></td>
	                                                <td class="cell100 column2"><c:out value="${reservation.date}" /></td>
	                                                <td class="cell100 column3"><c:out value="${reservation.heure}" /></td>
	                                                <td class="cell100 column4"><c:out value="${reservation.cin}" /></td>
	                                                <td>
	                                                <div class="modal-footer justify-content-center">
	                                                <a data-target="#confirm-delete" data-href="<c:out value="${reservation.idReservation}" />" type="button" class="btn btn-primary btn-danger"  data-toggle="modal" >
	                                                <i class="fas fa-trash-alt mr-3" style="display:inline;"></i>Supprimer</a>
	                                                </div>
	                                               </td>
	                                           </tr>
	                                           </c:forEach>
                                           </table>
		                                 </div>
	                                 </div>
                                	</div>    
				        		</div>
				        	</div>
				    	</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade ajouter-reservation" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-sm">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="exampleModalLongTitle">Ajouter une Réservation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <form class="">
	            	<div class="modal-body">
		     			<div class="position-relative form-group"><label>ID de la réservation *</label><input name="idReservation" type="text" value="1232" readonly class="form-control"></div>
		                <div class="position-relative form-group"><label>Date *</label><input name="date" type="date" class="form-control" required></div>
		                <div class="position-relative form-group"><label>Heure *</label><input name="heure" type="time" class="form-control" required></div>
		                <div class="position-relative form-group"><label>CIN du client *</label><input name="cin" type="text" class="form-control" required></div>
						<small class="form-text text-muted">Les champs avec un astérisque (*) sont obligatoires.</small>
              		</div>
					<div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		                <button class="mt-1 btn btn-primary">Submit</button>
		        	</div>
         		</form>    
       	   	</div>
        </div>
	</div>
	<script type="text/javascript" src="inc/inc_Dashboard/assets/scripts/main.js"></script>
</body>
</html>