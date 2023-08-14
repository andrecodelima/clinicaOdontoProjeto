package com.clinica.odontosolution.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Exame;
import com.clinica.odontosolution.model.Medico;
import com.clinica.odontosolution.services.ExameServices;
import com.clinica.odontosolution.services.MedicoServices;

 
@WebServlet(urlPatterns = { "/insertExame"})
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

}
