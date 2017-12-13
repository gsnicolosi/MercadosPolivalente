package br.usp.pcs.controllers.CRUDLojaFisica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.LojaFisicaDAO;
import br.usp.pcs.models.LojaFisica;

public class Visualizar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringCNPJ = req.getParameter("cnpj");
		long longCNPJ = Long.parseLong(stringCNPJ);
		
		LojaFisicaDAO lojaFisicaDAO = new LojaFisicaDAO();
		LojaFisica loja = lojaFisicaDAO.findByPrimaryKey(longCNPJ);
		req.setAttribute("loja", loja);
	
		return "TelaInfoLoja.jsp";
	}

}
