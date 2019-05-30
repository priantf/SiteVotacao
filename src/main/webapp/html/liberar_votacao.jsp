<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liberar Votaçao</title>
</head>
<body>
<a href="/SiteVotacao">Sair</a>
	<a href="javascript:window.history.go(-1)">Voltar</a>
	<form class="baseForm" action="LiberarVotacao.action" method="post">
			<h1>Liberar a Votaçao</h1>
			<label>Digite o número de Eleitor</label>
			<input type="text" id="titulo" name="titulo">

			<button id="myBtn">Habilitar</button>
		<script>
		document.getElementById("myBtn").addEventListener("click", function() {
		  alert("Eleitor "+ document.getElementById("titulo").value+" liberado para votar!");
		});
		</script>
	</form>
</body>
</html>