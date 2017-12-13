package br.usp.pcs.controllers.CRUDClientes;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.models.Cliente;

public class Gravar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringCPF = req.getParameter("cpf");
		long longCPF = Long.parseLong(stringCPF);		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		
		Cliente cliente = new Cliente();
		cliente.setCPF(longCPF);
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try{
			clienteDAO.create(cliente);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			try {
				cliente = clienteDAO.findByPrimaryKey(longCPF);
				req.setAttribute("cliente", cliente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaInfoCliente.jsp";
	}

}
