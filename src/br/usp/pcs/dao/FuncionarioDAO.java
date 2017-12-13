package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.Funcionario;

public class FuncionarioDAO {
	
	private Connection connection;
	
	public FuncionarioDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Funcionario> getAll() throws SQLException{
		Statement statement = null;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Funcionario");
			
			while(resultSet.next()){
				Funcionario funcionario = new Funcionario();
				funcionario.setRg(resultSet.getLong("RG"));
				funcionario.setNome(resultSet.getString("Nome"));
				funcionario.setDataAdmissao(resultSet.getDate("DataAdmissao"));
				funcionario.setGenero(resultSet.getString("Genero"));
				funcionario.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
				funcionarios.add(funcionario);
			}
		} finally {
			statement.close();
		}
		
		return funcionarios;
	}
	
	public boolean create(Funcionario funcionario) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			long rg = funcionario.getRg();
			String nome = funcionario.getNome();
			Date dataAdmissao = funcionario.getDataAdmissao();
			String genero = funcionario.getGenero();
			long cnpjLoja = funcionario.getCnpjLoja();
			statement.executeUpdate("INSERT INTO Funcionario VALUES (" + rg + ", '" + nome + "', '" + dataAdmissao + "', '" + genero + "', '" + cnpjLoja +"');");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public Funcionario findByPrimaryKey (long rg) throws SQLException{
		Statement statement = null;
		Funcionario funcionario = new Funcionario();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Funcionario WHERE RG = " + rg + ";");
			
			if (resultSet.next()){
				funcionario.setRg(resultSet.getLong("RG"));
				funcionario.setNome(resultSet.getString("Nome"));
				funcionario.setDataAdmissao(resultSet.getDate("DataAdmissao"));
				funcionario.setGenero(resultSet.getString("Genero"));
				funcionario.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
			}
			else{
				funcionario = null;
			}
			
		} finally {
			statement.close();
		}
		
		return funcionario;
	}
	
	public boolean update (Funcionario funcionario) throws SQLException{
		Statement statement = null;
		String query = "UPDATE Funcionario SET ";
		if (!funcionario.getNome().equals("")) {
			query = query + "Nome= '" + funcionario.getNome() + "', ";
		}
		if (!funcionario.getGenero().equals("")) {
			query = query + "Genero= '" + funcionario.getGenero() + "', ";
		}
		if (funcionario.getCnpjLoja() != 0) {
			query = query + "CNPJ_Loja= '" + funcionario.getCnpjLoja() + "', ";
		}

		query = query.substring(0, query.length()-2);
		query = query + " WHERE RG = " + funcionario.getRg() + ";";
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
			statement.executeUpdate("DELETE FROM Funcionario WHERE RG = " + rg + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}
