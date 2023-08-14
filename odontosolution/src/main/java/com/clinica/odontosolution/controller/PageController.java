package com.clinica.odontosolution.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/acesso","/home", "/sobre", "/contato",  "/dentistas", "/especialidades", "/cadastroUsuario", "/listaExame", "/listaMedicos", "/listaPacientes" })
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PageController() {
        super();
     }
    
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		case "/acesso":
			Acesso(request, response);
			break;
			
		case "/contato":
			Contato(request, response);
			break;
			
		case "/cadastroUsuario":
			CadastroUser(request, response);
			break;
			
		case "/dentistas":
			Dentistas(request, response);
			break;
			
			
		case "/especialidades":
			Especialidade(request, response);
			break;
			 
			
		case "/home":
			Home(request, response);
			break;
			
		case "/sobre":
			Sobre(request, response);
			break;
			
			//////////////////////////////////////////////////
			/*Area Adm*/
		case "/listaExame":
			ExameList(request, response);
			break;
		
		case "/listaMedicos":
			MedicosList(request, response);
			break;
			
		case "/listaPacientes":
			PacientesList(request, response);
			break;
	 	
			
		}

	}
	
	public void Acesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_acesso.html");
 		 
	}
    
	
    public void Contato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_contato.html");
 		 
	}
    
    public void CadastroUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_cadastro_user.html");
		 
	}
    
    public void Dentistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_dentistas.html");
 		 
	}
    
    public void Especialidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_especialidades.html");
		 
	}
    
    public void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("index.jsp");
		 
	}
  
    public void Sobre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("p_sobre.html");
 		 
	}
    
    public void ExameList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("exame.jsp");
		 
	}
  
  
    public void MedicosList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("medico.jsp");
		 
	}
    
    public void PacientesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("paciente.jsp");
		 
	}



}
