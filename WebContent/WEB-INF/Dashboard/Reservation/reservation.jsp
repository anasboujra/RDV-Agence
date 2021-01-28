<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Gestion des Reservations</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href='inc/inc_Dashboard/assets/lib-calendrier/main.css' rel='stylesheet' />
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
				                    <i class="fas fa-calendar-alt"></i>
				                </div>
				                <div>Calendrier
				                    <div class="page-title-subheading">Le calendrier des réservations pour cette semaine
				                    </div>
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
				                    <div id="calendrier">
				                    	
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
	            <form action="reservation" method="post">
	            	<div class="modal-body">
		     			<div class="position-relative form-group"><label>ID de la réservation *</label><input name="idReservation" type="text" value="13" readonly class="form-control"></div>
		                <div class="position-relative form-group"><label>Date *</label><input name="date" type="date" value="<c:out value="${reservation.getDate() }"/>" class="form-control" required></div>
		                <div class="position-relative form-group"><label>Heure *</label><input name="heure" type="time" value="<c:out value="${reservation.getHeure() }"/>" class="form-control" required></div>
		                <div class="position-relative form-group"><label>CIN du client *</label><input name="cin" type="text" class="form-control" value="<c:out value="${reservation.getCin() }"/>" required></div>
						<c:if test="${!empty formulaire.erreurs['cin']  }">
		            	 	<div class=" error mb-2">
	                    		<div class="alert alert-danger mb-2" role="alert">
	                              	<c:out value="${formulaire.erreurs['cin'] }"/>
	                          	</div>
                            </div>
						</c:if>
						<small class="form-text text-muted">Les champs avec un astérisque (*) sont obligatoires.</small>
              		</div>
					<div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		                <button type="submit" class="mt-1 btn btn-primary">Submit</button>
		        	</div>
         		</form>    
       	   	</div>
        </div>
	</div>
	<script type="text/javascript" src="inc/inc_Dashboard/assets/scripts/main.js"></script>
	<script type="text/javascript" src="inc/inc_Dashboard/assets/lib-calendrier/main.js"></script>
	<script>
		var today = new Date();
		var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
	  	document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendrier');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
	      },
	      initialDate: console.log(date),
	      navLinks: true, // can click day/week names to navigate views
	      selectable: true,
	      selectMirror: true,
	      select: function(arg) {
	        var title = prompt('Ajouter Reservation:');
	        if (title) {
	          calendar.addEvent({
	            title: title,
	            start: arg.start,
	            end: arg.end,
	            allDay: arg.allDay
	          })
	        }
	        calendar.unselect()
	      },
	      eventClick: function(arg) {
	        if (confirm('Êtes-vous sûr de vouloir supprimer cette réservation?')) {
	          arg.event.remove()
	        }
	      },
	      editable: false,
	      dayMaxEvents: true, // allow "more" link when too many events
	      events: [
	          {title: 'Anas Boujra', start: '2021-01-04T10:00:00', end: '2021-01-04T10:30:00'},
	          {title: 'Mohamed El Attar', start: '2021-01-04T10:30:00', end: '2021-01-04T11:00:00'},
	          {title: 'Mohamed Benaicha', start: '2021-01-04T11:00:00', end: '2021-01-04T11:30:00'},
			  {title: 'SS lola', start: '2021-01-04T12:00:00', end: '2021-01-04T12:30:00'},
	          {title: 'LOAPS LLSMS', start: '2021-01-04T12:30:00', end: '2021-01-04T13:00:00'},
	          {title: 'Moka msoha', start: '2021-01-04T13:00:00', end: '2021-01-04T13:30:00'},
	          {title: 'ALoma MOLA', start: '2021-01-04T13:30:00', end: '2021-01-04T14:00:00'},
	          {title: 'Khocio msoas', start: '2021-01-04T14:00:00', end: '2021-01-04T14:30:00'},
	          {title: 'Mohamed Amiri', start: '2021-01-04T16:00:00', end: '2021-01-04T16:30:00'},
	          {title: 'Anas Boujra', start: '2021-01-05T10:00:00', end: '2021-01-05T10:30:00'},
	          {title: 'Mohamed El Attar', start: '2021-01-09T15:00:00', end: '2021-01-09T15:30:00'},
	          {title: 'Mohamed Benaicha', start: '2021-01-11T12:00:00', end: '2021-01-11T12:30:00'},
	          {title: 'Mohamed Amiri', start: '2021-01-10T16:15:00', end: '2021-01-10T16:45:00'}
	        ]
	      });
	
	    calendar.render();
	  });
</script>
	
</body>
</html>