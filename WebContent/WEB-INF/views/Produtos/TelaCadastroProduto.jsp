<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
	  	<span class="page-identifier">Cadastro de novo produto</span>	
	  	<form action="produtos">	
	  		<br>
	  		<input hidden name="action" value="gravar">
		  	<p>Nome: <input type="text" name="nome" required></p>
			<p>Preço: <input type="number" step="0.01" name="preco" required> </p>
			<p>Tipo: <input type="text" name="tipo" required></p>
			<button type=button onclick="window.location.href='/MercadoPolivalente/produtos'">
				<i class="fa fa-window-close-o" aria-hidden="true"></i> Cancelar
			</button>
	 		<button type=submit>
	 			<i class="fa fa-floppy-o" aria-hidden="true"></i> Gravar
	 		</button>
 		</form>
  	</div>
</c:set>
<t:mainpage>
	<jsp:attribute name="pagecontent">
		${content}
	</jsp:attribute>
</t:mainpage>
