package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Exame;

  
public class ExameServices {

public static boolean insert(Exame exame) {
		
		Connection conn = Db.conect();
		LocalDate data = exame.getData();
		try {
			
			String sql = "INSERT INTO exames(nome, data, nomePaciente) VALUES (?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, exame.getNome());
			st.setObject(2, data);
			st.setString(3, exame.getNomePaciente());
	 		
			st.execute();
			System.out.println("Cadastro Realizado");
			
			st.close();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);
		}
		
		return false;
	}

	
public static ArrayList<Exame>getAllExames(){
		
		Connection conn = Db.conect();
		
		try {
			
			String 		sql 	= "SELECT * FROM exames";
			
			Statement 	st 		= conn.createStatement();
			ResultSet   result  = st.executeQuery(sql); 
			
			ArrayList<Exame>lista = new ArrayList<Exame>();
			
			
			while(result.next()) {
							lista.add(new Exame(
									 result.getInt("id"),
									 result.getString("nome"),
									 result.getDate("data").toLocalDate(),
									 result.getInt("idpaciente"),
									 result.getString("nomePaciente")

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

public static boolean delExame(int id) {
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "DELETE from exames WHERE id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, id);
		st.execute();
		
		System.out.println("Exame deletado");
		st.close();
		
		return true;
		
	}catch (Exception e) {
		
		System.out.println(e);
		System.out.println("Falha ao deletar exame");
	}
	
	return false;
	
}

public static Exame getId(int id){
	
	Connection conn = Db.conect();
	
	try {
		
		String sql = "SELECT * FROM exames WHERE id=" + id;
		
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		Exame exame = new Exame();
		
		while(result.next()) {
			
			exame = new Exame(result.getInt("id"),
								 result.getString("nome"),
								 result.getDate("data").toLocalDate(),
								 result.getString("nomePaciente")
								 );
		}
		
		Db.Disconnect(conn);
		st.close();
		return exame;
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
}

public static boolean updateExame(Exame e) throws SQLException{
	Connection conn = Db.conect();
	LocalDate data = e.getData();

	if(conn == null) {
		System.err.println("Falha na conexão");
	
	}
	
	String sql = "UPDATE exames	"						+
				  
				 "SET nome			=			?,"		+
				 "data 				= 			?,"		+
				 "nomePaciente		=			? "		+
				 
				 "WHERE id			=			?"		;
	
	try {
		
		PreparedStatement st	= conn.prepareStatement(sql);
		st.setString(1, e.getNome());
		st.setObject(2, data);
		st.setString(3, e.getNomePaciente());
		st.setInt(4, e.getId());

		
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
