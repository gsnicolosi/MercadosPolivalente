package br.usp.pcs.controllers.CRUDLojaFisica;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.LojaFisicaDAO;
import br.usp.pcs.models.LojaFisica;

public class Deletar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringCNPJ = req.getParameter("cnpj");
		long longCNPJ = Long.parseLong(stringCNPJ);
		
		LojaFisicaDAO lojaFisicaDAO = new LojaFisicaDAO();
		
		try{
			lojaFisicaDAO.remove(longCNPJ);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			List<LojaFisica> lojas;

			try {
				lojas = lojaFisicaDAO.getAll();
				req.setAttribute("lista", lojas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaListaLojas.jsp";
	}

}
