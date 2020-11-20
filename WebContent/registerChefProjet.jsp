<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Register</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="vendor1/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="vendor1/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet" href="css1/fontastic.css">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- jQuery Circle-->
<link rel="stylesheet"
	href="css1/grasp_mobile_progress_circle-1.0.0.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="vendor1/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css1/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="css1/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="img1/Ecommerce Plateform.png">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div  class="page login-page">
		<div class="container">
			<div  class="form-outer text-center d-flex align-items-center">
				<div style="width
				:1500px;" class="form-inner">
					<img src="img1/Ecommerce Plateform.png"
						style="border-radius: 16px; margin-top: -20px;" alt="" width="180"
						height="210">

					<div class="logo text-uppercase" style="margin-top: 20px;">
						<strong class="text-primary">E_SOFT</strong>
					</div>
					<p style="font-size: 19px;">
						<bold>Connectez-vous avec des Chefs de projet et des Développeurs. </bold>
					</p>
					<form  action="Register" method="post" class="text-left form-validate">
						<div class="form-group-material">
							<input id="login-username" type="text" name="nom"
								required data-msg="Veuillez saisir votre nom"
								class="input-material"> <label for="login-username"
								class="label-material">Nom</label>
						</div>
						<div class="form-group-material">
							<input id="login-username" type="text" name="prenom"
								required data-msg="Veuillez saisir votre prenom"
								class="input-material"> <label for="login-username"
								class="label-material">Prénom</label>
						</div>
						<div class="form-group-material">
							<input id="login-username" type="email" name="email"
								required data-msg="Veuillez saisir votre adresse mail"
								class="input-material"> <label for="login-username"
								class="label-material">Email</label>
						</div>
						<div class="form-group-material">
							<input id="login-password" type="password" name="password"
								required data-msg="Veuillez saisir votre mot de passe"
								class="input-material"> <label for="login-password"
								class="label-material">Mot de passe</label>
						</div>
						<div class="form-group-material">
							<input id="login-username" type="text" name="github"
								required data-msg="Veuillez saisir votre numéro de cin"
								class="input-material"> <label for="login-username"
								class="label-material">Github du CdP</label>
						</div>
						<div class="form-group-material">
							<input id="login-username" type="text" name="adresse"
								required data-msg="Veuillez saisir votre adresse"
								class="input-material"> <label for="login-username"
								class="label-material">Adresse</label>
						</div>
						<div class="form-group-material">
							<input id="login-username" type="text" name="num_telephone"
								required data-msg="Veuillez saisir votre numéro de téléphone"
								class="input-material"> <label for="login-username"
								class="label-material">Numéro Téléphone</label>
						</div>
						
						<div class="form-group text-center">
							<!-- <a id="login" type="submit" value="Submit" class="btn btn-primary">Créer Compte</a> -->

							<input type="submit" value="Créer Compte" class="btn btn-primary">
							<!-- This should be submit button but I replaced it with <a> for demo purposes-->
						</div>


					</form>
					<a style="font-size: 15px;" class="forgot-pass" href="loginChefProjet.jsp">Avez-vous déjà un compte? Cliquez ici</a>
				</div>
				<div class="bg-image imgbg"></div>
				<!--<div class="copyrights text-center">
            <p>Design by <a href="https://bootstrapious.com/p/bootstrap-4-dashboard" class="external">Bootstrapious</a></p>
             Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)
          </div>-->
			</div>
		</div>
	</div>
	<!-- JavaScript files-->
	<script src="vendor1/jquery/jquery.min.js"></script>
	<script src="vendor1/popper.js/umd/popper.min.js"> </script>
	<script src="vendor1/bootstrap/js/bootstrap.min.js"></script>
	<script src="js1/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script src="vendor1/jquery.cookie/jquery.cookie.js"> </script>
	<script src="vendor1/chart.js/Chart.min.js"></script>
	<script src="vendor1/jquery-validation/jquery.validate.min.js"></script>
	<script
		src="vendor1/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- Main File-->
	<script src="js1/front1.js"></script>
	<script type="text/javascript">
	    $(document).ready(function() {
	        $("#loginForm").validate({
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                },
	                password: "required",
	            },
	             
	            messages: {
	                email: {
	                    required: "Please enter email",
	                    email: "Please enter a valid email address"
	                },
	                 
	                password: "Please enter password"
	            }
	        });
	    });
	</script>
</body>