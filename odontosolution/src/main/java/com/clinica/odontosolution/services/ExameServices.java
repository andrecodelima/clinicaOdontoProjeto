package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Exame;
import com.clinica.odontosolution.model.Teste;
 
public class ExameServices {

	
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
