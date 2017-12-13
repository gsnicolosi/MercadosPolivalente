<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Cliente"%>

 <c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
 		<% Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
	  	<span class="page-identifier"><%= cliente.getNome() %></span>		
	  	<p>RG: <%= cliente.getRg() %> </p>
		<p>Nome: <%= cliente.getNome() %> </p>
		<p>Gênero: <%= cliente.getGenero() %> </p>
		<button type=button onclick="window.location.href='/MercadoPolivalente/clientes'"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> Voltar</button>
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

