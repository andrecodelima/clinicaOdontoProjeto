package com.clinica.odontosolution.model;

import java.time.LocalDate;

import com.clinica.odontosolution.model.Paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exames")
public class Exame {
	

	@Id
	@GeneratedValue
	private int id;	
	
	@Column(length = 100)
	private String nome;
	
	@Column
	private LocalDate data;
	
//	@ManyToOne
//	@JoinColumn(name = "idpaciente")
//	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "idpaciente")
	private int idpaciente;	

	@Column(length = 100)
	private String nomePaciente;
	
	
//	private int idPaciente = paciente.getId();
	
 

	public Exame(int id, String nome, LocalDate data, int idpaciente, String nomePaciente) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.nomePaciente = nomePaciente;

	}

	

	public Exame(String nome, LocalDate data, String nomePaciente) {
		super();
		this.nome = nome;
		this.data = data;
		this.nomePaciente = nomePaciente;
	}



	public Exame(int id, String nome, LocalDate data, int idpaciente) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.idpaciente = idpaciente;
	}



	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
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


	public int getIdpaciente() {
		return idpaciente;
	}


	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

 

	 


 
	

}
