package br.usp.pcs.models;

public class Estoque {
	private int idEstoque;
	private int capacidade;
	private int areaTotal;
	private long cnpjLoja;
	
	public Estoque () {
		super();
	}
	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(int areaTotal) {
		this.areaTotal = areaTotal;
	}
	public long getCnpjLoja() {
		return cnpjLoja;
	}
	public void setCnpjLoja(long cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}
	
}
