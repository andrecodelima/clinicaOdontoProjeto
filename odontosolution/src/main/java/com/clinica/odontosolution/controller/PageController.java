package com.clinica.odontosolution.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/home", "/sobre", "/contato",  "/dentistas", "/especialidades"})
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PageController() {
        super();
     }
    
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		case "/home":
			Home(request, response);
			break;
			
		case "/sobre":
			Sobre(request, response);
			break;
			
		case "/contato":
			Contato(request, response);
			break;
			
			
		case "/dentistas":
			Dentistas(request, response);
			break;
			
		case "/especialidades":
			Especialidade(request, response);
			break;
		 
	 	
			
		}

	}
	
	//Home
    public void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("index.jsp");
 		 
	}
	
    public void Contato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_contato.html");
 		 
	}
    
    public void Dentistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_dentistas.html");
 		 
	}
    
    public void Sobre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_sobre.html");
 		 
	}
    public void Especialidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_especialidades.html");
 		 
	}
  
	
	
	 

}
