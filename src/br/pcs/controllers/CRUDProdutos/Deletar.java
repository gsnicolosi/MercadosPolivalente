package br.pcs.controllers.CRUDProdutos;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ProdutoDAO;
import br.usp.pcs.models.Produto;

public class Deletar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringId = req.getParameter("id");
		int id = Integer.parseInt(stringId);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		try{
			produtoDAO.remove(id);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			List<Produto> lista;

			try {
				lista = produtoDAO.getAll();
				req.setAttribute("lista", lista);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaListaProdutos.jsp";
	}

}