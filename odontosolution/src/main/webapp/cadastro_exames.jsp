<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%@page import="com.clinica.odontosolution.model.Paciente"%>
<%@page import="com.clinica.odontosolution.services.PacienteServices"%>
<%@page import="com.clinica.odontosolution.model.Exame"%>
<%@page import="com.clinica.odontosolution.services.ExameServices"%>
<% 
	ArrayList<Paciente> lista = PacienteServices.getAllPacientes();
	ArrayList<Exame> lista_ex = ExameServices.getAllExames();

	String options = "";
	String nome = "";
	int idPaciente = 0;
	int idpk = 0;


		for (Paciente p : lista) {
		    nome 		= p.getNome();
		    idPaciente	= p.getId(); // id paciente

		  for(Exame e : lista_ex){
			  idpk = e.getIdpaciente(); // chaveEstrangeira paciente
			  
			  if(idpk == idPaciente){
				  System.out.println(idPaciente + "" + nome);
				  options += "<option value=\"" + nome + "\">" + nome + "</option>";

			  }
			}
		
		  
		
		}
	
 


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dentistas</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="../img/favicon.png" rel="icon">
<link href="../img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="./static/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="./static/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link href="./static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./static/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="./static/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="./static/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="./static/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="./static/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="./static/css/style.css" rel="stylesheet">

<!-- =======================================================
    * Template Name: Medilab
    * Updated: Jul 27 2023 with Bootstrap v5.3.1
    * Template URL: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->

<style type="text/css">
.box_cadast {
	/* border: 2px solid red; */
	height: 100vh;
}

.card-body {
	flex: 1 1 auto;
	padding: var(- -bs-card-spacer-y) var(- -bs-card-spacer-x);
	color: var(- -bs-card-color);
	background-color: #618cbf;
	margin-top: -105px;
}

.col-md-6 {
	/* border: 2px solid red; */
	
}

