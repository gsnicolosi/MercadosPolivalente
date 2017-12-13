<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.LojaFisica"%>

 <c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
 		<% LojaFisica loja = (LojaFisica) request.getAttribute("loja"); %>
	  	<span class="page-identifier">Informações sobre a loja</span>		
	  	<p>CNPJ: <%= loja.getCnpj() %> </p>
		<p>Data de fundação: <%= loja.getFundacao() %> </p>
		<p>CEP: <%= loja.getCep() %> </p>
		<p>Acessível a deficientes? <% if (loja.isAcessivelDeficientes()){ %> Sim <% } else { %> Não <% } %> </p>
		<button type=button onclick="window.location.href='/MercadoPolivalente/lojas'"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> Voltar</button>
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

