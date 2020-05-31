package com.tomaz.ponto.inteligente.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Empresa implements Serializable{
	
	//private static final long seriaVersionUD = 1L;

	private Long id;
	private String razaoSocia;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionarios;
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocia=" + razaoSocia + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", funcionarios=" + funcionarios + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazaoSocia() {
		return razaoSocia;
	}
	public void setRazaoSocia(String razaoSocia) {
		this.razaoSocia = razaoSocia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
}
