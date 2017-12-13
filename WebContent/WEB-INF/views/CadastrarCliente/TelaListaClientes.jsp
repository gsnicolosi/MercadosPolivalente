<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.usp.pcs.models.Cliente"%>
<%@ page import="java.util.List"%>

 <c:set var="content">
 	<div style="margin-left: 5%; margin-right: 5%;">
	  	<span class="page-identifier">Lista de clientes cadastrados</span>
		<% List<Cliente> clientes = (List<Cliente>) request.getAttribute("lista"); %>
		<% if (clientes != null){ %>
			<table>
				<tr><td>CPF</td><td>Nome</td><td>Endereço</td><td>Telefone</td><td>Operações</tr>
					<% for(Cliente cliente : clientes) { %>
					<tr>
						<td>
							<a href="clientes?action=visualizar&cpf=<%= cliente.getCPF() %>">
								<%= cliente.getCPF() %>
							</a>
						</td>
						<td>
							<%= cliente.getNome() %>
						</td>
						<td> 
							<%= cliente.getEndereco() %>
						</td>
						<td>
							<%= cliente.getTelefone() %>
						</td>
						<td>
							<button type=button onclick="window.location.href='/LojaComputadores/clientes?action=visualizar&cpf=<%= cliente.getCPF() %>'"><i class="fa fa-eye" aria-hidden="true"></i>
							 Visualizar</button>
							<button type=button onclick="window.location.href='/LojaComputadores/clientes?action=editar&cpf=<%= cliente.getCPF() %>'"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
							<button type=button onclick="window.location.href='/LojaComputadores/clientes?action=deletar&cpf=<%= cliente.getCPF() %>'"><i class="fa fa-trash-o" aria-hidden="true"></i>
							 Deletar</button>
						</td>
					</tr>
				<% } %>
				<tr>
					<td></td><td></td><td></td><td></td>
					<td>
						<button style="width: 66%;" "type=button onclick="window.location.href='/LojaComputadores/clientes?action=criar'">
							<i class="fa fa-plus-square-o" aria-hidden="true"></i> Novo Cliente
						</button>				
					</td>
				</tr>
			</table>
		<% }
		else { %>
		<span>Não há clientes cadastrados</span>
		<% } %>
		
  	</div>
  </c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>

