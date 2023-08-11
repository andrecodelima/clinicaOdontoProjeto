package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clinica.odontosolution.model.Medico;

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
}
