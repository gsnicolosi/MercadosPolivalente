<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Pedido"%>
<%@ page import="java.util.List"%>

 <c:set var="content">
 	<div style="margin-left: 20%; margin-right: 10%;">
	  	<span class="page-identifier">Lista de Pedidos cadastrados</span>
		<% List<Pedido> pedidos = (List<Pedido>) request.getAttribute("lista"); %>
		<% if (pedidos != null){ %>
			<table>
				<tr><td>Id</td><td>Data</td><td>Preco</td><td>Operações</tr>
					<% for(Pedido pedido : pedidos) { %>
					<tr>
						<td>
							<a href="pedidos?action=visualizar&id=<%= pedido.getIdPedido() %>">
								<%= pedido.getIdPedido() %>
							</a>
						</td>
						<td>
							<%= pedido.getData() %>
						</td>
						<td> 
							<%= pedido.getPreco() %>
						</td>
						<td>
							<button type=button onclick="window.location.href='/MercadoPolivalente/pedidos?action=visualizar&id=<%= pedido.getIdPedido() %>'"><i class="fa fa-eye" aria-hidden="true"></i>
							 Visualizar</button>
							<button type=button onclick="window.location.href='/MercadoPolivalente/pedidos?action=deletar&id=<%= pedido.getIdPedido() %>'"><i class="fa fa-trash-o" aria-hidden="true"></i>
							 Deletar</button>
						</td>
					</tr>
				<% } %>
				<tr>
					<td></td><td></td><td></td>
					<td>
						<button style="width: 66%;" "type=button onclick="window.location.href='/MercadoPolivalente/pedidos?action=criar'">
							<i class="fa fa-plus-square-o" aria-hidden="true"></i> Novo Pedido
						</button>				
					</td>
				</tr>
			</table>
		<% }
		else { %>
		<span>Não há pedidos cadastrados</span>
		<% } %>
		
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

