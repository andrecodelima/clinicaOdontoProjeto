package com.clinica.odontosolution.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Medico;
import com.clinica.odontosolution.services.MedicoServices;

 
@WebServlet(urlPatterns = { "/insertMedico"})
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MedicoController() {
        super();
     }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getServletPath();
		
		switch (address) {
		
		case "/insertMedico":
			newMedico(request, response);
			break;
	}

}
	protected void newMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Medico medico = new Medico(
									request.getParameter("inputNome"),
									request.getParameter("inputCpf"),
									request.getParameter("inputCrm"),
									LocalDate.parse(request.getParameter("inputData")),
									request.getParameter("inputGenero"),
									request.getParameter("inputEspecialidade"),
									request.getParameter("inputTelefone"),
									request.getParameter("inputEmail"),
									request.getParameter("inputEndereco")

								);

			if(MedicoServices.insert(medico)) {
				response.getWriter().append("Cadastrado com sucesso");
				System.out.println("Cadastrado");
			}else {
				response.getWriter().append("Falha no cadastro");
				System.out.println("Erro");

				}
	}

}
