package com.clinica.odontosolution.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Paciente;
import com.clinica.odontosolution.services.PacienteServices;

 
@WebServlet(urlPatterns = { "/insertPaciente"})
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PacienteController() {
        super();
     }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getServletPath();
		
		switch (address) {
		
		case "/insertPaciente":
			newPaciente(request, response);
			break;

			
//		case "/deleteClient":
//			delClient(request, response);
//			break;
//			
//		case "/updateClient":
//			try {
//				updateClient(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				 
//				e.printStackTrace();
//			}
//			break;	
			
			
		}
	}

 
	protected void newPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paciente paciente = new Paciente(
											request.getParameter("inputNome"),
											request.getParameter("inputCpf"),
											request.getParameter("inputGenero"),
											LocalDate.parse(request.getParameter("inputData")),
											request.getParameter("inputTelefone"),
											request.getParameter("inputEmail"),
											request.getParameter("inputEnderco")

							);

		if(PacienteServices.insert(paciente)) {
			response.getWriter().append("Cadastrado com sucesso");
			System.out.println("Cadastrado");
		}else {
			response.getWriter().append("Falha no cadastro");
			System.out.println("Erro");


}
	}

}
