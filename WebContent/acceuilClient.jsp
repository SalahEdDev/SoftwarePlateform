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
								<a href="login.jsp" class="login-btn"><i class="fa fa-sign-in"></i><span
									class="d-none d-md-inline-block">Se connecter</span></a>
									
									<a href="registerClient.jsp" class="signup-btn"><i class="fa fa-user"></i><span class="d-none d-md-inline-block">Créer
										compte Client</span></a>
									<a href="registerChefProjet.jsp" class="signup-btn"><i class="fa fa-user"></i><span class="d-none d-md-inline-block">Créer
										compte CdP</span></a>

							</div>
							<!-- <ul class="social-custom list-inline">
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-google-plus"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-twitter"></i></a></li>
								<li class="list-inline-item"><a href="#"><i
										class="fa fa-envelope"></i></a></li>
							</ul> -->
						</div>
					</div>
				</div>
			</div>
		</div>
      <!-- Top bar end-->
      <!-- Login Modal-->
      <div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modalLabel" aria-hidden="true" class="modal fade">
        <div role="document" class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 id="login-modalLabel" class="modal-title">Customer Login</h4>
              <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body">
              <form action="customer-orders.html" method="get">
                <div class="form-group">
                  <input id="email_modal" type="text" placeholder="email" class="form-control">
                </div>
                <div class="form-group">
                  <input id="password_modal" type="password" placeholder="password" class="form-control">
                </div>
                <p class="text-center">
                  <button class="btn btn-template-outlined"><i class="fa fa-sign-in"></i> Log in</button>
                </p>
              </form>
              <p class="text-center text-muted">Not registered yet?</p>
              <p class="text-center text-muted"><a href="customer-register.html"><strong>Register now</strong></a>! It is easy and done in 1 minute and gives you access to special discounts and much more!</p>
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
				<!-- <div id="navigation" class="navbar-collapse collapse">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item dropdown active"><a
							href="javascript: void(0)" data-toggle="dropdown"
							class="dropdown-toggle">Home <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="dropdown-item"><a href="index.html"
									class="nav-link">Option 1: Default Page</a></li>
								<li class="dropdown-item"><a href="index2.html"
									class="nav-link">Option 2: Application</a></li>
								<li class="dropdown-item"><a href="index3.html"
									class="nav-link">Option 3: Startup</a></li>
								<li class="dropdown-item"><a href="index4.html"
									class="nav-link">Option 4: Agency</a></li>
							</ul></li>

					</ul>
				</div> -->
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
      <section style="background: url('img/photogrid.jpg') center center repeat; background-size: cover;" class="bar background-white relative-positioned">
        <div class="container">
          <!-- Carousel Start-->
          <div class="home-carousel">
            <div class="dark-mask mask-primary"></div>
            <div class="container">
              <div class="homepage owl-carousel">
                <div class="item">
                  <div class="row">
                    <div class="col-md-7 text-center"><img src="img/template-easy-code.png" alt="" class="img-fluid"></div>
                    <div class="col-md-5">
                      <h2>Esoft includes everything you need to successfully sell software globally.</h2>
                      <ul class="list-unstyled">
                        <li>Easy-to-use</li>
                        <li>Full-service ecommerce platform</li>
                      </ul>
                    </div>
                  </div>
                </div>
            </div>
          </div>
          <!-- Carousel End-->
        </div>
      </section>
      <section class="bar background-white">
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-desktop" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Création de logiciels</h3>
                
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-print" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Print</h3>
               
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-globe" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Marketing</h3>
                
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-lightbulb-o" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Consulting</h3>
                
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-envelope-o" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Transformation digitale</h3>
                
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-user" style="margin-top: 30px;"></i></div>
                <h3 class="h4">Expérience client</h3>
                
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="bar background-pentagon no-mb text-md-center">
        <div class="container">
          <div class="heading text-center">
            <h2>Testimonials</h2>
          </div>
          <p class="lead">We have worked with many clients and we always like to hear they come out from the cooperation happy and satisfied. Have a look what our clients said about us.</p>
          <!-- Carousel Start-->
          <ul class="owl-carousel testimonials list-unstyled equal-height">
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>Actually loving esoft. It's been a total revelation, is very user-friendly & has an excellent support hub.</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>John Marin</h5>
                      <p><h6>CEO, MarssTech</h6></p>
                    </div>
                    <div class="avatar"><img alt="" src="img/person-2.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>I am very happy with esoft. The platform is extremely user-friendly and in heavier selling cycles, it saves us significant time each week.</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>Rania Khaldi</h5>
                      <p><h6>CEO, TransTech</h6></p>
                    </div>
                    <div class="avatar"><img alt="" src="img/person-3.png" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>I want to say publicly (as I have said many times privately) the quick and thoughtful support that esoft offer their customers is GREAT.</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>Alex Morgan</h5>
                      <p><h6>CTO, JvaTech</h6></p>
                    </div>
                    <div class="avatar"><img alt="" src="img/person-4.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>I love my esoft. Easy platform to use, fantasic staff and nothing but great results!</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>John McIntyre</h5>
                      <p><h6>CTO, EnsiasTech</h6></p>
                    </div>
                    <div class="avatar"><img alt="" src="img/person-1.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
          </ul>
          <!-- Carousel End-->
        </div>
      </section>
      <section style="background: url(img/fixed-background-2.jpg) center top no-repeat; background-size: cover;" class="bar no-mb color-white text-center bg-fixed relative-positioned">
        <div class="dark-mask"></div>
        <div class="container">
          <div class="icon icon-outlined icon-lg"><i class="fa fa-file-code-o" style="margin-top: 20px;"></i></div>
          <h3 class="text-uppercase">You want to see our projects?</h3>
          <p class="lead">We have prepared for you more than 40 different projects.</p>
          
        </div>
      </section>
      <section class="bar bg-gray">
        <div class="container">
          <div class="heading text-center">
            <h2>Our Clients</h2>
          </div>
          <ul class="list-unstyled owl-carousel customers no-mb">
            <li class="item"><img src="img/customer-1.png" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/customer-2.png" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/customer-3.png" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/customer-4.png" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/customer-5.png" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/customer-6.png" alt="" class="img-fluid"></li>
          </ul>
        </div>
      </section>
     <!-- 
      <div class="get-it">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 text-center p-3">
              <h3>Do you want cool website like this one?</h3>
            </div>
            <div class="col-lg-4 text-center p-3">   <a href="#" class="btn btn-template-outlined-white">Buy this template now</a></div>
          </div>
        </div>
      </div> -->
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
    <script src="js/front.js"></script>
  </body>
</html>