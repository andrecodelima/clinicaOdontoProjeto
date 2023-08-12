package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Teste;
 
public class TesteServices {

	
public static ArrayList<Teste>getAllTestes(){
		
		Connection conn = Db.conect();
		
		try {
			
			String 		sql 	= "SELECT * FROM teste";
			
			Statement 	st 		= conn.createStatement();
			ResultSet   result  = st.executeQuery(sql); 
			
			ArrayList<Teste>lista = new ArrayList<Teste>();
			
			while(result.next()) {
							lista.add(new Teste(
									 result.getInt("id"),
									 result.getString("nome"),
									 result.getDate("data").toLocalDate()

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
