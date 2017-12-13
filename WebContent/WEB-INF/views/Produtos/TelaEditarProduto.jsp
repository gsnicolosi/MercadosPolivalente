<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Produto"%>

 <c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
 		<% Produto produto = (Produto) request.getAttribute("produto"); %>
	  	<span class="page-identifier">Edição do Produto <%= produto.getNome() %></span>	
	  	<form action="produtos">	
	  		<br>
	  		<input hidden name="action" value="atualizar">
		  	<p>ID: <%= produto.getIdProduto() %> <input hidden name="id" value="<%= produto.getIdProduto() %>"></p> 
		  	<p>Nome: <input type="text" placeholder="<%= produto.getNome()%>" name="nome"></p>
		  	<p>Preço: <input type="number" step="0.01" name="preco" placeholder="<%= produto.getPreco()%>"></p>
			<p>Tipo: <input type="text" placeholder="<%= produto.getTipo() %>" name="tipo"> </p>
			<button type=button onclick="window.location.href='/MercadoPolivalente/produtos'">
				<i class="fa fa-window-close-o" aria-hidden="true"></i> Cancelar
			</button>
	 		<button type=submit>
	 			<i class="fa fa-floppy-o" aria-hidden="true"></i> Atualizar
	 		</button>
 		</form>
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

