package br.usp.pcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.jdbc.ConnectionFactory;
import br.usp.pcs.models.Pedido;

public class PedidoDAO {
	
	private Connection connection;
	
	public PedidoDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public List<Pedido> getAll() throws SQLException{
		Statement statement = null;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Pedido");
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				
				pedido.setIdPedido(resultSet.getInt("IdPedido"));
				pedido.setData(resultSet.getDate("Data"));
				pedido.setPreco(resultSet.getDouble("Preco"));
				pedido.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
				pedido.setRgCliente(resultSet.getLong("RG_Cliente"));

				pedidos.add(pedido);
			}
		} finally {
			statement.close();
		}
		
		return pedidos;
	}
	
	public boolean create(Pedido pedido) throws SQLException{
		Statement statement = null;
		boolean success = false;
		
		try{
			statement = connection.createStatement();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			int idPedido = pedido.getIdPedido();
			String data = formatter.format(pedido.getData());
			double preco = pedido.getPreco();
			long cnpjLoja = pedido.getCnpjLoja();
			long rgCliente = pedido.getRgCliente();
			statement.executeUpdate("INSERT INTO Pedido VALUES (" + idPedido + ", " + preco + ", " + cnpjLoja + ", " + rgCliente +");");
			success = true;
		} finally {
			statement.close();
		}
		
		return success;
	}

	public Pedido findByPrimaryKey (int idPedido) throws SQLException{
		Statement statement = null;
		Pedido pedido = new Pedido();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Pedido WHERE IdPedido = " + idPedido + ";");
			
			if (resultSet.next()){
				pedido.setIdPedido(resultSet.getInt("IdPedido"));
				pedido.setData(resultSet.getDate("Data"));
				pedido.setPreco(resultSet.getDouble("Preco"));
				pedido.setCnpjLoja(resultSet.getLong("CNPJ_Loja"));
				pedido.setRgCliente(resultSet.getLong("RG_Cliente"));
			}
			else{
				pedido = null;
			}
			
		} finally {
			statement.close();
		}
		
		return pedido;
	}
	
	public boolean update (Pedido pedido) throws SQLException{
		// tem oq mudar?
		return false;
	}
	
	public boolean remove (int idPedido) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			statement.executeUpdate("DELETE FROM Pedido WHERE IdPedido = " + idPedido + ";");
			statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} finally {
			statement.close();
		}
		
		return true;
	}
}
