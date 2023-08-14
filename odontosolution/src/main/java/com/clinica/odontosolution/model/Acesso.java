package com.clinica.odontosolution.model;

public class Acesso {
	private int id;
	private String usuario;
	private String password;
	
	public Acesso() {
		super();
	}

	public Acesso(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public Acesso(int id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
