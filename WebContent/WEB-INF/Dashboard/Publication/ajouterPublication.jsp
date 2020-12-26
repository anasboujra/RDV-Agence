<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Ajouter Publication</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
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
                                        <i class="pe-7s-display1 icon-gradient bg-premium-dark">
                                        </i>
                                    </div>
                                    <div>
                                         Nouvelle Publication
                                    </div>
                                </div>
                                    </div>
                        </div>            
                        <div class="tab-content">
                            <div class="tab-pane tabs-animation fade active show" id="tab-content-0" role="tabpanel">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="main-card mb-3 card">
                                            <div class="card-body"><h5 class="card-title">Puclication</h5>
                                                <form class="needs-validation">
                                                    <div class="position-relative form-group">
		                                                <label for="titrePublication" class="">Titre</label>
		                                                <input name="titrePublication" id="titrePublication" placeholder="" type="text" class="form-control" required>
		                                               	<div class="valid-feedback">
		                                            		Looks good!
		                                        		</div>
                                                    </div>
                                                    
                                                    <div class="position-relative form-group">
	                                                    <label for="contenuPublication" class="">Contenu</label>
	                                                    <textarea name="text" id="contenuPublication" class="form-control" required></textarea>
	                                                    <div class="valid-feedback">
		                                            		
		                                        		</div>
                                                    </div>
                                                    <div class="position-relative form-group">
	                                                    <label for="imagePublication" class="">Image</label>
	                                                    <input name="file" id="imagePublication" type="file" class="form-control-file" required>
                                                         <div class="valid-feedback">
		                                            		
		                                        		</div>
                                                    </div>
                                                    <button type="submit" class="mt-1 btn btn-primary">Terminer</button>
                                                </form>
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
	  


	<script type="text/javascript" src="inc/inc_Dashboard/assets/scripts/main.js"></script>
</body>
</html>