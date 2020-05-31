package com.tomaz.ponto.inteligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.tomaz.ponto.inteligente.api.enums.PerfilEnum;

@Entity
public class Funcionario implements Serializable{
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHora;
	private float qtdHorasTrabalhadas;
	private float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empresa;
	private List<Lancamento> lancamento;
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhadas=" + qtdHorasTrabalhadas + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", empresa=" + empresa + ", lancamento=" + lancamento + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public BigDecimal getValorHora() {
		return valorHora;
	}
	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}
	public float getQtdHorasTrabalhadas() {
		return qtdHorasTrabalhadas;
	}
	public void setQtdHorasTrabalhadas(float qtdHorasTrabalhadas) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
	}
	public float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}
	public void setQtdHorasAlmoco(float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Lancamento> getLancamento() {
		return lancamento;
	}
	public void setLancamento(List<Lancamento> lancamento) {
		this.lancamento = lancamento;
	}
	

}
