<%@page import="model.Eleitor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/script.js"></script>
</head>

<body>
	<button id="sair">Sair</button>
	<div>
	<% Eleitor e = (Eleitor)request.getSession().getAttribute("eleitorLogado"); 
	%>
	<p>Olá <%= e.getCategoria().toLowerCase() + " " + e.getNome() %></p>
		<nav id="menu">
		    <ul>
		        <li><a href="/SiteVotacao/ValidarVotacao.action">Votar</a></li>
		        <%if (e.getCategoria().equals("MESARIO")){ %>
		        	<li><a href="/SiteVotacao/LiberarVotacao.action">Liberar Votaçao</a></li>
		        	<%} %>
	        	<%if (e.getCategoria().equals("CHEFE")){ %>
	        	<li><a href="/SiteVotacao/LiberarVotacao.action">Liberar Votaçao</a></li>
	        	<li><a href="/SiteVotacao/Relatorio.action">Relatório de Votaçao</a></li>
	        	<%} %>
		    </ul>
		</nav>
	</div>

</body>

</html>