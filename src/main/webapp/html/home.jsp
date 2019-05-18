<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

</head>

<body>
	<a href="/SiteVotacao">Sair</a>
	<div>
	<% Usuario u = (Usuario)request.getAttribute("usuarioLogado"); %>
	<p>Olá usuário <%= u.getTitulo() %></p>
		<nav id="menu">
		    <ul>
		        <li><a href="votacao.html">Votar</a></li>
		        <%if (u.getCategoria().equals("MESARIO")){ %>
		        	<li><a href="liberar_votacao.html">Liberar Votaçao</a></li>
		        	<%} %>
	        	<%if (u.getCategoria().equals("CHEFE")){ %>
	        	<li><a href="liberar_votacao.html">Liberar Votaçao</a></li>
	        	<li><a href="relatorio.html">Relatório de Votaçao</a></li>
	        	<%} %>
		    </ul>
		</nav>
	</div>

</body>

</html>