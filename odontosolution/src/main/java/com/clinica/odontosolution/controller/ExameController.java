package com.clinica.odontosolution.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Exame;
 import com.clinica.odontosolution.services.ExameServices;
 
 
 
@WebServlet(urlPatterns = { "/insertExame", "/deleteExame", "/updateExame"})
public class ExameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ExameController() {
        super();
     }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getServletPath();
		
		switch (address) {
		
		case "/insertExame":
			newExame(request, response);
			break;
			
		case "/deleteExame": {
			delExame(request, response);
			break;
		}
			
		case "/updateExame": {
			try {
				updateExame(request, response);
			} catch (ServletException | IOException | SQLException e) {
				 
				e.printStackTrace();
			}
			break;
		}
	}

}
	protected void newExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exame exame = new Exame(
									request.getParameter("inputNome"),
									LocalDate.parse(request.getParameter("inputData")),
									request.getParameter("inputPaciente")									 
								);

			if(ExameServices.insert(exame)) {
				response.getWriter().append("Cadastrado com sucesso");
				System.out.println("Cadastrado");
			}else {
				response.getWriter().append("Falha no cadastro");
				System.out.println("Erro");

				}
	}
	
	public void delExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ExameServices.delExame(Integer.parseInt(request.getParameter("id")))) {
			response.sendRedirect("responseSucess.jsp?resp=deletar+exame");

		}else{
			
			response.sendRedirect("responseFailed.jsp?resp=deletar+exame");

		}
	}
	
	public void updateExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 Exame exame = new Exame(
				 						Integer.parseInt(request.getParameter("id")),
				 						request.getParameter("inputNome"),
										LocalDate.parse(request.getParameter("inputData")),
										request.getParameter("inputPaciente")		
 				 						
				 					);  
		
		 if(ExameServices.updateExame(exame)) {
				response.sendRedirect("responseSucess.jsp?resp=editar+exame");
		 
		 }else {
			 
				response.sendRedirect("responseFailed.jsp?resp=editar+exame");
		 }
		 
	}

}
