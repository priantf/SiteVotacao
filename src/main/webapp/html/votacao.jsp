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

<title>Area de Votacao</title>
<script src="/SiteVotacao/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
    $('#botao').on('click', function(){
    	$('#saida').html("Voto computado com sucesso!");
    });
});
</script>
</head>

<body>
	<a href="javascript:window.history.go(-1)">Voltar</a>
	<div class="container">
	<% Eleitor e = (Eleitor)request.getSession().getAttribute("eleitorLogado"); 
	%>
		<form class="baseForm" action="Votacao.action" method="post">
		<% if (e.getLiberado() == 1 && e.getJaVotou() == 0){ %>
			<h2>VOTE NO SEU CANDIDATO</h2>
			<div>
				<label>Digite o número do seu candidato</label> <input type="text"
					name="voto" id="voto">
			</div>
			<button id="botao">Votar</button>
			<div id='saida' style="color: green"></div>
			<%}else if (e.getJaVotou() == 1){ %>
			<p> Seu voto já foi computado! Caso ainda nao tenha votado contate o mesário!</p>
			<%} else if (e.getLiberado() == 0){ %>
			<p> Você precisa ser autorizado pelo mesário! </p>
			<%} %>
		</form>
	</div>
</body>
</html>
