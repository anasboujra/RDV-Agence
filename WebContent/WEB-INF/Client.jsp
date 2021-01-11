<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Gestion de Clients</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href="inc/inc_Dashboard/css/client.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">

	<!-- Include the header -->
	<c:import url="/inc/inc_Dashboard/header.jsp" />
	
	<div class="app-main">
	
	<!-- Include the side-bar -->
		<c:import url="/inc/inc_Dashboard/slidebar.jsp" />
		
		<div class="app-main__outer ml-4 mt-4">
		
            <!-- Our Navbar -->

            <nav class="navbar navbar-expand-lg navbar-light bg-color mb-3">
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>

              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  <li class="my-2 my-md-0">
                    <span class="mr-1 font-span"><i class="fas fa-user"></i></span>
                    <span class="alert-span-color">5 Clients</span> 
                  </li>
                </ul>
                <form class="form-inline my-2 my-lg-0 search-form d-flex justify-content-end">
                  <div class="">
                      <div class="search">
                      <span class="fa fa-search form-control-feedback"></span> 
                      <input class="form-control mr-sm-2 search-form-input" type="search" placeholder="Search" aria-label="Search">
                      </div>
                      <span class="d-none d-md-inline">
                        <select type="select" id="exampleCustomSelect" name="customSelect" class="custom-select search-form-select mr-sm-2">
                            <option value="">All Clients</option>
                            <option>Value 1</option>
                            <option>Value 2</option>
                            <option>Value 3</option>
                            <option>Value 4</option>
                            <option>Value 5</option>
                        </select>
                        <select type="select" id="exampleCustomSelect" name="customSelect" class="custom-select search-form-select mr-sm-2">
                            <option value="">Group By</option>
                            <option>Value 1</option>
                            <option>Value 2</option>
                            <option>Value 3</option>
                            <option>Value 4</option>
                            <option>Value 5</option>
                        </select>
                      </span>
                  </div>
                </form>
              </div>
            </nav>

            <!-- Employee Dashboard -->

            <div class="Employees px-4 px-md-0 mr-3">
                <div class="row mt-3">
                    <div class="col-lg-4 col-md-6 col-sm-6 mb-5">
                        <div class="Employe-info">
                            <!--<img src="Image-Mine.jpg" class="d-block img-fluid">-->
                            <!-- Visible on Large Screen-->
                            <div class="employe-image d-none d-md-block">
                                <img src="inc/inc_Dashboard/assets/images/benaicha.jpg" class="d-block img-fluid">
                            </div>
                            <!-- Visible on Tablet & Phone Screen-->
                            <div class="employe-image-small d-block d-md-none">
                                <img src="inc/inc_Dashboard/assets/images/benaicha.jpg" class="d-block img-fluid">
                            </div>
                            <div class="Employe-info-header">

                            </div>
                            <div class="Employe-info-body">
                                <h3 class="employe-name text-center mb-1">Mohamed Amine Benaicha</h3>
                                <div class="Employe-info-list d-flex justify-content-between pr-4 mt-3">
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-phone mr-2"></i>+21200997755</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-map-marker-alt mr-2"></i>Agadir</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-calendar-alt mr-2"></i>21/10/2020</span>
                                        </li>
                                    </ul>
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-user mr-2"></i>Amine Benaicha</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-envelope mr-2"></i>amine@gmail.com</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-history mr-2"></i>5 years 3 months</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="Employe-info-contact">
                                    <ul class="list-inline">
                                        <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fas fa-envelope"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-linkedin"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-twitter"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-skype"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item float-right mr-3">
                                           <div class="justify-content-center">
                                            <a href="#myModal" type="button" data-toggle="modal">
                                                <i id="delete-btn" class="fas fa-trash-alt"></i>
                                            </a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 mb-5">
                        <div class="Employe-info">
                            <!--<img src="Image-Mine.jpg" class="d-block img-fluid">-->
                            <!-- Visible on Large Screen-->
                            <div class="employe-image d-none d-md-block">
                                <img src="inc/inc_Dashboard/assets/images/amiri.jpg" class="d-block img-fluid">
                            </div>
                            <!-- Visible on Tablet & Phone Screen-->
                            <div class="employe-image-small d-block d-md-none">
                                <img src="inc/inc_Dashboard/assets/images/amiri.jpg" class="d-block img-fluid">
                            </div>
                            <div class="Employe-info-header">

                            </div>
                            <div class="Employe-info-body">
                                <h3 class="employe-name text-center mb-1">Mohamed Amiri</h3>
                                <div class="Employe-info-list d-flex justify-content-between pr-4 mt-3">
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-phone mr-2"></i>+21200997755</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-map-marker-alt mr-2"></i>Agadir</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-calendar-alt mr-2"></i>21/10/2020</span>
                                        </li>
                                    </ul>
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-user mr-2"></i>Amine Benaicha</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-envelope mr-2"></i>amine@gmail.com</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-history mr-2"></i>5 years 3 months</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="Employe-info-contact">
                                    <ul class="list-inline">
                                        <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fas fa-envelope"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-linkedin"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-twitter"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-skype"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item float-right mr-3">
                                            <div class="justify-content-center">
                                            <a href="#myModal" type="button" data-toggle="modal">
                                                <i id="delete-btn" class="fas fa-trash-alt"></i>
                                            </a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 mb-5">
                        <div class="Employe-info">
                            <!--<img src="Image-Mine.jpg" class="d-block img-fluid">-->
                            <!-- Visible on Large Screen-->
                            <div class="employe-image d-none d-md-block">
                                <img src="inc/inc_Dashboard/assets/images/boujra.jpg" class="d-block img-fluid">
                            </div>
                            <!-- Visible on Tablet & Phone Screen-->
                            <div class="employe-image-small d-block d-md-none">
                                <img src="inc/inc_Dashboard/assets/images/boujra.jpg" class="d-block img-fluid">
                            </div>
                            <div class="Employe-info-header">

                            </div>
                            <div class="Employe-info-body">
                                <h3 class="employe-name text-center mb-1">Anas Boujra</h3>
                                <div class="Employe-info-list d-flex justify-content-between pr-4 mt-3">
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-phone mr-2"></i>+21200997755</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-map-marker-alt mr-2"></i>Agadir</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-calendar-alt mr-2"></i>21/10/2020</span>
                                        </li>
                                    </ul>
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-user mr-2"></i>Amine Benaicha</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-envelope mr-2"></i>amine@gmail.com</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-history mr-2"></i>5 years 3 months</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="Employe-info-contact">
                                    <ul class="list-inline">
                                        <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fas fa-envelope"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-linkedin"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-twitter"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-skype"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item float-right mr-3">
                                            <div class="justify-content-center">
                                            <a href="#myModal" type="button" data-toggle="modal">
                                                <i id="delete-btn" class="fas fa-trash-alt"></i>
                                            </a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 mb-5">
                        <div class="Employe-info">
                            <!--<img src="Image-Mine.jpg" class="d-block img-fluid">-->
                            <!-- Visible on Large Screen-->
                            <div class="employe-image d-none d-md-block">
                                <img src="inc/inc_Dashboard/assets/images/elattar.jpg" class="d-block img-fluid">
                            </div>
                            <!-- Visible on Tablet & Phone Screen-->
                            <div class="employe-image-small d-block d-md-none">
                                <img src="inc/inc_Dashboard/assets/images/elattar.jpg" class="d-block img-fluid">
                            </div>
                            <div class="Employe-info-header">

                            </div>
                            <div class="Employe-info-body">
                                <h3 class="employe-name text-center mb-1">Mohamed El Attar</h3>
                                <div class="Employe-info-list d-flex justify-content-between pr-4 mt-3">
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-phone mr-2"></i>+21200997755</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-map-marker-alt mr-2"></i>Agadir</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-calendar-alt mr-2"></i>21/10/2020</span>
                                        </li>
                                    </ul>
                                    <ul class="list">
                                        <li>
                                            <span class="list-span"><i class="fas fa-user mr-2"></i>Amine Benaicha</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-envelope mr-2"></i>amine@gmail.com</span>
                                        </li>
                                        <li>
                                            <span class="list-span"><i class="fas fa-history mr-2"></i>5 years 3 months</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="Employe-info-contact">
                                    <ul class="list-inline">
                                        <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fas fa-envelope"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-linkedin"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-twitter"></i>
                                            </a>
                                        </li>
                                         <li class="list-inline-item mr-1">
                                            <a href="#">
                                                <i class="fab fa-skype"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item float-right mr-3">
                                            <div class="justify-content-center">
                                            <a href="#myModal" type="button" data-toggle="modal">
                                                <i id="delete-btn" class="fas fa-trash-alt"></i>
                                            </a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
		
		</div>
		
	</div>
	
	<!-- Delete Confirmation Dialog -->

    <div id="myModal" class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-confirm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">&#xE5CD;</i>
				</div>				
			</div>
			<div class="modal-body text-center mt-4">
			    <b>Are you sure ?</b>
				<p>Do you really want to delete this Client? This process cannot be undone.</p>
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
</div>
</body>
<!-- Include our Footer with js scripts-->
<script type="text/javascript" src="inc/inc_Dashboard/assets/scripts/main.js"></script>
<script src="inc/inc_Dashboard/assets/scripts/Commentaires/jquery-3.2.1.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/popper.js"></script>
<script src="inc/inc_Dashboard/assets/scripts/Commentaires/bootstrap.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/select2.min.js"></script>

<script src="inc/inc_Dashboard/assets/scripts/Commentaires/perfect-scrollbar.min.js"></script>
</html>