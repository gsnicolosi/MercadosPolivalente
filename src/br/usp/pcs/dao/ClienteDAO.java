package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.Cliente;

public class ClienteDAO {
	
	private Connection connection;
	
	public ClienteDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Cliente> getAll() throws SQLException{
		Statement statement = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente");
			
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				
				cliente.setRg(resultSet.getLong("RG"));
				cliente.setNome(resultSet.getString("Nome"));
				cliente.setGenero(resultSet.getString("Genero"));
				
				clientes.add(cliente);
			}
		} finally {
			statement.close();
		}
		
		return clientes;
	}
	
	public boolean create(Cliente cliente) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			long rg = cliente.getRg();
			String nome = cliente.getNome();
			String genero = cliente.getGenero();
			statement.executeUpdate("INSERT INTO Cliente VALUES (" + rg + ", '" + nome + "', '" + genero +"');");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public Cliente findByPrimaryKey (long rg) throws SQLException{
		Statement statement = null;
		Cliente cliente = new Cliente();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE RG = " + rg + ";");
			
			if (resultSet.next()){
				cliente.setRg(resultSet.getLong("RG"));
				cliente.setNome(resultSet.getString("Nome"));
				cliente.setGenero(resultSet.getString("Genero"));
			}
			else{
				cliente = null;
			}
			
		} finally {
			statement.close();
		}
		
		return cliente;
	}
	
	public boolean update (Cliente cliente) throws SQLException{
		Statement statement = null;
		String query = "UPDATE Cliente SET ";
		if (!cliente.getNome().equals("")) {
			query = query + "Nome= '" + cliente.getNome() + "', ";
		}
		if (!cliente.getGenero().equals("")) {
			query = query + "Genero= '" + cliente.getGenero() + "', ";
		}
		query = query.substring(0, query.length()-2);
		query = query + " WHERE RG = " + cliente.getRg() + ";";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} finally {
			statement.close();
		}
		
		return true;
	}
	
	public boolean remove (long rg) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate("DELETE FROM Cliente WHERE RG = " + rg + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}
