<%@page import="bean.Client"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ empty sessionScope.client}">
		<jsp:forward page="/acceuilClient.jsp"/>
</c:if>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>E-SOFT</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link href="vendor/mdb/css/mdb.min.css" rel="stylesheet">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Google fonts - Roboto-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700">
    <!-- Bootstrap Select-->
    <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
    <!-- owl carousel-->
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.theme.default.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon and apple touch icons-->
    <link rel="shortcut icon" href="img1/Ecommerce Plateform.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
	<div id="all">
		<!-- Top bar-->
		<div class="top-bar">
			<div class="container">
				<div class="row d-flex align-items-center">
					<div class="col-md-6 d-md-block d-none">
						<p>Contact us on +212 6 64 05 33 45 or contact@esoft.com.</p>
					</div>
					<div class="col-md-6">
						<div class="d-flex justify-content-md-end justify-content-between">
							<ul class="list-inline contact-info d-block d-md-none">
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-phone"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-envelope"></i></a></li>
							</ul>
							<div class="login">
								<a href="Logout"
									class="login-btn"><i class="fa fa-sign-in"></i><span
									class="d-none d-md-inline-block">Se déconnecter</span></a>
									<!-- <a href="register.jsp" class="signup-btn"><i
									class="fa fa-user"></i><span class="d-none d-md-inline-block">Créer
										un nouveau compte</span></a> -->
							</div>
							<ul class="social-custom list-inline">
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-google-plus"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-twitter"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-envelope"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Top bar end-->
		<!-- Login Modal-->
		<div id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="login-modalLabel" aria-hidden="true"
			class="modal fade">
			<div role="document" class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 id="login-modalLabel" class="modal-title">Customer Login</h4>
						<button type="button" data-dismiss="modal" aria-label="Close"
							class="close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="customer-orders.html" method="get">
							<div class="form-group">
								<input id="email_modal" type="text" placeholder="email"
									class="form-control">
							</div>
							<div class="form-group">
								<input id="password_modal" type="password"
									placeholder="password" class="form-control">
							</div>
							<p class="text-center">
								<button class="btn btn-template-outlined">
									<i class="fa fa-sign-in"></i> Log in
								</button>
							</p>
						</form>
						<p class="text-center text-muted">Not registered yet?</p>
						<p class="text-center text-muted">
							<a href="customer-register.html"><strong>Register
									now</strong></a>! It is easy and done in 1 minute and gives you access to
							special discounts and much more!
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Login modal end-->
		<!-- Navbar Start-->
		<header class="nav-holder make-sticky">
		<div id="navbar" role="navigation" class="navbar navbar-expand-lg">
			<div class="container">
				<a href="index.html" class="navbar-brand home"><img
					src="img1/Ecommerce Plateform.png" width="100" height="80"
					alt="Universal logo" class="d-none d-md-inline-block"><img
					src="img/logo-small.png" alt="Universal logo"
					class="d-inline-block d-md-none"><span class="sr-only">Universal
						- go to homepage</span></a>
				<button type="button" data-toggle="collapse"
					data-target="#navigation"
					class="navbar-toggler btn-template-outlined">
					<span class="sr-only">Toggle navigation</span><i
						class="fa fa-align-justify"></i>
				</button>
				<div id="navigation" class="navbar-collapse collapse">
					<ul class="nav navbar-nav ml-auto">
						<li><a href="acceuilClient1.jsp"
							href="javascript: void(0)" >Acceuil</a></li>
							
							<li class="nav-item dropdown"><a href="javascript: void(0)"
							data-toggle="dropdown" class="dropdown-toggle">Logiciels <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="ListeProduitsClient"
									class="nav-link">Commander un logiciel</a></li>
								<li class="dropdown-item"><a href="ListeCommandesClient"
									class="nav-link">Mes commandes</a></li>
							</ul></li>
							
							<li><a href="listePanier.jsp"
							href="javascript: void(0)" >Panier</a></li>
							
							<li class="nav-item dropdown"><a href="javascript: void(0)"
							data-toggle="dropdown" class="dropdown-toggle">Demande <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="demandeMaintenance.jsp"
									class="nav-link">Demande de maintenance</a></li>
								<li class="dropdown-item"><a href="demandeAdaptee.jsp"
									class="nav-link">Demande adaptée</a></li>
									<li class="dropdown-item"><a href="ListeDemandesClient"
									class="nav-link">Mes demandes de maintenance</a></li>
							</ul></li>
							
							<li class="nav-item dropdown"><a href="javascript: void(0)"
							data-toggle="dropdown" class="dropdown-toggle">Compte <b
								class="caret"></b></a>
								
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="ModifierInfoClient"
									class="nav-link">Modifier votre compte</a></li>
							</ul></li>
					</ul>
				</div>
				<div id="search" class="collapse clearfix">
					<form role="search" class="navbar-form">
						<div class="input-group">
							<input type="text" placeholder="Search" class="form-control"><span
								class="input-group-btn">
								<button type="submit" class="btn btn-template-main">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>
		</header>
		<!-- Navbar End-->

		<div id="heading-breadcrumbs" class="brder-top-0 border-bottom-0">
			<div class="container">
				<div class="row d-flex align-items-center flex-wrap">
					<div class="col-md-7">
						<h1 class="h2">Mes commandes</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb d-flex justify-content-end">
							<li class="breadcrumb-item"><a href="index.html"></a></li>
							<li class="breadcrumb-item active"></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="content">
			<div id="contact" class="container">
				<section class="bar">
				<div class="row">
					<div class="col-md-12">
						<div class="heading">
							<h2>We are here to help you</h2>
						</div>
						<p class="lead">Are you curious about something? Do you have
							some kind of problem with our products?</p>
						<p class="text-sm">Please feel free to contact us, our
							customer service center is working for you 24/7.</p>
					</div>
				</div>
				</section>
				<section class="bar pt-0">
				<div class="row">
					<div class="col-md-12">
						<div class="heading text-center">
							<h2>Liste des commandes</h2>
						</div>
					</div>
			   </div>
			   <div class="row">
					<c:forEach items="${commandes}" var="row" >
						<div class="card border-primary mr-4" style="width: 15rem;">
						  <img class="card-img-top" src="ViewImageSoft?id=${row.getProduit().getId_produit()}" alt="Card image cap">
						  <div class="card-body">
						  	<ul class="list-group">
							  <li class="list-group-item" style="font-weight: bold;text-align:center"><c:out value="${row.getProduit().getNom()}"/></li>
							  <li class="list-group-item" style="text-align:center">
							  		<button style="margin-left:5px;" type="button" class="btn btn-info" data-toggle="modal" data-target="#i<c:out value="${row.getProduit().getId_produit()}"/>">
												Description
									</button>
									<div class="modal fade" id="i<c:out value="${row.getProduit().getId_produit()}"/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
												  aria-hidden="true">
												  <div class="modal-dialog" role="document">
												    <form>
												    <div class="modal-content">
												    
												      <div class="modal-header">
												        <h5 class="modal-title" id="exampleModalLabel">Informations sur logiciel</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
																<div class="col-sm-12">
																	<div class="form-group">
																		<label for="description">Description du problème</label>
																		<textarea id="description" style="width: 420px;height: 300px;" type="text" name="description" class="form-control"><c:out value="${row.getProduit().getDescription()}"/></textarea>
																	</div>
																</div>
																<div class="modal-footer">
																        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sortir</button>
													           </div>	          
												       </div>      
												      </div>
												    </form>
												  </div>  
								   </div>
							</li>
							<li class="list-group-item" style="font-weight: bold;text-align:center"><c:out value="${row.getProduit().getPrix()}"/> USD</li>
							<li class="list-group-item" style="text-align:center">
								<c:choose>
									<c:when test="${row.getEtat()==0}"><div class="alert alert-danger" role="alert">
	  													En attente de paiement
													</div>
													
													<button style="margin-left:5px;" type="button" class="btn btn-success" data-toggle="modal" data-target="#j<c:out value="${row.getProduit().getId_produit()}"/>">
																Payer
													</button>
													<div class="modal fade" id="j<c:out value="${row.getProduit().getId_produit()}"/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
																  aria-hidden="true">
																  <div class="modal-dialog" role="document">
																  
																    <form action="authorize_payment" method="post" >
																    <div class="modal-content">
																    
																      <div class="modal-header">
																        <h5 class="modal-title" id="exampleModalLabel">Payer</h5>
																        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
																          <span aria-hidden="true">&times;</span>
																        </button>
																      </div>
																      <div class="modal-body">
																      			<div class="col-sm-12">
																					<div class="form-group">
																						Voulez-vous vraiment payer la commande?
																						
																						<input type="text" name="nom_produit" value=<c:out value="${row.getProduit().getNom()}"/> class="form-control" hidden>
																						<input type="text" name="prix_produit" value=<c:out value="${row.getProduit().getPrix()}"/> class="form-control" hidden>
																						<!-- <input type="text" name="id_client" value=<c:out value="${row.getClient().getId_client()}"/> class="form-control" hidden>
																						<input type="text" name="nom_client" value=<c:out value="${row.getClient().getNomCLT()}"/> class="form-control" hidden>
																						<input type="text" name="prenom_client" value=<c:out value="${row.getClient().getPrenomCLT()}"/> class="form-control" hidden>
																						<input type="text" name="email" value=<c:out value="${row.getClient().getEmailCLT()}"/> class="form-control" hidden>
																						<input type="text" name="cin" value=<c:out value="${row.getClient().getCinCLT()}"/> class="form-control" hidden>
																						<input type="text" name="adresse" value=<c:out value="${row.getClient().getAdresseCLT()}"/> class="form-control" hidden>
																						<input type="text" name="num" value=<c:out value="${row.getClient().getNum_telephoneCLT()}"/> class="form-control" hidden> -->
																					</div>
																				</div> 
																      		
																				<div class="modal-footer">
																						<input type="submit" class="btn btn-primary" value="Payer" />
																				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sortir</button>
																	           </div>       
																      </div>
																    </div>
																    </form>
																  </div>
													</div>
													
													<button style="margin-left:5px;" type="button" class="btn btn-danger" data-toggle="modal" data-target="#g<c:out value="${row.getProduit().getId_produit()}"/>">
																Annuler
													</button>
													<div class="modal fade" id="g<c:out value="${row.getProduit().getId_produit()}"/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
																  aria-hidden="true">
																  <div class="modal-dialog" role="document">
																  
																    <form action="AnnulerCommande" method="post" >
																    <div class="modal-content">
																    
																      <div class="modal-header">
																        <h5 class="modal-title" id="exampleModalLabel">Annuler la commande</h5>
																        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
																          <span aria-hidden="true">&times;</span>
																        </button>
																      </div>
																      <div class="modal-body">
																      			<div class="col-sm-12">
																					<div class="form-group">
																						Voulez-vous vraiment annuler la commande?
																						
																						<input type="text" name="id" value=<c:out value="${row.getId_commande()}"/> class="form-control" hidden>
																						<input type="text" name="prix_produit" value=<c:out value="${row.getProduit().getPrix()}"/> class="form-control" hidden>
																						<!-- <input type="text" name="id_client" value=<c:out value="${row.getClient().getId_client()}"/> class="form-control" hidden>
																						<input type="text" name="nom_client" value=<c:out value="${row.getClient().getNomCLT()}"/> class="form-control" hidden>
																						<input type="text" name="prenom_client" value=<c:out value="${row.getClient().getPrenomCLT()}"/> class="form-control" hidden>
																						<input type="text" name="email" value=<c:out value="${row.getClient().getEmailCLT()}"/> class="form-control" hidden>
																						<input type="text" name="cin" value=<c:out value="${row.getClient().getCinCLT()}"/> class="form-control" hidden>
																						<input type="text" name="adresse" value=<c:out value="${row.getClient().getAdresseCLT()}"/> class="form-control" hidden>
																						<input type="text" name="num" value=<c:out value="${row.getClient().getNum_telephoneCLT()}"/> class="form-control" hidden> -->
																					</div>
																				</div> 
																      		
																				<div class="modal-footer">
																						<input type="submit" class="btn btn-primary" value="Annuler" />
																				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sortir</button>
																	           </div>       
																      </div>
																    </div>
																    </form>
																  </div>
													</div>
										
									</c:when>
									<c:when test="${row.getEtat()==1}"><div class="alert alert-success" role="alert">
	  														Déjà payée
													</div> <li class="list-group-item" style="font-weight: bold;text-align:center"><a style="color:green" type="file" name="file" class="form-control" href="downloadAttachment2?id=${row.getProduit().getId_produit()}">Télécharger</a></li>
									</c:when> 
								</c:choose>
							</li>
							</ul>
						  </div>
						</div>
					</c:forEach>
				</div>
					
					
					
				</div>
				</section>
			</div>
			<!--<div id="map"></div>  -->
		</div>
      <div id="heading-breadcrumbs" class="brder-top-0 border-bottom-0">
			<div class="container">
				<div class="row d-flex align-items-center flex-wrap">
					<div class="col-md-7">
						<h1 class="h2"></h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb d-flex justify-content-end">
							<li class="breadcrumb-item"><a href="index.html"></a></li>
							<li class="breadcrumb-item active"></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- FOOTER -->
		<footer class="main-footer">
		<section>
            <div class="row text-center">
              <div class="col-md-4">
                <div class="box-simple">
                  <div class="icon-outlined"><i class="fa fa-map-marker" style="color:white;margin-top: 30px;"></i></div>
                  <h3 class="h4">Address</h3>
                  <p>ENSIAS<br>                                        Mohammed V University In Rabat<br>                                        <strong> Morocco</strong></p>
                </div>
              </div>
              <div class="col-md-4">
                <div class="box-simple">
                  <div class="icon-outlined"><i class="fa fa-phone" style="color:white;margin-top: 30px;"></i></div>
                  <h3 class="h4">Call center</h3>
                  <p>This number is toll free if calling from Great Britain otherwise we advise you to use the electronic form of communication.</p>
                  <p><strong>+212 6 64 05 33 45</strong></p>
                </div>
              </div>
              <div class="col-md-4">
                <div class="box-simple">
                  <div class="icon-outlined"><i class="fa fa-envelope" style="color:white;margin-top: 30px;"></i></div>
                  <h3 class="h4">Electronic support</h3>
                  <p>Please feel free to write an email to us or to use our electronic ticketing system.</p>
                  <ul class="list-unstyled text-sm">
                    <li><strong><a href="mailto:">contact@esoft.com</a></strong></li>
                    <!-- <li><strong><a href="#">Ticketio</a></strong> - our ticketing support platform</li> -->
                  </ul>
                </div>
              </div>
            </div>
          </section>
		<!-- <div class="container">
			<div class="row"></div>
		</div> -->
		<div class="copyrights">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 text-center-md">
						<p>&copy; 2019. E-SOFT</p>
					</div>
					<!-- <div class="col-lg-8 text-right text-center-md">
                <p>Template design by <a href="https://bootstrapious.com/p/big-bootstrap-tutorial">Bootstrapious </a>& <a href="https://fity.cz/ostrava">Fity</a></p>
                <!-- Please do not remove the backlink to us unless you purchase the Attribution-free License at https://bootstrapious.com/donate. Thank you. -->
					<div class="col-lg-8 text-right text-center-md">
						<img src="img1/Ecommerce Plateform.png" width="45" height="55"
							alt="..." class="img-fluid">
					</div>
				</div>
			</div>
		</div>
	  </footer>
	</div>
         

    <!-- Javascript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/waypoints/lib/jquery.waypoints.min.js"> </script>
    <script src="vendor/jquery.counterup/jquery.counterup.min.js"> </script>
    <script src="vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
    <script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
    <script src="vendor/jquery.scrollto/jquery.scrollTo.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu5nZKbeK-WHQ70oqOWo-_4VmwOwKP9YQ"></script>
    <script src="js/gmaps.js"></script>
    <script src="js/gmaps.init.js"></script>
    <script src="js/front.js"></script>
  </body>
</html>