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
    <link rel="stylesheet" href="vendor2/bootstrap/css/bootstrap.min.css">
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
                <!-- Notifications dropdown-->
                <!-- <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell"></i><span class="badge badge-warning">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification d-flex justify-content-between">
                          <div class="notification-content"><i class="fa fa-envelope"></i>You have 6 new messages </div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification d-flex justify-content-between">
                          <div class="notification-content"><i class="fa fa-twitter"></i>You have 2 followers</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification d-flex justify-content-between">
                          <div class="notification-content"><i class="fa fa-upload"></i>Server Rebooted</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification d-flex justify-content-between">
                          <div class="notification-content"><i class="fa fa-twitter"></i>You have 2 followers</div>
                          <div class="notification-time"><small>10 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong> <i class="fa fa-bell"></i>view all notifications                                            </strong></a></li>
                  </ul>
                </li>-->
               <!-- Messages dropdown
                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope"></i><span class="badge badge-info">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Jason Doe</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Frank Williams</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Ashley Wood</h3><span>sent you a direct message</span><small>3 days ago at 7:58 pm - 10.06.2014</small>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong> <i class="fa fa-envelope"></i>Read all messages    </strong></a></li>
                  </ul>
                </li> --> 
                <!-- Languages dropdown    -->
                <!--  <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/DE.png" alt="English" class="mr-2"><span>German</span></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/FR.png" alt="English" class="mr-2"><span>French                                                         </span></a></li>
                  </ul>
                </li> -->
                <!-- Log out-->
                <li class="nav-item"><a href="Logout" class="nav-link logout"> <span class="d-none d-sm-inline-block">Logout</span><i class="fa fa-sign-out"></i></a></li>
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
            <li class="breadcrumb-item active">Chef de projet       </li>
          </ul>
        </div>
      </div>
      <section>
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <h1 class="h3 display">Chefs de projet          </h1>
          </header>
          <div class="row">
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header">
                  <h4>La liste des chefs de projet</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th style="text-align:center;">ID Chef de projet</th>
                          <th style="text-align:center;">Prénom</th>
                          <th style="text-align:center;">Nom</th>
                          <th style="text-align:center;">Informations</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <c:forEach items="${chefsDeProjet}" var="row" >
								  <tr style="text-align:center">
								  			<!-- <td><input type="text" style="text-align:center;" size="2" id="inputDisabledEx2" value=<c:out value="${row.getId_chef_projet()}"/> class="form-control" disabled></td> -->
								  			<td><c:out value="${row.getId_chef_projet()}"/></td>
								  			<td><c:out value="${row.getPrenomCP()}"/></td>
								  			<td><c:out value="${row.getNomCP()}"/></td>
                          					<td>
												                          <!-- Button trigger modal -->
												<button style="margin-left:5px;" type="button" class="btn btn-primary" data-toggle="modal" data-target="#i<c:out value="${row.getId_chef_projet()}"/>">
												<i class="fa fa-id-card"></i></button>
												
											
												
											
												
												<!-- Modal -->
												<div class="modal fade" id="i<c:out value="${row.getId_chef_projet()}"/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
												  aria-hidden="true">
												  <div class="modal-dialog" role="document">
												  
												    <form action="EnvoyerDemandeMaintenance" method="post" >
												    <div class="modal-content">
												    
												      <div class="modal-header">
												        <h5 class="modal-title" id="exampleModalLabel">Informations sur les chefs de projet</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
																
																
																<div class="col-sm-12">
																	<div class="form-group">
																		Email du chef de projet: <input type="text"  name="email" value=<c:out value="${row.getEmailCP()}"/> class="form-control" disabled><br>
																	</div>
																</div> 
																
																<div class="col-sm-12">
																	<div class="form-group">
																		Github du chef de projet: <input type="text"  name="github" value=<c:out value="${row.getGithubCP()}"/> class="form-control" disabled><br>
																	</div>
																</div> 
																
																<div class="col-sm-12">
																	<div class="form-group">
																		Adresse du chef de projet: <input type="text"  name="address" value=<c:out value="${row.getAdresseCP()}"/> class="form-control" disabled><br>
																	</div>
																</div> 
																
																<div class="col-sm-12">
																	<div class="form-group">
																		Téléphone du chef de projet: <input type="text"  name="tel" value=<c:out value="${row.getNum_telephoneCP()}"/> class="form-control" disabled><br>
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
					                    </td>
					                    
					    	  </tr>   
						  </c:forEach>

                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
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

  </body>
</html>