<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<% String resp = request.getParameter("resp"); %>
    
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
      
        <title>odontoSolutions</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
      
        <!-- Favicons -->
        <link href="static/img/favicon.png" rel="icon">
        <link href="static/img/apple-touch-icon.png" rel="apple-touch-icon">
      
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
      <!-- Vendor CSS Files -->
        <link href="static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link href="static/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="static/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="static/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="static/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="static/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="../static/css/style.css" rel="stylesheet">
        
        <!-- BS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
       
       <style type="text/css">
       		#hero{ 
       			background-color: red;
        		}
       </style>
      </head> 
      
      
<body>
<div id="topbar" class="d-flex align-items-center fixed-top">
        <div class="container d-flex justify-content-between">
          <div class="contact-info d-flex align-items-center">
            <i class="bi bi-envelope"></i> <a href="mailto:contact@example.com">odontosolutions.com.br</a>
            <i class="bi bi-phone"></i> +55 21 9 8879-8592
          </div>
          <div class="d-none d-lg-flex social-links align-items-center">
            <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></i></a>
          </div>
        </div>
      </div>		
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="home">odonto Solutions</a></h1>
       

      <nav id="navbar" class="navbar order-last order-lg-0">

        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

 
    </div>
  </header><!-- End Header -->
   <section >
    <div class="container">
    	<section>
    	
    			Falha ao <%=resp%><br>
    		 	<div class="spinner-border" role="status">
  					<span class="visually-hidden">Loading...</span>
				</div>
				
    		 		
     	</section>
 				
     </div>
  </section>
  
 			 
			
 
 


 	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>