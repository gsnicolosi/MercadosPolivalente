package br.usp.pcs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.dao.PedidoDAO;
import br.usp.pcs.models.Pedido;

/**
 * Servlet implementation class ControllerServlet
 */

@WebServlet("/pedidos")
public class ControllerCRUDPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String parametro = request.getParameter("action");
    
    if(parametro == null) {
    	PedidoDAO pedidoDAO = new PedidoDAO();

		List<Pedido> listaDePedidos;

		try {
			listaDePedidos = PedidoDAO.getAll();
			request.setAttribute("lista", listaDePedidos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	request.getRequestDispatcher("/WEB-INF/views/CadastrarPedido/TelaListaPedidos.jsp").forward(request, response);
    }
	else {
		String capitalizado = parametro.substring(0, 1).toUpperCase() + parametro.substring(1);
		String nomeDaClasse = "br.usp.pcs.controllers.CRUDPedidos." + capitalizado;
		
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Logica logica = (Logica) classe.newInstance();
	
	      // Recebe o String ap�s a execu��o da l�gica
	      String pagina = "/WEB-INF/views/CadastrarPedido/";
	      pagina += logica.executa(request, response);
	
	      // Faz o forward para a p�gina JSP
	      request.getRequestDispatcher(pagina).forward(request, response);
	
	    } catch (Exception e) {
	      throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
	    }
	}
  }
}
