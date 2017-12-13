<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Pedido"%>

 <c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
 		<% Pedido pedido = (Pedido) request.getAttribute("pedido"); %>
	  	<span class="page-identifier"><%= pedido.getIdPedido() %></span>		
	  	<p>Data: <%= pedido.getData() %> </p>
		<p>Preco: <%= pedido.getPreco() %> </p>
		<button type=button onclick="window.location.href='/MercadoPolivalente/pedidos'"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> Voltar</button>
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

