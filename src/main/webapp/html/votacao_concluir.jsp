<%@page import="model.Eleitor"%>
<%@page import="model.Candidato"%>
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
<script src="./js/jquery-3.3.1.min.js"></script>
<script>
document.getElementById("voto").addEventListener("input", exibeInfo);
function exibeInfo() {
	  
}
</script>
</head>

<body>
	<a href="javascript:window.history.go(-1)">Voltar</a>
	<div class="container">
	<% Eleitor e = (Eleitor)request.getSession().getAttribute("eleitorLogado"); 
	Candidato c = (Candidato)request.getSession().getAttribute("candidato"); 
	%>
		<form class="baseForm" action="Votacao.action" method="post">
		<% 
		if (c != null){
		%>
		<p> <%= c.getNome() + " - " + c.getPartido() + " - " + c.getNumero()%> </p>
		<%}
		 if (e.getLiberado() == 1 && e.getJaVotou() == 0){ %>
			<h2>VOTE NO SEU CANDIDATO</h2>
			<div>
				<label>Digite o número do seu candidato</label> <input type="text"
					name="voto" id="voto" value=<%=c.getNumero()%> disabled>
			</div>
			<button id="botao">Concluir</button>
			<a id="botao" href="javascript:window.history.go(-1)"">Voltar</a>
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
