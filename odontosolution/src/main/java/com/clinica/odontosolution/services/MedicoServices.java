package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Medico;
import com.clinica.odontosolution.model.Paciente;

public class MedicoServices {

	public static boolean insert(Medico medico) {

		Connection conn = Db.conect();
		LocalDate dataNascimento = medico.getNascimento();
		try {

			String sql = "INSERT INTO medicos(nome, cpf, crm, nascimento, genero, especialidade, telefone, email, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, medico.getNome());
			st.setString(2, medico.getCpf());
			st.setString(3, medico.getCrm());
			st.setObject(4, dataNascimento);
			st.setString(5, medico.getGenero());
			st.setString(6, medico.getEspecialidade());
			st.setString(7, medico.getTelefone());
			st.setString(8, medico.getEmail());
			st.setString(9, medico.getEndereco());

			st.execute();
			System.out.println("Cadastro Realizado");

			st.close();

			return true;

		} catch (Exception e) {
			System.out.println("Falha no cadastro" + e);
		}

		return false;
	}	
	
public static ArrayList<Medico>getAllMedicos(){
		
		Connection conn = Db.conect();
		
		try {
			
			String 		sql 	= "SELECT * FROM medicos";
			
			Statement 	st 		= conn.createStatement();
			ResultSet   result  = st.executeQuery(sql); 
			
			ArrayList<Medico>lista = new ArrayList<Medico>();
			
			while(result.next()) {
							lista.add(new Medico(
									 result.getInt("id"),
									 result.getString("nome"),
									 result.getString("cpf"),
									 result.getString("crm"),
									 result.getDate("nascimento").toLocalDate(),
									 result.getString("genero"),
									 result.getString("especialidade"),
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

public static boolean delMedico(int id) {
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "DELETE from medicos WHERE id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, id);
		st.execute();
		
		System.out.println("Medico deletado");
		st.close();
		
		return true;
		
	}catch (Exception e) {
		
		System.out.println(e);
		System.out.println("Falha ao deletar medico");
	}
	
	return false;
	
}

public static Medico getId(int id){
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "SELECT * FROM medicos WHERE id=" + id;
		
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		Medico medico = new Medico();
		
		while(result.next()) {
			
			medico = new Medico(result.getInt("id"),
									result.getString("nome"),
									 result.getString("cpf"),
									 result.getString("crm"),
									 result.getDate("nascimento").toLocalDate(),
									 result.getString("genero"),
									 result.getString("especialidade"),
									 result.getString("telefone"),
									 result.getString("email"),
									 result.getString("endereco")
								 );
		}
		
		Db.Disconnect(conn);
		st.close();
		return medico;
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
}


public static boolean updateMedico(Medico m) throws SQLException{
	Connection conn = Db.conect();
	LocalDate data = m.getNascimento();

	if(conn == null) {
		System.err.println("Falha na conexão");
	
	}
	
	String sql = "UPDATE medicos	"			+
				  
				 "SET nome			=	?,"		+
				 "cpf 				= 	?,"		+
				 "crm 				= 	?,"		+
				 "nascimento		=	?,"		+
				 "genero			=	?,"		+
				 "especialidade		=	?,"		+
				 "telefone			=	?,"		+
				 "email				=	?,"		+
				 "endereco			=	? "		+
				 
				 "WHERE id	=			?"		;
	
	try {
		
		PreparedStatement st	= conn.prepareStatement(sql);
		st.setString(1, m.getNome());
		st.setString(2, m.getCpf());
		st.setString(3, m.getCrm());
		st.setObject(4, data);
		st.setString(5, m.getGenero());
		st.setString(6, m.getEspecialidade());
		st.setString(7, m.getTelefone());
		st.setString(8, m.getEmail());
		st.setString(8, m.getEndereco());
		st.setInt(9, m.getId());

		
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

}
