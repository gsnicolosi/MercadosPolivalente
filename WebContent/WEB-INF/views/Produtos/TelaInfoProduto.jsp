<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Produto"%>

 <c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
 		<% Produto produto = (Produto) request.getAttribute("produto"); %>
	  	<span class="page-identifier">Informações sobre <%= produto.getNome() %></span>		
	  	<p>Tipo: <%= produto.getTipo() %> </p>
	  	<p>Preço: R$<%= produto.getPreco() %>0 </p>
		<button type=button onclick="window.location.href='/MercadoPolivalente/produtos'"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> Voltar</button>
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

