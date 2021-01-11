<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Gestion des Commentaires</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
    <meta name="msapplication-tap-highlight" content="no">
    <link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
    <link href="inc/inc_Dashboard/css/commentaires.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
<body>
	<c:import url="/inc/inc_Dashboard/header.jsp" />
	<div class="app-main">
		<c:import url="/inc/inc_Dashboard/slidebar.jsp" />
     <div class="app-main__outer">
                    <div class="app-main__inner">
                        <div class="app-page-title">
                            <div class="page-title-wrapper">
                                <div class="page-title-heading container2">
                                    
                                    <div>
                                      <i class="fas fa-comments fa-2x iconDetails"></i> </div>
                                      <div class="titleDisc">
                                      <h4>Gestion des Commentaires</h4>
                                        <div class="page-title-subheading">gérer les commentaires publiés par les clients</div>
                                    </div>
                                </div>
                                <div class="page-title-actions">
                                    <div class="input-group">
                                    <input type="text" class="form-control border" placeholder="search a comment">
                                    <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                    <i class="fa fa-search"></i>
                                    </button>
                                    </div>
                                    </div>
                                </div>    </div>
                         </div>            
                                <div class="row">
			                        <br>
			                          <div class="table100 ver1 m-b-110">
                                        <div class="table100-head">
                                        <table>
                                           <thead>
                                           <tr class="row100 head">
                                           <th class="cell100 column1">ID</th>
                                           <th class="cell100 column2">Titre</th>
                                           <th class="cell100 column3">Contenu</th>
                                           <th class="cell100 column4">Client</th>
                                           <th class="cell100 column5">Actions</th>
                                           </tr>  
                                           </thead>   
                                                            
                                       </table>
                                       </div>
                                       <div class="table100-body js-pscroll">
                                       <table>
                                           <c:forEach var="commentaires" items="${listCommentaires}">
                                           <tr class="row100 body">
                                                <td class="cell100 column1"><c:out value="${commentaires.id}" /></td>
                                                <td class="cell100 column2"><c:out value="${commentaires.titre}" /></td>
                                                <td class="cell100 column3"><c:out value="${commentaires.contenu}" /></td>
                                                <td class="cell100 column4"><c:out value="${commentaires.cin}" /></td>
                                                <td>
                                                <div class="modal-footer justify-content-center">
                                                <a data-target="#confirm-delete" data-href="<c:out value="${commentaires.id}" />" type="button" class="btn btn-primary btn-danger"  data-toggle="modal" >
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
               <!-- Delete POP UP-->
<div id="confirm-delete" class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-confirm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">&#xE5CD;</i>
				</div>				
			</div>
			<div class="modal-body text-center mt-4">
			    <b>Are you sure ?</b>
				<p>Do you really want to delete these comment? This process cannot be undone.</p>
			</div>
			<div class="modal-footer justify-content-center">
				<button type="button" class="btn btn-secondary btn-cancel" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary btn-danger">
                        <i class="fas fa-trash-alt mr-3"></i>Delete
                    </button>
			</div>                                                                                           
		</div>
	</div>
</div>     
</body>
<script type="text/javascript" src="inc/inc_Dashboard/assets/scripts/main.js"></script>
<script src="inc/inc_Dashboard/assets/scripts/Commentaires/jquery-3.2.1.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/popper.js"></script>
<script src="inc/inc_Dashboard/assets/scripts/Commentaires/bootstrap.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/select2.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/perfect-scrollbar.min.js"></script>
<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>


<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
  $('#confirm-delete').on('show.bs.modal', function(e) {
	    $(this).find('.btn-delete').attr('href', $(e.relatedTarget).data('href'));
	});
</script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/main.js"></script>
</html>