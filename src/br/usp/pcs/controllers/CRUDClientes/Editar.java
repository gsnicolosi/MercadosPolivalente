package br.usp.pcs.controllers.CRUDClientes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.models.Cliente;

public class Editar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringCPF = req.getParameter("cpf");
		long longCPF = Long.parseLong(stringCPF);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.findByPrimaryKey(longCPF);
		req.setAttribute("cliente", cliente);
	
		return "TelaEditarCliente.jsp";
	}

}

