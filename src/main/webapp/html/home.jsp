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

</head>

<body>
	<a href="/SiteVotacao">Sair</a>
	<div>
	<% Eleitor e = (Eleitor)request.getSession().getAttribute("eleitorLogado"); 
	%>
	<p>Olá <%= e.getCategoria() + e.getNome() %></p>
		<nav id="menu">
		    <ul>
		        <li><a href="/SiteVotacao/Votacao.action">Votar</a></li>
		        <%if (e.getCategoria().equals("MESARIO")){ %>
		        	<li><a href="/SiteVotacao/LiberarVotacao.action">Liberar Votaçao</a></li>
		        	<%} %>
	        	<%if (e.getCategoria().equals("CHEFE")){ %>
	        	<li><a href="/SiteVotacao/html/liberar_votacao.html">Liberar Votaçao</a></li>
	        	<li><a href="/SiteVotacao/html/relatorio.html">Relatório de Votaçao</a></li>
	        	<%} %>
		    </ul>
		</nav>
	</div>

</body>

</html>