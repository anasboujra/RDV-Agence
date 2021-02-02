<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${publication.titre}</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="inc/css/style.css">
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

	<!-- Quiz Section -->
    <section class="mt-4">
        <div class="container mx-auto">
            <div class="row">
                <div class="col-12 col-lg-8">
                    <div class="mb-3 d-flex justify-content-between">
                        <h3>
                        	<a href="#" class="category-link">Nom du catégorie</a>
                        </h3>
                    </div>
                    <h1 class="publication-title">${publication.titre}</h1>
                    <div class="author d-flex justify-content-between">
                        <div class="author-name px-1">
                            <p><img src="inc/inc_Dashboard/assets/images/<c:out value="${employe.photoProfile}"/>" class="author-image mr-3"><span>by</span><a href="#">
								 <c:out value='${employe.nom}' /> <c:out value='${employe.prenom}' /> </a><span class="d-none d-md-inline"> . about 9 months ago</span></p>
                        </div>
                        <div class="views text-right">
                            <span>3.1k views</span>
                        </div>
                    </div>
                    <hr>
                    <div class="blog">
                        <div class="blog-image">
                            <img src="inc/inc_Dashboard/assets/images/<c:out value="${publication.image }"/>" class="d-block w-100">
                        </div>
                        <div class="blog-post mt-4">
                            <p class="px-0 px-md-4">
	                            <c:out value='${publication.contenu}' />
	                        </p>
                        </div>
                    </div>
                    <hr>
                    <div class="Share mb-5">
                        <div class="row">

                            <!-- Visible on computer & Pc screen -->
                            <div class="col-6 share-button d-none d-md-block px-1 mt-2">
                                <a class="btn btn-primary share-fb btn-block">
                                	<i class="fab fa-facebook pr-2"></i>
	                                Share on facebook
	                            </a>
                            </div>
                            <div class="col-6 share-button d-none d-md-block px-1 mt-2">
                                <a class="btn btn-primary share-twitter btn-block">
                                	<i class="fab fa-twitter pr-2"></i>
	                                Share on twitter
	                            </a>
                            </div>

                            <!-- Visible on Phone screen -->
                            <div class="col-6 share-button d-block d-md-none px-1 mt-2">
                                <a class="btn btn-primary share-fb btn-block"><i class="fab fa-facebook"></i></a>
                            </div>
                            <div class="col-6 share-button d-block d-md-none px-1 mt-2">
                                <a class="btn btn-primary share-twitter btn-block"><i class="fab fa-twitter"></i></a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="pl-5 col-4 d-none d-lg-block">
                    <div class="picks text-center mt-2">
                        <h3 class="section-title section-title-size text-center">Nos <span>Publications</span></h3>
                    </div>
                    <hr>
                    <c:forEach items="${publications}" var="item">
                    <a href="#" class="publication-link">
						<div class="publication-content px-3 mx-3 mb-4">
							<div class="publication-image">
								<img src="inc/inc_Dashboard/assets/images/<c:out value="${item.image }"/>" class="d-block image-para img-fluid">
							</div>
							<div class="publication-body text-center pb-5">
								<h4 class="">${item.titre }</h4>
								<span>
									<a href="post?id=<c:out value='${item.id}' />&idEmp=<c:out value="${item.idEmploye}"/>" class="formConnexion-link">Learn More</a>
								</span>
							</div>
						</div>
					</a>
					</c:forEach>
                     
                </div>
            </div>
        </div>
    </section>


    <!--More Stuff Section-->
    <section id="more-stuff" class="mb-5">
        <div class="container mx-auto">
            <div class="row">
                <div class="col-12 col-md-7 col-lg-8">
                    <div class="news-letter text-center px-4 py-4 mt-5">
                    	<h3 class="section-title section-title-size text-center mb-3">Vous voulez plus de trucs <span>comme ça?</span></h3>
                        <p class="mb-4">Obtenez les meilleures publications directement dans votre boîte de réception!</p>

                        <!-- Display on Computer & Pc Screen -->
                        <form class="form-inline d-none d-md-block">
                            <input type="email" class="form-control input-pc mr-2" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <button type="submit" class="btn btn-primary btn-signup">SIGN UP</button>
                            <small id="emailHelp" class="form-text text-muted mx-auto">Don't worry, we don't spam</small>
                        </form>

                        <!-- Display on Phone Screen -->
                        <form class="form-inline d-block d-md-none">
                            <input type="email" class="form-control d-block w-100 mb-2 text-center" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <button type="submit" class="btn btn-primary btn-signup mb-2 btn-block">SIGN UP</button>
                            <small id="emailHelp" class="form-text text-muted mx-auto">Don't worry, we don't spam</small>
                        </form>

                        <div class="mail-logo text-center">
                            <i class="fas fa-envelope" style="color:#fff;"></i>
                        </div>
                    </div>
                    <div class="d-flex justify-content-between mt-5">
                        <div class="float-left mr-2 mt-4">
                            <i class="fas fa-arrow-left" style="font-family: 1.2rem; color: red; font-weight: 600;"></i>
                        </div>
                       
							<c:if test="${publication.id != minId}" >
								<div class="previous-article text-left pr-2">
                            		<a href="post?id=<c:out value='${prevPublication.id}' />&idEmp=<c:out value="${prevPublication.idEmploye}"/>">
                                	 <strong class="d-block mb-2">L'article précedent</strong>
                                	 <span>${prevPublication.titre}</span>
                           			 </a>
                        		</div>
							</c:if>
								
							 
                        	<c:if test="${publication.id != maxId}">
	                        	  <div class="next-article text-right pl-2">
			                            <a href="post?id=<c:out value='${nextPublication.id}' />&idEmp=<c:out value="${nextPublication.idEmploye}"/>">
			                                <strong class="d-block mb-2 mr-2 ">L'article suivant</strong>
			                                <span class="mr-2">${nextPublication.titre}</span>
			                            </a>
			                        </div>
                        	</c:if>
		                        
                        <div class="float-right ml-2 mt-4">
                            <i class="fas fa-arrow-right" style="font-family: 1.2rem; color: red; font-weight: 600;"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-5 col-lg-4 d-none d-md-block">
                    <div class="picks text-center mt-2">
                    	<h3 class="section-title section-title-size text-center">Vous pouvez nous trouver sur <span>les réseaux sociaux</span></h3>
                    </div>
                    <hr>
                    <div class="picks-images snapcode text-center">
                        <img src="inc/assets/images/facebook.png" class="d-block w-100">
                        <h2>
                        	<a href="#" class="d-block">ReservationAgency
                        	</a>
                        	<span class="span-pub mt-2 px-3">@ReservationAgency</span>
                        </h2>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- Comment Section -->
    <section id="comment" class="">
        <div class="container mx-auto">
            <div class="col-12 col-md-8 p-0">
                <div class="picks mt-2">
                    <h2 class="text-center title">Commentaires</h2>
                    <ul class="list-inline text-center">
                        <li class="list-inline-item">
                            <a href="" class="active">Un commentaire sur nos services</a>
                        </li>
                    </ul>
                    <hr>

                </div>
                <div class="picks mt-2">
                    <h2 class="text-center title">Laissez un commentaire</h2>
                    <hr>
                </div>
                <div class="comment-content">
                    <p class="m-0">
                    	Votre adresse email ne sera pas publiée. Les champs requis sont indiqués *
                    </p>
                    <!-- Visible on Computer & Pc Screen -->
                    <form class="pl-0 pl-md-4 pt-3 form-pc d-none d-md-block">
                        <div class="form-group">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="comment*"></textarea>
                        </div>
                        <div class="form-group input-size">
                            <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Name*">
                        </div>
                        <div class="form-group input-size">
                            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Email*">
                        </div>
                        <div class="form-group input-size">
                            <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Website">
                        </div>
                        <div class="form-group">
                            <div class="form-check mb-2">
                                <input class="form-check-input" type="checkbox" id="accept">
                                <label class="form-check-label" for="accept">
						        En utilisant ce formulaire, vous acceptez le stockage et le traitement de vos données par ce site Web.
						        <a href="#"> GDPR Privacy Policy</a> *
						      </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="sign-me">
                                <label class="form-check-label" for="sign-me">
						        Je veux me inscrire à la Newsletter!
						      </label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-signup mb-2">Poster un commentaire</button>
                    </form>

                    <!-- Visible on Phone Screen -->
                    <form class="pl-0 pl-md-4 pt-3 d-block d-md-none">
                        <div class="form-group">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="comment*"></textarea>
                        </div>
                        <div class="form-group input-size">
                            <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Name*">
                        </div>
                        <div class="form-group input-size">
                            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Email*">
                        </div>
                        <div class="form-group input-size">
                            <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Website">
                        </div>
                        <div class="form-group">
                            <div class="form-check mb-2">
                                <input class="form-check-input" type="checkbox" id="accept">
                                <label class="form-check-label" for="accept">
						        En utilisant ce formulaire, vous acceptez le stockage et le traitement de vos données par ce site Web.<a href="#"> GDPR Privacy Policy</a> *
						      </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="sign-me">
                                <label class="form-check-label" for="sign-me">
						        Je veux me inscrire à la Newsletter!
						      </label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-signup mb-2">Poster un commentaire</button>
                    </form>
                </div>
            </div>
            <div class="col-0 col-md-4">

            </div>
        </div>
    </section>



	<!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/24349302c9.js" crossorigin="anonymous"></script>

    <!-- Jquery Cdn -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Bootstrap js F-->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<!-- Main Js -->
	<script type="text/javascript" src="inc/assets/scripts/main.js"></script>
</body>
</html>