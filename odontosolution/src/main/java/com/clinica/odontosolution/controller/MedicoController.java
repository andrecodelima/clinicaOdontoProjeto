package com.clinica.odontosolution.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clinica.odontosolution.model.Medico;
import com.clinica.odontosolution.model.Paciente;
import com.clinica.odontosolution.services.MedicoServices;
import com.clinica.odontosolution.services.PacienteServices;

 
@WebServlet(urlPatterns = { "/insertMedico", "/deleteMedico", "/updateMedico"})
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
			
		case "/deleteMedico":
			delMedico(request, response);
			break;
			
		case "/updateMedico":
			try {
				updateMedico(request, response);
			} catch (ServletException | IOException | SQLException e) {
				 
				e.printStackTrace();
			}
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
	
	public void delMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(MedicoServices.delMedico(Integer.parseInt(request.getParameter("id")))) {
			response.sendRedirect("responseSucess.jsp?resp=deletar+medico");

		}else{
			
			response.sendRedirect("responseFailed.jsp?resp=deletar+medico");

		}
	}
	
	public void updateMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Medico medico = new Medico(
				 						Integer.parseInt(request.getParameter("id")),
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
		
		 if(MedicoServices.updateMedico(medico)) {
				response.sendRedirect("responseSucess.jsp?resp=editar+medico");
		 
		 }else {
			 
				response.sendRedirect("responseFailed.jsp?resp=editar+medico");
		 }
		 
	}


}
