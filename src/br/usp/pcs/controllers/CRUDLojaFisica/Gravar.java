package br.usp.pcs.controllers.CRUDLojaFisica;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;
import br.usp.pcs.dao.LojaFisicaDAO;
import br.usp.pcs.models.LojaFisica;

public class Gravar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String stringCNPJ = req.getParameter("cnpj");
		long longCNPJ = Long.parseLong(stringCNPJ);
		String stringFundacao = req.getParameter("fundacao");
		String cep = req.getParameter("cep");
		long longCep = Long.parseLong(cep);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fundacao = new Date(format.parse(stringFundacao).getTime());
		boolean acessivel = false;
		if (req.getParameter("acessivel").equals("sim")) {
			acessivel = true;
		}
		else {
			acessivel = false;
		}
		
		LojaFisica lojaFisica = new LojaFisica();
		lojaFisica.setCnpj(longCNPJ);
		lojaFisica.setFundacao(fundacao);
		lojaFisica.setCep(longCep);
		lojaFisica.setAcessivelDeficientes(acessivel);
		LojaFisicaDAO lojaFisicaDAO = new LojaFisicaDAO();
		
		try{
			lojaFisicaDAO.create(lojaFisica);
			
			req.setAttribute("fail", false);
		} 
		catch(SQLException e){
			e.printStackTrace();
			req.setAttribute("fail", true);
		} finally {

			try {
				lojaFisica = lojaFisicaDAO.findByPrimaryKey(longCNPJ);
				req.setAttribute("loja", lojaFisica);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "TelaInfoLoja.jsp";
	}

}
