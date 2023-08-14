package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Exame;
import com.clinica.odontosolution.model.Paciente;
import com.clinica.odontosolution.model.Teste;
 
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
									 result.getInt("idpaciente")

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
 

}
