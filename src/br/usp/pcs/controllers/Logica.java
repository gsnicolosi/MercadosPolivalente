package br.usp.pcs.controllers;

import javax.servlet.http.*;

public interface Logica {
	  String executa(HttpServletRequest req, HttpServletResponse res) 
	      throws Exception;

}
