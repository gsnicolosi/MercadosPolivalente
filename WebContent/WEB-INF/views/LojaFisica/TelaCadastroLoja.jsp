<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="content">
 	<div style="margin-left: 30%; margin-right: 30%;">
	  	<span class="page-identifier">Cadastro de nova loja</span>	
	  	<form action="lojas">	
	  		<br>
	  		<input hidden name="action" value="gravar">
		  	<p>CNPJ:<input type="number"name="cnpj" required></p> 
		  	<p>Fundação: <input type="text" name="fundacao" required></p>
			<p>CEP: <input type="number" name="cep" required> </p>
			<p>Acessível a deficientes? <input type="radio" name="acessivel" value="sim">Sim <input type="radio" name="acessivel" value="nao">Não</p>
			<button type=button onclick="window.location.href='/MercadoPolivalente/lojas'">
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
