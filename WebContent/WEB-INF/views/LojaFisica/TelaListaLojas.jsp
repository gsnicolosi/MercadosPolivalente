<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.LojaFisica"%>
<%@ page import="java.util.List"%>

 <c:set var="content">
 	<div style="margin-left: 10%; margin-right: 10%;">
	  	<span class="page-identifier">Lista de Lojas cadastradas</span>
		<% List<LojaFisica> lojas = (List<LojaFisica>) request.getAttribute("lista"); %>
		<% if (lojas != null){ %>
			<table>
				<tr><td>CNPJ</td><td>Fundação</td><td>CEP</td><td>Acessível?</td><td>Operações</tr>
					<% for(LojaFisica loja: lojas) { %>
					<tr>
						<td>
							<a href="lojas?action=visualizar&rg=<%= loja.getCnpj() %>">
								<%= loja.getCnpj() %>
							</a>
						</td>
						<td>
							<%= loja.getFundacao() %>
						</td>
						<td> 
							<%= loja.getCep() %>
						</td>
						<td>
							<% if (loja.isAcessivelDeficientes()){ %>
							Sim
							<%} else { %>
							Não
							<%} %>
						</td>
						<td>
							<button type=button onclick="window.location.href='/MercadoPolivalente/lojas?action=visualizar&cnpj=<%= loja.getCnpj() %>'"><i class="fa fa-eye" aria-hidden="true"></i>
							 Visualizar</button>
							<button type=button onclick="window.location.href='/MercadoPolivalente/lojas?action=deletar&cnpj=<%= loja.getCnpj() %>'"><i class="fa fa-trash-o" aria-hidden="true"></i>
							 Deletar</button>
						</td>
					</tr>
				<% } %>
				<tr>
					<td></td><td></td><td></td><td></td>
					<td>
						<button style="width: 66%;" "type=button onclick="window.location.href='/MercadoPolivalente/lojas?action=criar'">
							<i class="fa fa-plus-square-o" aria-hidden="true"></i> Nova Loja
						</button>				
					</td>
				</tr>
			</table>
		<% }
		else { %>
		<span>Não há lojas cadastrados</span>
		<% } %>
		
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

