<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<title>Ajouter Employe</title>
<link href="inc/inc_Dashboard/css/main.css" rel="stylesheet">
<link href="inc/inc_Dashboard/css/employe.css" rel="stylesheet">
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
				        <h2 class="title">Add Employee</h2>
				    </div>
				    <div class="card-body">
				        <form method="POST">
				            <div class="form-row m-b-55">
				                <div class="name">Name</div>
				                <div class="value">
				                    <div class="row row-space">
				                        <div class="col-6">
				                            <div class="input-group-desc">
				                                <input class="input--style-5" type="text" name="first_name">
				                                <label class="label--desc">first name</label>
				                            </div>
				                        </div>
				                        <div class="col-6">
				                            <div class="input-group-desc">
				                                <input class="input--style-5" type="text" name="last_name">
				                                <label class="label--desc">last name</label>
				                            </div>
				                        </div>
				                    </div>
				                </div>
				            </div>
				            <div class="form-row">
				                <div class="name">Cin</div>
				                <div class="value">
				                    <div class="input-group">
				                        <input class="input--style-5" type="text" name="adresse">
				                    </div>
				                </div>
				            </div>
				            <div class="form-row">
				                <div class="name">Adresse</div>
				                <div class="value">
				                    <div class="input-group">
				                        <input class="input--style-5" type="text" name="adresse">
				                    </div>
				                </div>
				            </div>
				            <div class="form-row">
				                <div class="name">Email</div>
				                <div class="value">
				                    <div class="input-group">
				                        <input class="input--style-5" type="email" name="email">
				                    </div>
				                </div>
				            </div>
				             <div class="form-row">
				                <div class="name">Phone Number</div>
				                <div class="value">
				                    <div class="input-group">
				                        <input class="input--style-5" type="text" name="numTele">
				                    </div>
				                </div>
				            </div>
				            <div class="form-row">
				            	<div class="name">Profil Picture</div>
				            	<div class="value custom-file">
							      	<input type="file" class="custom-file-input input--style-5" id="customFile" name="filename">
							      	<label class="custom-file-label" for="customFile">Choose file</label>
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