form {
	border: 2px dotted #fff;
	text-align: left;
	padding: 10px;
}
</style>
</head>
<body>
	<!-- ======= Top Bar ======= -->
	<div id="topbar" class="d-flex align-items-center fixed-top">
		<div class="container d-flex justify-content-between">
			<div class="contact-info d-flex align-items-center">
				<i class="bi bi-envelope"></i> <a href="mailto:contact@example.com">contact@example.com</a>
				<i class="bi bi-phone"></i> +1 5589 55488 55
			</div>
			<div class="d-none d-lg-flex social-links align-items-center">
				<a href="#" class="twitter"><i class="bi bi-twitter"></i></a> <a
					href="#" class="facebook"><i class="bi bi-facebook"></i></a> <a
					href="#" class="instagram"><i class="bi bi-instagram"></i></a> <a
					href="#" class="linkedin"><i class="bi bi-linkedin"></i></i></a>
			</div>
		</div>
	</div>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top">
		<div class="container d-flex align-items-center">
			<h1 class="logo me-auto">
				<a href="home">OdontoSolutions</a>
			</h1>

			<nav id="navbar" class="navbar order-last order-lg-0">
				<ul>
					<li><a class="nav-link scrollto active" href="home">Home</a></li>
					<li><a class="nav-link scrollto" href="sobre">Sobre</a></li>
					<li><a class="nav-link scrollto" href="especialidade">Especialidades</a></li>
					<li><a class="nav-link scrollto" href="dentista">Dentistas</a></li>
					<li><a class="nav-link scrollto" href="contato">Contato</a></li>

				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->

			<a href="acesso" class="appointment-btn scrollto"><span
				class="d-none d-md-inline">Marque uma</span> Consulta</a>

		</div>
	</header>
	<!-- End Header -->
	<main id="main">
		<!-- ======= Doctors Section ======= -->
		<section id="doctors" class="doctors">
			<div class="container">
				<div class="section-title">
					<div class="section-title">
						<h2>Doctors</h2>
						<p>Magnam dolores commodi suscipit. Necessitatibus eius
							consequatur ex aliquid fuga eum quidem. Sit sint consectetur
							velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit
							suscipit alias ea. Quia fugiat sit in iste officiis commodi
							quidem hic quas.</p>
					</div>

					<!-- CADASTRO -->
					<div class='box_cadast'>
						<section class="vh-500 gradient-custom">
							<div class="container py-5 h-100">
								<div class="row justify-content-center align-items-center h-100">
									<div class="col-12 col-lg-9 col-xl-7">
										<div class="card shadow-2-strong card-registration"
											style="border-radius: 15px;">
											<div class="card-body p-4 p-md-5">

												<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Cadastro de
													Exames</h3>
												<form name="formExame" action="insertExame">

													<div class="row">
														<label>Exame</label>
														<div class="col-md-8 mb-4 d-flex align-items-center">
															<select class="select form-control-lg" id="inputNome"
																name="inputNome">
																<option value="1" disabled></option>
																<option value="Canal">Canal</option>
																<option value="Obturação">Obturação</option>
															</select>
														</div>
													</div>

													<div class="row">
														<label>Data</label>

														<div class="col-md-6 mb-4 d-flex align-items-center">
															<div class="form-outline datepicker w-100">
																<input type="text" class="form-control form-control-lg"
																	id="inputData" name="inputData" placeholder="Data">
															</div>
														</div>
													</div>

													<div class="row">
														<label>Paciente</label>

														<div class="col-md-8 mb-4 d-flex align-items-center">
															<select class="select form-control-lg "
																id="inputPaciente" name="inputPaciente">
																<option value="1" disabled>Selecione</option>
																<%=options %>
															</select>
														</div>
													</div>

													<div class="mt-4 pt-2">
														<input class="btn btn-primary btn-lg" type="submit"
															value="Cadastrar" />
													</div>

												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</section>
					</div>

				</div>
			</div>





		</section>
		<!-- End Doctors Section -->

	</main>



	<!-- ======= Footer ======= -->
	<footer id="footer">

		<div class="footer-top">
			<div class="container">
				<div class="row">

					<div class="col-lg-3 col-md-6 footer-contact">
						<h3>Medilab</h3>
						<p>
							A108 Adam Street <br> New York, NY 535022<br> United
							States <br>
							<br> <strong>Phone:</strong> +1 5589 55488 55<br> <strong>Email:</strong>
							info@example.com<br>
						</p>
					</div>

					<div class="col-lg-2 col-md-6 footer-links">
						<h4>Useful Links</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">About
									us</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Terms
									of service</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Privacy
									policy</a></li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-6 footer-links">
						<h4>Our Services</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Web
									Design</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Web
									Development</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Product
									Management</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Graphic
									Design</a></li>
						</ul>
					</div>

					<div class="col-lg-4 col-md-6 footer-newsletter">
						<h4>Join Our Newsletter</h4>
						<p>Tamen quem nulla quae legam multos aute sint culpa legam
							noster magna</p>
						<form action="" method="post">
							<input type="email" name="email"><input type="submit"
								value="Subscribe">
						</form>
					</div>

				</div>
			</div>
		</div>

		<div class="container d-md-flex py-4">

			<div class="me-md-auto text-center text-md-start">
				<div class="copyright">
					&copy; Copyright <strong><span>Medilab</span></strong>. All Rights
					Reserved
				</div>
				<div class="credits">
					<!-- All the links in the footer should remain intact. -->
					<!-- You can delete the links only if you purchased the pro version. -->
					<!-- Licensing information: https://bootstrapmade.com/license/ -->
					<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/ -->
					Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
				</div>
			</div>
			<div class="social-links text-center text-md-right pt-3 pt-md-0">
				<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
					href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
					href="#" class="instagram"><i class="bx bxl-instagram"></i></a> <a
					href="#" class="google-plus"><i class="bx bxl-skype"></i></a> <a
					href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
			</div>
		</div>
	</footer>
	<!-- End Footer -->
	<!-- SCRIPTS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script src="./static/js/js.js"></script>

</body>
</html>
