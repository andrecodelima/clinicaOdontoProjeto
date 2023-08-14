<%@page import="java.text.DateFormat"%>
<%@ page import="java.time.LocalDate"%>

<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@page import="com.clinica.odontosolution.model.Paciente"%>
<%@page import="com.clinica.odontosolution.services.PacienteServices"%>
<%
	ArrayList<Paciente> lista = PacienteServices.getAllPacientes(); 
	String line = "";
	
	if(lista.isEmpty()){
		line = "<tr><th colspan='3'> Não há pacientes cadastrados </tr></th>";
		
	}else{
		
		for(Paciente p : lista){
			
			int id						= p.getId();
			String nome					= p.getNome();
			String cpf					= p.getCpf();
			String genero 				= p.getGenero();
			LocalDate nascimento		= p.getNascimento();
			String telefone 			= p.getTelefone();
			String email 				= p.getEmail();
			
			
			line +=	"<tr>"						+
					
					"<td class='Dados'>"		+ id				+	"</td>"		+
					"<td class='Dados'>"		+ nome				+ 	"</td>"		+
					"<td class='Dados'>"		+ cpf				+ 	"</td>"		+
					"<td class='Dados'>"		+ genero			+ 	"</td>"		+
					"<td class='Dados'>"		+ nascimento		+	"</td>"		+
					"<td class='Dados'>"		+ telefone			+ 	"</td>"		+
					"<td class='Dados'>"		+ email				+ 	"</td>"		+


					
					"<td class='table-link'><a class='btn btn-warning' href='edit_paciente.jsp?id="		 + id + "'>Editar</a></td>"  	+
					"<td class='table-link'><a class='btn btn-danger'  href='deletePaciente?id="		 + id + "'>Excluir</a></td>"  	+
					
				"</tr>";
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Paciente</title>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">


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
	width: 1285px;
	margin-left: -282px;
}

.col-md-6 {
	/* border: 2px solid red; */
	
}

form {
	border: 2px dotted #fff;
	text-align: left;
	padding: 10px;
}

.Dados {
	color: #000;
	font-weight: 600;
	border-bottom: 1px dotted #fff
}

h1 {
	color: #fff;
}

.table-link {
	width: 5%;
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

												<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Pacientes</h3>

												<section class="box-produtos">

													<h1>Lista de Pacientes</h1>
													<hr>

													<a href="cadastroProduto.html" class="btn btn-outline-info"
														title="Cadastrar novo produto">Novo</a>

													<table class="table-produtos" id="tabelaProduto">

														<thead>
															<tr>
																<th class="col-id">id</th>
																<th class="col-nome">Nome</th>
																<th class="col-cpf">CPF</th>
																<th class="col-genero">Gênero</th>
																<th class="col-nascimento">Nascimento</th>
																<th class="col-telefone">Telefone</th>
																<th class="col-email">E-mail</th>
																<th class="col-endereço">Endereço</th>


															</tr>
														</thead>


														<tbody>
															<tr>
																<th><%=line %></th>
															</tr>
														</tbody>


														<tfoot>
															<tr>
																<th colspan="5">Fim da lista</th>
															</tr>
														</tfoot>

													</table>

												</section>


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
