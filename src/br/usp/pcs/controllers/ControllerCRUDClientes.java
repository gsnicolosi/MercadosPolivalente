package br.usp.pcs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.models.Cliente;

/**
 * Servlet implementation class ControllerServlet
 */

@WebServlet("/clientes")
public class ControllerCRUDClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String parametro = request.getParameter("action");
    
    if(parametro == null) {
    	ClienteDAO clienteDAO = new ClienteDAO();

		List<Cliente> listaDeClientes;

		try {
			listaDeClientes = clienteDAO.getAll();
			request.setAttribute("lista", listaDeClientes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	request.getRequestDispatcher("/WEB-INF/views/CadastrarCliente/TelaListaClientes.jsp").forward(request, response);
    }
	else {
		String capitalizado = parametro.substring(0, 1).toUpperCase() + parametro.substring(1);
		String nomeDaClasse = "br.usp.pcs.controllers.CRUDClientes." + capitalizado;
		
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Logica logica = (Logica) classe.newInstance();
	
	      // Recebe o String após a execução da lógica
	      String pagina = "/WEB-INF/views/CadastrarCliente/";
	      pagina += logica.executa(request, response);
	
	      // Faz o forward para a página JSP
	      request.getRequestDispatcher(pagina).forward(request, response);
	
	    } catch (Exception e) {
	      throw new ServletException("A lógica de negócios causou uma exceção", e);
	    }
	}
  }
}
