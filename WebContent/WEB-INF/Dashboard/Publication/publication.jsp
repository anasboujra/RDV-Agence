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
                                        <i class="pe-7s-drawer icon-gradient bg-happy-itmeo">
                                        </i>
                                    </div>
                                    <div>Publication</div>
                                </div>
                                <div class="page-title-actions">
                                     
                                    <div class="d-inline-block dropdown">
                                        <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-shadow  btn btn-info">
                                            
                                          
                                        </button>
                                        
 
                                         <a href="publication?action=modifier"> Ajouter Publication</a> 
                                         
                                    </div>
                                </div>   
                                
                                 </div>
                        
                        </div>            
                        
                        <div class="row">     
                            <div class="col-lg-12">
                                <div class="main-card mb-3 card">
                                    <div class="card-body"><h5 class="card-title">Nos Publications</h5>
                                        <table class="mb-0 table table-hover">
                                            <thead>
                                            <tr class="d-flex" >
                                                <th class="col-2">#</th>
                                                <th class="col-6">Titre</th>
                                                <th class="col-2"></th>
                                                <th class="col-2"></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr class="d-flex">
                                                <th scope="row" class="col-2">1</th>
                                                <td class="col-6">Mark</td>
                                                <td class="col-2">
                                                	<button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-success">
                                                	Modifier
                                        			</button>
                                                </td>
                                                <td class="col-2">
                                               		 <button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-danger">
                                                	Supprimer
                                        			</button>
                                       			</td>
                                            </tr>
                                            <tr class="d-flex">
                                                <th scope="row" class="col-2">2</th>
                                                <td class="col-6">Jacob</td>
                                                <td class="col-2">
                                                	<button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-success">
                                                	Modifier
                                        			</button>
                                                </td>
                                                <td class="col-2">
                                               		 <button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-danger">
                                                	Supprimer
                                        			</button>
                                       			</td>
                                            </tr>
                                            <tr class="d-flex">
                                                <th scope="row" class="col-2">3</th>
                                                <td class="col-6">Larry</td>
                                                <td class="col-2">
                                                	<button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-success">
                                                	Modifier
                                        			</button>
                                                </td>
                                                <td class="col-2">
                                               		 <button class="mb-2 mr-2 border-0 btn-transition btn btn-outline-danger">
                                                	Supprimer
                                        			</button>
                                       			</td>
                                            </tr>
                                            </tbody>
                                        </table>
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