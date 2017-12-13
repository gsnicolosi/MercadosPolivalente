package br.usp.pcs.models;

import java.sql.Date;

public class LojaFisica {
	private long cnpj;
	private Date fundacao;
	private long cep;
	private boolean acessivelDeficientes;

	public LojaFisica() {
		super();
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public Date getFundacao() {
		return fundacao;
	}

	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public boolean isAcessivelDeficientes() {
		return acessivelDeficientes;
	}

	public void setAcessivelDeficientes(boolean acessivelDeficientes) {
		this.acessivelDeficientes = acessivelDeficientes;
	}

}
