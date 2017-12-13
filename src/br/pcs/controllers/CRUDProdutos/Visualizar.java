package br.pcs.controllers.CRUDProdutos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ProdutoDAO;
import br.usp.pcs.models.Produto;

public class Visualizar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringID = req.getParameter("id");
		int id = Integer.parseInt(stringID);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.findByPrimaryKey(id);
		req.setAttribute("produto", produto);
	
		return "TelaInfoProduto.jsp";
	}

}
