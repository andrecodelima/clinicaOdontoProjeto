package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Paciente;

public class PacienteServices {

public static ArrayList<Paciente>getPaciente(){
		
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
}
