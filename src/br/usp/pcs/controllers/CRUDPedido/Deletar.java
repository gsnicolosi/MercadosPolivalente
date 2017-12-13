package src.br.usp.pcs.controllers.CRUDPedido;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.PedidoDAO;
import br.usp.pcs.models.Pedido;

public class Deletar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int idPedido = req.getParameter("id");
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		try{
			pedidoDAO.remove(idPedido);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			List<Pedido> listaDePedidos;

			try {
				listaDePedidos = PedidoDAO.getAll();
				req.setAttribute("lista", listaDePedidos);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaListaPedidos.jsp";
	}

}
