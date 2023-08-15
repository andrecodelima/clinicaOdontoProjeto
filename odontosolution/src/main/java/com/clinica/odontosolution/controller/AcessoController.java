package com.clinica.odontosolution.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Acesso;
import com.clinica.odontosolution.services.AcessoServices;

  
 
@WebServlet(urlPatterns = { "/insertUser", "/logar" })
public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AcessoController() {
        super();
     }

 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {

		case "/insertUser":
			NewUser(request, response);
			break;

		case "/logar":
			Logar(request, response);
			break;

		}

	}
	 
	public void NewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Acesso acesso = new Acesso(request.getParameter("inputUsuario"), request.getParameter("inputPassword"));

		if (AcessoServices.insert(acesso)) {

			response.sendRedirect("responseSucessUser.jsp?resp=usuario+cadastrado");

		} else {
			response.sendRedirect("responseFailed.jsp?resp=cadastrar+usuario");
		}

	}
	
	public void Logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("inputUsuario");
		String password = request.getParameter("inputPassword");

		Acesso usr = AcessoServices.getUsuario(usuario);

		if (usr != null) {
			if ((usr.getUsuario().equals(usuario)) && (usr.getPassword().equals(password))) {
				response.sendRedirect("area_cliente.jsp");

			}else if ((usuario != usr.getUsuario()) && (password != usr.getPassword())) {
				response.sendRedirect(request.getContextPath() + "/errors/responseFailed.jsp?resp=Usuario+ou+senha+invalido."); 
				//Caminho absoluto aplicado através do getContextPath permitindo que a pagina seja acessada independente de onde estiver

			}
			

			}

		}
		
	}

