package br.unip.ads.pim.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Chamado {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long numChamado;
    
	@Column(nullable = false)
	private String assunto;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ChamadoStatus status;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime inicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column
	private LocalDateTime fim;
	
	@ManyToOne(fetch=FetchType.EAGER)    
    public Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)    
    public Funcionario funcionario;

	public Long getNumChamado() {
		return numChamado;
	}

	public void setNumChamado(Long numChamado) {
		this.numChamado = numChamado;
	}

	public String getTitulo() {
		return assunto;
	}

	public void setTitulo(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ChamadoStatus getStatus() {
		return status;
	}

	public void setStatus(ChamadoStatus status) {
		this.status = status;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
