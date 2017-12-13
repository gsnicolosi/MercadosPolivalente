package src.br.usp.pcs.controllers.CRUDPedido;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.PedidoDAO;
import br.usp.pcs.models.Pedido;

public class Gravar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		double preco = req.getParameter("preco");
		
		Pedido pedido = new Pedido();
		pedido.setPreco(preco);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		try{
			PedidoDAO.create(pedido);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			try {
				List<Pedido> listaDePedidos = PedidoDAO.getAll();
				req.setAttribute("lista", listaDePedidos);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaListaPedido.jsp";
	}

}
