package com.clinica.odontosolution.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {
	@Id
	@GeneratedValue
	private int id;	
	
	@Column(length = 100)
	private String nome;
	
	@Column
	private LocalDate data;
	

	public Teste(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

	public Teste(int id, String nome, LocalDate data) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
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


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
}
