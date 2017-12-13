package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Produto> getAll() throws SQLException{
		Statement statement = null;
		List<Produto> produtos = new ArrayList<Produto>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Produto");
			
			while(resultSet.next()){
				Produto produto = new Produto();
				
				produto.setIdProduto(resultSet.getInt("IdProduto"));
				produto.setNome(resultSet.getString("Nome"));
				produto.setTipo(resultSet.getString("Tipo"));
				produto.setPreco(resultSet.getDouble("Preco"));

				produtos.add(produto);
			}
		} finally {
			statement.close();
		}
		
		return produtos;
	}
	
	public boolean create(Produto produto) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			int idProduto = produto.getIdProduto();
			String nome = produto.getNome();
			String tipo = produto.getTipo();
			double preco = produto.getPreco();
			statement.executeUpdate("INSERT INTO Pedido VALUES (" + idProduto + ", '" + nome + ", '" + tipo + "', " + preco +");");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public Produto findByPrimaryKey (int idProduto) throws SQLException{
		Statement statement = null;
		Produto produto = new Produto();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Produto WHERE IdProduto = " + idProduto + ";");
			
			if (resultSet.next()){
				produto.setIdProduto(resultSet.getInt("IdProduto"));
				produto.setNome(resultSet.getString("Nome"));
				produto.setTipo(resultSet.getString("Tipo"));
				produto.setPreco(resultSet.getDouble("Preco"));
			}
			else{
				produto = null;
			}
			
		} finally {
			statement.close();
		}
		
		return produto;
	}
	
	public boolean update (Produto produto) throws SQLException{
		Statement statement = null;
		String query = "UPDATE Cliente SET ";
		if (!produto.getNome().equals("")) {
			query = query + "Nome= '" + produto.getNome() + "', ";
		}
		if (!produto.getTipo().equals("")) {
			query = query + "Tipo= '" + produto.getTipo() + "', ";
		}
		if (produto.getPreco() != 0.0) {
			query = query + "Preco= " + produto.getPreco() + ", ";
		}
		query = query.substring(0, query.length()-2);
		query = query + " WHERE IdPedido = " + produto.getIdProduto() + ";";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} finally {
			statement.close();
		}
		
		return true;
	}
	
	public boolean remove (int idPedido) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate("DELETE FROM Cliente WHERE IdPedido = " + idPedido + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}
