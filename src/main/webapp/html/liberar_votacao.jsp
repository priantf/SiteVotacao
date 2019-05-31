<%@page import="model.Eleitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liberar Votaçao</title>
</head>
<body>
	
	<button id="sair">Sair</button>
	<a href="javascript:window.history.go(-1)">Voltar</a>
	<div>
	<% Eleitor e = (Eleitor)request.getSession().getAttribute("votacao"); 
	%>
	<form class="baseForm" action="LiberarVotacao.action" method="post">
		<h1>Liberar a Votaçao</h1>
		<label>Digite o número de Eleitor</label> <input type="text"
			id="titulo" name="titulo">

		<button id="myBtn">Habilitar</button>
		<% if (e != null){ %>
		<%if (e.getLiberado() == 1){ %>
			<p id="saida" style="color:green;"> Cidadao <%= e.getNome() + " de título " + e.getTitulo() + " está liberado para votar!" %></p>
		<% }else{%>
			<p style="color:red;"> Cidadao <%= e.getNome() + " de título " + e.getTitulo() + " está impedido de votar por alguma razao!" %></p>
		<%}}else if (request.getParameter("titulo") != null){ %>
			<p style="color:red;"> Cidadao referente a esse título nao foi encontrado</p>
		<%} %>

	</form>
	</div>
</body>

</html>