package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Exame;
import com.clinica.odontosolution.model.Paciente;

 

public class PacienteServices {

public static boolean insert(Paciente paciente) {
		
		Connection conn = Db.conect();
		LocalDate dataNascimento = paciente.getNascimento();
		try {
			
			String sql = "INSERT INTO pacientes(nome, cpf, nascimento, genero, telefone, email, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getCpf());
			st.setObject(3, dataNascimento);
			st.setString(4, paciente.getGenero());
			st.setString(5, paciente.getTelefone());
			st.setString(6, paciente.getEmail());
			st.setString(7, paciente.getEndereco());
			
			
			st.execute();
			System.out.println("Cadastro Realizado");
			
			st.close();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);
		}
		
		return false;
	}

public static ArrayList<Paciente>getAllPacientes(){
		
		Connection conn = Db.conect();
		
		try {
			
			String 		sql 	= "SELECT * FROM pacientes";
			
			Statement 	st 		= conn.createStatement();
			ResultSet   result  = st.executeQuery(sql); 
			
			ArrayList<Paciente>lista = new ArrayList<Paciente>();
			
			while(result.next()) {
							lista.add(new Paciente(
									 result.getInt("id"),
									 result.getString("nome"),
									 result.getString("cpf"),
									 result.getString("genero"),
									 result.getDate("nascimento").toLocalDate(),
									 result.getString("telefone"),
									 result.getString("email"),
									 result.getString("endereco")	

									 )
						);
			}
			
			st.close();
			Db.Disconnect(conn);
			return lista;
			
			
		}catch (Exception e) {
			System.err.println("Erro na conexão");
			
		}
		
		return null;
	}

public static boolean delPaciente(int id) {
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "DELETE from pacientes WHERE id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, id);
		st.execute();
		
		System.out.println("Paciente deletado");
		st.close();
		
		return true;
		
	}catch (Exception e) {
		
		System.out.println(e);
		System.out.println("Falha ao deletar paciente");
	}
	
	return false;
	
}

public static Paciente getId(int id){
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "SELECT * FROM pacientes WHERE id=" + id;
		
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		Paciente paciente = new Paciente();
		
		while(result.next()) {
			
			paciente = new Paciente(result.getInt("id"),
									 result.getString("nome"),
									 result.getString("cpf"),
									 result.getString("genero"),
									 result.getDate("nascimento").toLocalDate(),
									 result.getString("telefone"),
									 result.getString("email"),
									 result.getString("endereco")
								 );
		}
		
		Db.Disconnect(conn);
		st.close();
		return paciente;
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
}

public static boolean updatePaciente(Paciente p) throws SQLException{
	Connection conn = Db.conect();
	LocalDate data = p.getNascimento();

	if(conn == null) {
		System.err.println("Falha na conexão");
	
	}
	
	String sql = "UPDATE pacientes	"			+
				  
				 "SET nome			=	?,"		+
				 "cpf 				= 	?,"		+
				 "genero			=	?,"		+
				 "nascimento		=	?,"		+
				 "telefone			=	?,"		+
				 "email				=	?,"		+
				 "endereco			=	? "		+
				 
				 "WHERE id	=	?"		;
	
	try {
		
		PreparedStatement st	= conn.prepareStatement(sql);
		st.setString(1, p.getNome());
		st.setString(2, p.getCpf());
		st.setString(3, p.getGenero());
		st.setObject(4, data);
		st.setString(5, p.getTelefone());
		st.setString(6, p.getEmail());
		st.setString(7, p.getEndereco());
		st.setInt(8, p.getId());

		
		st.execute();
		System.out.println("Exame atualizado");
		Db.Disconnect(conn);
		
		return true;
		
		
	}catch (Exception ex) {
		System.err.println(ex);
		System.err.println("Erro durante atualização");
				
		
	}
	
	Db.Disconnect(conn);
	return false;
	
	}

public static ArrayList<Paciente> getPacienteByname(String nome){
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "SELECT * FROM pacientes WHERE nome LIKE '%" + nome + "%'";
		
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		ArrayList<Paciente>lista = new ArrayList<Paciente>();
		
		while(result.next()) {
			lista.add(new Paciente(result.getInt("id"),
									result.getString("nome"),
									 result.getString("cpf"),
									 result.getString("genero"),
									 result.getDate("nascimento").toLocalDate(),
									 result.getString("telefone"),
									 result.getString("email"),
									 result.getString("endereco")
						)
					);
		}
		
		Db.Disconnect(conn);
		st.close();
		return lista;
		
		}catch (Exception e) {
			System.out.println("Erro ao consultar nome " + e);
		}
		
		return null;
	}



}
