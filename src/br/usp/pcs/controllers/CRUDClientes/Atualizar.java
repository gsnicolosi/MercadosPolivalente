package br.usp.pcs.controllers.CRUDClientes;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.models.Cliente;

public class Atualizar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringRG = req.getParameter("rg");
		long longRG = Long.parseLong(stringRG);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setRg(longRG);
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		
		if (nome != null) {
			cliente.setNome(nome);
		}
		if (genero != null) {
			cliente.setGenero(genero);
		}
		
		try{
			clienteDAO.update(cliente);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			try {
				cliente = clienteDAO.findByPrimaryKey(longRG);
				req.setAttribute("cliente", cliente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaInfoCliente.jsp";
	}

}
