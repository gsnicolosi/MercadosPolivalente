<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Produto"%>
<%@ page import="java.util.List"%>

 <c:set var="content">
 	<div style="margin-left: 20%; margin-right: 10%;">
	  	<span class="page-identifier">Lista de produtos cadastrados</span>
		<% List<Produto> produtos = (List<Produto>) request.getAttribute("lista"); %>
		<% if (produtos != null){ %>
			<table>
				<tr><td>ID</td><td>Nome</td><td>Preço</td><td>Tipo</td><td>Operações</tr>
					<% for(Produto produto : produtos) { %>
					<tr>
						<td>
							<a href="produtos?action=visualizar&id=<%= produto.getIdProduto() %>">
								<%= produto.getIdProduto() %>
							</a>
						</td>
						<td>
							<%= produto.getNome() %>
						</td>
						<td>
							R$<%= produto.getPreco() %>
						</td>
						
						<td> 
							<%= produto.getTipo() %>
						</td>
						<td>
							<button type=button onclick="window.location.href='/MercadoPolivalente/produtos?action=visualizar&id=<%= produto.getIdProduto() %>'"><i class="fa fa-eye" aria-hidden="true"></i>
							 Visualizar</button>
							<button type=button onclick="window.location.href='/MercadoPolivalente/produtos?action=editar&id=<%= produto.getIdProduto() %>'"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
							<button type=button onclick="window.location.href='/MercadoPolivalente/produtos?action=deletar&id=<%= produto.getIdProduto() %>'"><i class="fa fa-trash-o" aria-hidden="true"></i>
							 Deletar</button>
						</td>
					</tr>
				<% } %>
				<tr>
					<td></td><td></td><td></td><td></td>
					<td>
						<button style="width: 66%;" "type=button onclick="window.location.href='/MercadoPolivalente/produtos?action=criar'">
							<i class="fa fa-plus-square-o" aria-hidden="true"></i> Novo Produto
						</button>				
					</td>
				</tr>
			</table>
		<% }
		else { %>
		<span>Não há produtos cadastrados</span>
		<% } %>
		
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

