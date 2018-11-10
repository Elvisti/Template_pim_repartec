package br.unip.ads.pim.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	@Column
	private Long id;
	
	@Column(nullable = false)
	protected String senha;
	
	@Column(nullable = false)
	protected int cargo;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	public boolean isAtendente() {
		return this instanceof Funcionario;
	}
}
