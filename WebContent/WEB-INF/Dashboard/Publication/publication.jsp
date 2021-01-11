<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Publication</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href="inc/inc_Dashboard/css/publication.css" rel="stylesheet">
<link href="inc/inc_Dashboard/css/util.css" rel="stylesheet">
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
                                        <i class="fas fa-edit"></i>
                                    </div>
                                    <div>Publication</div>
                                </div>
                                <div class="page-title-actions">
                                     
                                    <div class="d-inline-block dropdown">  
                                             <a href="publication?action=ajouter" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-shadow  btn btn-info"> Ajouter Publication</a> 
                                    </div>
                                </div>   
                                
                                 </div>
                        
                        </div>            
                        
                        
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class=" head">
									<th class="column1">Nos Publications</th>
									<th class="column2"></th>
									<th class="column3"></th>
									<th class="column4"></th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<c:forEach var="publication" items="${publications}">
								<tr class="body">
									
									<td class="column1"><c:out value="${publication.id}" /></td>
									
									<td class="column2"><c:out value="${publication.titre}" /></td>
									
									<td class="column4">
										<a href="modifier?id=<c:out value='${publication.id}' />">
											<button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-success">
                                            	  Modifier
                                        	</button>
                                       </a>
									</td>
									
									<td class="cell100 column5">
										<button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-danger" data-toggle="modal" data-target="#exampleModal">
                                          	 Supprimer
                                        </button>
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
                  
	<!-- Delete Confirmation Dialog -->

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body text-center mt-4">
                	<i class="fas fa-exclamation-triangle"></i>
                    <b>�tes vous sure ?</b>
                    <span class="d-block mt-2">
                        �tes vous sure de supprimer cette pubication ?
                    </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-cancel" data-dismiss="modal">Retour</button>
                    <form action="publication?action=supprimer" method="get">    
                    	<input type="text" name="id" />
                        <input type="submit"  class="btn btn-primary btn-delete" value="Supprimer" name="Submit" />
                	</form>
                </div>
            </div>
        </div>
    </div>
	
	 
	
	 

			
<c:import url="/inc/inc_Dashboard/footer.jsp" />
<!--===============================================================================================-->
	<script src="inc/inc_Dashboard/js/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="inc/inc_Dashboard/js/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
		
		$('a[href="#myModal"]').on('click',function(){
			   var id = $(this).attr('data-id');
			  $('input[name="idPublication"]').val(id);
			});
			
		
	</script>
	
	 
</body>
</html>