<%@ tag language="java" description="Template principal do projeto" pageEncoding="ISO-8859-1"%>
<%@attribute name="pagecontent" fragment="true" %>

<html>

<head>
	<meta charset="UTF-8">
	<title>Mercados Polivalente</title>
	<link rel="icon" type="image/gif/png" href="${pageContext.request.contextPath}/img/playStation.png">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/template.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/FontesPersonalizadas/stylesheet.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/FontAwesome/css/font-awesome.min.css">
</head>

<body>

	<div class="header">
		<a href="listagem.html" title="Página Inicial"><img src="${pageContext.request.contextPath}/img/playStation.png" alt="Logo da Empresa"></a>
		<span class="title">Mercados Polivalente</span>
	</div>

	<ul class="navbar">
	  <li> <!--Formatacao estranha para evitar espacos nas linhas-->
	   <a href="clientes" id="navbar-link-1" onclick="toggleActiveLink(1)">Gerenciar Clientes</a></li><li>
	   <a href="lojas" id="navbar-link-2" onclick="toggleActiveLink(2)">Gerenciar Lojas</a></li><li>
	   <a href="pedidos" id="navbar-link-3" onclick="toggleActiveLink(3)">Gerenciar Pedidos</a></li><li>
	   <a href="produtos" id="navbar-link-4" onclick="toggleActiveLink(4)">Gerenciar Produtos</a></li>
	</ul>

	<div class="content">
		<jsp:invoke fragment="pagecontent"/>
	</div>

	<div class="footer">
		<span>Gianlucca Stresser Nicolosi - 9345342</span><br>
		<span>Jean Canteneur - 10455215</span><br>
		<span>João Pedro Casella de Paula - 9345241</span><br><br>
		<span>PCS3623 - Banco de Dados I - 2017</span>
	</div>

</body>

<script>
function toggleActiveLink(identifier) {
	var identifierId = "navbar-link-".concat(identifier);
	var innactiveNode = document.getElementsByClassName("active");
	if(innactiveNode.length != 0) {
		innactiveNode[0].classList.remove("active"); // remove the class from the currently selected
	}
	document.getElementById(identifierId).classList.add("active"); // add the class to the newly clicked link
};

function toggleProductCheckbox(id){
	var checkbox = document.getElementById('check'+id);
	var button = document.getElementById('botao'+id);
	if (checkbox.checked == true){
		checkbox.checked = false;
		button.innerHTML = 'Adicionar ao Pedido';
	} else {
	 	checkbox.checked = true;
		button.innerHTML = 'Remover do pedido';
 	}
};

</script>

</html>