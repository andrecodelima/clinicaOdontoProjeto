package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.clinica.odontosolution.model.Acesso;


public class AcessoServices {

	public static boolean insert(Acesso acesso) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "INSERT INTO  acesso(usuario, password) VALUES (?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, acesso.getUsuario());
			st.setString(2, acesso.getPassword());
			
			st.execute();
     		System.out.println("Cadastro realizado");

			st.close();
			
			return true;
			
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);
		}
		
		return false;
		 
	}
	
	public static Acesso getUsuario(String user) {
		
		Connection conn = Db.conect();
		Acesso acesso = new Acesso();
		
		try {
			
			String sql = "SELECT * FROM acesso WHERE usuario = \"" + user + "\"";
			
			Statement st 		= conn.createStatement();
			ResultSet result	= st.executeQuery(sql);
			
			
			while(result.next()) {
				
				acesso = new Acesso(result.getInt("id"),
									  result.getString("usuario"),
									  result.getString("password")
						);
			}
			
		}catch (Exception e) {
			System.err.println(e);
		}
		
		return acesso;
	}
}
