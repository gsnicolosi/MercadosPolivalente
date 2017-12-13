package src.br.usp.pcs.controllers.CRUDPedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.controllers.Logica;

public class Criar implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "TelaCadastroPedido.jsp";
	}

}

