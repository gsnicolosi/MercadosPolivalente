package br.pcs.controllers.CRUDProdutos;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ProdutoDAO;
import br.usp.pcs.models.Produto;

public class Atualizar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringID = req.getParameter("id");
		int id = Integer.parseInt(stringID);
		String nome = req.getParameter("nome");
		String tipo = req.getParameter("tipo");
		String strPreco = req.getParameter("preco");
		double preco = Double.parseDouble(strPreco);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		
		produto.setIdProduto(id);

		if (nome != null) {
			produto.setNome(nome);
		}
		if (tipo != null) {
			produto.setTipo(tipo);
		}
		if (strPreco != null) {
			produto.setPreco(preco);
		}
		
		try{
			produtoDAO.update(produto);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			try {
				produto = produtoDAO.findByPrimaryKey(id);
				req.setAttribute("produto", produto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaInfoProduto.jsp";
	}

}
