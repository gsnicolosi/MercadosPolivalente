package br.usp.pcs.controllers.CRUDClientes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;

public class Criar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "TelaCadastroCliente.jsp";
	}

}

