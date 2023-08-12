package com.clinica.odontosolution.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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




}
