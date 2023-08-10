package com.clinica.odontosolution.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 20)
	private String cpf;
	
	@Column(length = 30)
	private String genero;
	
	@Column
	private LocalDate nascimento;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 200)
	private String endereco;
	
	
	//Teste
	public Paciente(int id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	
	
	public Paciente(int id, String nome, String cpf, String genero, String telefone, String email, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}



	public Paciente(int id, String nome, String cpf, String genero, LocalDate nascimento, String telefone, String email,
			String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public LocalDate getNascimento() {
		return nascimento;
	}



	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


 
	
	
}
