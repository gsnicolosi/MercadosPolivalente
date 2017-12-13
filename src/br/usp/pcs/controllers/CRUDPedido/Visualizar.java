package src.br.usp.pcs.controllers.CRUDPedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ClienteDAO;
import br.usp.pcs.dao.PedidoDAO;
import br.usp.pcs.models.Cliente;
import br.usp.pcs.models.Pedido;

public class Visualizar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int idPedido = req.getParameter("id");
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.findByPrimaryKey(idPedido);
		req.setAttribute("pedido", pedido);
	
		return "TelaInfoPedido.jsp";
	}

}
