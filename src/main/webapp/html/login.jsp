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
<title>Jutsu Eleitoral</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

<h1> Seja bem vindo ao site oficial de votaçao</h1>

	<form class="baseForm" action="Autenticador.action" method="post">
		<label class="formLabel"> Nome de Usuário: <input
			name="nomeUsuario" type="text" required
			class="formInput formTextInput">
		</label> <label class="formLabel"> Senha: <input name="senha"
			type="password" required class="formInput formTextInput">
		</label> <input type="submit" value="Entrar" class="submitButton">
	</form>

</body>
	<footer class="column">
		<img alt="" src="./img/logo.png">
	</footer>
</html>