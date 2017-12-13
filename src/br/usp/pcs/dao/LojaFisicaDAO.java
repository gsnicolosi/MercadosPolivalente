package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.LojaFisica;

public class LojaFisicaDAO {
	
	private Connection connection;
	
	public LojaFisicaDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<LojaFisica> getAll() throws SQLException{
		Statement statement = null;
		List<LojaFisica> lojas = new ArrayList<LojaFisica>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM LojaFisica");
			
			while(resultSet.next()){
				LojaFisica loja = new LojaFisica();
				
				loja.setCnpj(resultSet.getLong("CNPJ"));
				loja.setFundacao(resultSet.getDate("Fundacao"));
				loja.setCep(resultSet.getLong("CEP"));
				loja.setAcessivelDeficientes(resultSet.getBoolean("AcessivelDeficientes"));

				lojas.add(loja);
			}
		} finally {
			statement.close();
		}
		
		return lojas;
	}
	
	public boolean create(LojaFisica loja) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			long cnpj = loja.getCnpj();
			Date fundacao = loja.getFundacao();
			long cep = loja.getCep();
			int acessivel;
			if (loja.isAcessivelDeficientes()) {
				acessivel = 1;
			} else {
				acessivel = 0;
			}
			statement.executeUpdate("INSERT INTO LojaFisica VALUES (" + cnpj + ", '" + fundacao+ ", '" + cep+ "', '" + acessivel +"');");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public LojaFisica findByPrimaryKey (long cnpj) throws SQLException{
		Statement statement = null;
		LojaFisica loja = new LojaFisica();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM LojaFisica WHERE CNPJ = " + cnpj + ";");
			
			if (resultSet.next()){
				loja.setCnpj(resultSet.getLong("CNPJ"));
				loja.setFundacao(resultSet.getDate("Fundacao"));
				loja.setCep(resultSet.getLong("CEP"));
				loja.setAcessivelDeficientes(resultSet.getBoolean("AcessivelDeficientes"));
			}
			else{
				loja = null;
			}
			
		} finally {
			statement.close();
		}
		
		return loja;
	}
	
	public boolean update (LojaFisica loja) throws SQLException{
		// n tem oq mudar ne
		return false;
	}
	
	public boolean remove (long cnpj) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate("DELETE FROM LojaFisica WHERE CNPJ = " + cnpj + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}
