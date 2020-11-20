<%@page import="bean.ChefDeProjet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ empty sessionScope.administrateurTechnique}">
		<jsp:forward page="/acceuilClient.jsp"/>
</c:if>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="cpr" class="bean.ChefDeProjet"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Session Administrateur</title>
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
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor2/bootstrap/css/bootstrap.min.css">
     <!-- Material Design Bootstrap -->
    <link href="vendor/mdb/css/mdb.min.css" rel="stylesheet">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor2/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css2/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <!-- jQuery Circle-->
    <link rel="stylesheet" href="css2/grasp_mobile_progress_circle-1.0.0.min.css">
    <!-- Custom Scrollbar-->
    <link rel="stylesheet" href="vendor2/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css2/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css2/custom.css">
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img1/Ecommerce Plateform.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <!-- Side Navbar -->
    <nav class="side-navbar">
      <div class="side-navbar-wrapper">
        <!-- Sidebar Header    -->
        <div class="sidenav-header d-flex align-items-center justify-content-center">
          <!-- User Info-->
          <div class="sidenav-header-inner text-center"><!-- <img src="img2/avatar-7.jpg" alt="person" class="img-fluid rounded-circle"> -->
          	
            <h6 class="h6">Admin Technique : <%= session.getAttribute("id") %></h6><span></span>
          </div>
          <!-- Small Brand information, appears on minimized sidebar-->
          <div class="sidenav-header-logo"><a href="index.html" class="brand-small text-center"> <strong>B</strong><strong class="text-primary">D</strong></a></div>
        </div>
        <!-- Sidebar Navigation Menus-->
       <div class="main-menu">
          <h5 class="sidenav-heading">Main</h5>
          <ul id="side-main-menu" class="side-menu list-unstyled">
          	<li><a href="acceuilAdminTechnique.jsp" aria-expanded="false"> <i class="icon-interface-windows"></i>Acceuil  </a>
            </li>
          	<li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Demandes  </a>
              <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                <li><a href="DemandeAdapteeServlet">Demande Adaptee</a></li>
                <li><a href="DemandeMaintenanceServlet">Demande de Maintenance</a></li>
              </ul>
            </li>        
                    
            <li><a href="ChefDeProjetServlet"> <i class="icon-form"></i>Chefs de projet                              </a></li>
             <li><a href="#exampledropdown1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Produits  </a>
              <ul id="exampledropdown1" class="collapse list-unstyled ">
                <li><a href="ajouterLogiciel.jsp">Ajouter un nouveau produit</a></li>
                <li><a href="AjouterLogicielServlet">Liste des logiciels</a></li>
              </ul>
            </li> 
            <li><a href="ListeCommandes"> <i class="icon-form"></i>Commandes                              </a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="page">
      <!-- navbar-->
      <header class="header">
        <nav class="navbar">
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <div class="navbar-header"><a id="toggle-btn" href="#" class="menu-btn"><i class="icon-bars"> </i></a><a href="index.html" class="navbar-brand">
                  <div class="brand-text d-none d-md-inline-block"><img src="img1/Ecommerce Plateform.png"
						style="border-radius: 16px; margin-top: 5px;" alt="" width="100"
						height="60"></div></a></div>
                  
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Log out-->
                <li class="nav-item"><a href="login.jsp" class="nav-link logout"> <span class="d-none d-sm-inline-block">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <!-- Breadcrumb-->
      <div class="breadcrumb-holder">
        <div class="container-fluid">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
            <li class="breadcrumb-item active">Softwares       </li>
          </ul>
        </div>
      </div>
      <section>
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <h1 class="h3 display">La liste des logiciels           </h1>
          </header>
          <div class="row">
					<c:forEach items="${produits}" var="row" >
						<div class="card border-primary mr-4" style="width: 15rem;">
						  <img class="card-img-top" src="ViewImageSoft?id=${row.getId_produit()}" alt="Card image cap">
						  <div class="card-body">
						  	<ul class="list-group">
							  <li class="list-group-item" style="font-weight: bold;text-align:center"><c:out value="${row.getNom()}"/></li>
							  
							  <li  style="list-style-type: none;text-align:center"><!-- Button trigger modal -->
							  		<button style="margin-left:5px;" type="button" class="btn btn-primary" data-toggle="modal" data-target="#i<c:out value="${row.getId_produit()}"/>">
												Description
									</button>
									<div class="modal fade" id="i<c:out value="${row.getId_produit()}"/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
																		<textarea id="description" style="width: 420px;height: 300px;" type="text" name="description" class="form-control"><c:out value="${row.getDescription()}"/></textarea>
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
							  <li class="list-group-item" style="font-weight: bold;text-align:center">Prix : <c:out value="${row.getPrix()}"/> USD</li>
							  <li class="list-group-item" style="font-weight: bold;text-align:center"><a style="color:green" type="file" name="file" class="form-control" href="downloadAttachment2?id=${row.getId_produit()}">Télécharger</a></li>
							</ul>
						  </div>
						</div>
					</c:forEach>
				</div>
        </div>
      </section>
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>E-SOFT &copy; 2019</p>
            </div>
            <div class="col-sm-6 text-right">
              <!-- <p>Design by <a href="https://bootstrapious.com/p/bootstrap-4-dashboard" class="external">Bootstrapious</a></p> -->
              <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions and it helps me to run Bootstrapious. Thank you for understanding :)-->
            </div>
          </div>
        </div>
      </footer>
    </div>
    <!-- JavaScript files-->
    <script src="vendor2/jquery/jquery.min.js"></script>
    <script src="vendor2/popper.js/umd/popper.min.js"> </script>
    <script src="vendor2/bootstrap/js/bootstrap.min.js"></script>
    <script src="js2/grasp_mobile_progress_circle-1.0.0.min.js"></script>
    <script src="vendor2/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor2/chart.js/Chart.min.js"></script>
    <script src="vendor2/jquery-validation/jquery.validate.min.js"></script>
    <script src="vendor2/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- Main File-->
    <script src="js2/front.js"></script>
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