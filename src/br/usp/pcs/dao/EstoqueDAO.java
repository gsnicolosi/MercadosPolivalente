package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.Estoque;

public class EstoqueDAO {
	
	private Connection connection;
	
	public EstoqueDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Estoque> getAll() throws SQLException{
		Statement statement = null;
		List<Estoque> estoques = new ArrayList<Estoque>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Estoque");
			
			while(resultSet.next()){
				Estoque estoque = new Estoque();
				
				estoque.setIdEstoque(resultSet.getInt("IdEstoque"));
				estoque.setAreaTotal(resultSet.getInt("AreaTotal"));
				estoque.setCapacidade(resultSet.getInt("Capacidade"));
				estoque.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
				
				estoques.add(estoque);
			}
		} finally {
			statement.close();
		}
		
		return estoques;
	}
	
	public boolean create(Estoque estoque) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			int idEstoque = estoque.getIdEstoque();
			int areaTotal = estoque.getAreaTotal();
			int capacidade = estoque.getCapacidade();
			long cnpjLoja = estoque.getCnpjLoja();
			statement.executeUpdate("INSERT INTO Estoque VALUES (" + idEstoque + ", '" + capacidade + "', '" + areaTotal + "', '" + cnpjLoja +"');");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public Estoque findByPrimaryKey (int idEstoque) throws SQLException{
		Statement statement = null;
		Estoque estoque = new Estoque();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Estoque WHERE IdEstoque = " + idEstoque + ";");
			
			if (resultSet.next()){
				estoque.setIdEstoque(resultSet.getInt("IdEstoque"));
				estoque.setAreaTotal(resultSet.getInt("AreaTotal"));
				estoque.setCapacidade(resultSet.getInt("Capacidade"));
				estoque.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
			}
			else{
				estoque = null;
			}
			
		} finally {
			statement.close();
		}
		
		return estoque;
	}
	
	public boolean update (Estoque estoque) throws SQLException{
		Statement statement = null;
		String query = "UPDATE Estoque SET ";
		if (estoque.getCapacidade() != 0) {
			query = query + "Capacidade= '" + estoque.getCapacidade() + "', ";
		}
		if (estoque.getAreaTotal() != 0) {
			query = query + "AreaTotal= '" + estoque.getAreaTotal() + "', ";
		}
		query = query.substring(0, query.length()-2);
		query = query + " WHERE IdEstoque = " + estoque.getIdEstoque() + ";";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} finally {
			statement.close();
		}
		
		return true;
	}
	
	public boolean remove (int idEstoque) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate("DELETE FROM Estoque WHERE IdEstoque = " + idEstoque + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}