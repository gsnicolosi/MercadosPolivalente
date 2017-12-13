package br.usp.pcs.models;

import java.sql.Date;

public class Pedido {
	private int idPedido;
	private Date data;
	private double preco;
	private long cnpjLoja;
	private long rgCliente;
	
	public Pedido() {
		super();
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getCnpjLoja() {
		return cnpjLoja;
	}

	public void setCnpjLoja(long cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}

	public long getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(long rgCliente) {
		this.rgCliente = rgCliente;
	}


}
