package br.pcs.controllers.CRUDProdutos;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.ProdutoDAO;
import br.usp.pcs.models.Produto;

public class Gravar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String tipo = req.getParameter("tipo");
		String strPreco = req.getParameter("preco");
		double preco = Double.parseDouble(strPreco);
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setTipo(tipo);
		produto.setPreco(preco);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		try{
			produtoDAO.create(produto);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

		}
		List<Produto> produtos = produtoDAO.getAll();
		req.setAttribute("lista", produtos);
		return "TelaListaProdutos.jsp";
	}

}