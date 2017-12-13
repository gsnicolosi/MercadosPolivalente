package br.usp.pcs.models;

import java.sql.Date;

public class Funcionario {
	private long rg;
	private String nome;
	private Date dataAdmissao;
	private String genero;
	private long cnpjLoja;

	public Funcionario() {
		super();
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public long getCnpjLoja() {
		return cnpjLoja;
	}

	public void setCnpjLoja(long cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}

}
