package br.usp.pcs.controllers.CRUDClientes;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.models.Cliente;

public class Deletar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringRG = req.getParameter("rg");
		long longRG = Long.parseLong(stringRG);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try{
			clienteDAO.remove(longRG);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			List<Cliente> listaDeClientes;

			try {
				listaDeClientes = clienteDAO.getAll();
				req.setAttribute("lista", listaDeClientes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaListaClientes.jsp";
	}

}
