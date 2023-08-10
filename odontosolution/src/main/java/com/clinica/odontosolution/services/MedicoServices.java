package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Medico;
import com.clinica.odontosolution.model.Paciente;

public class MedicoServices {

public static ArrayList<Medico>getMedicos(){
		
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
									 result.getString("cpf")
								 
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
