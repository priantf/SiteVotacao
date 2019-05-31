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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votaçao Concluída</title>
</head>
<body>

	<div>
	<form class="baseForm" action="Home.action" method="get">

		<p id="saida" style="color:green;"> Seu voto foi computado com sucesso</p>
		
		<button id="ok">Ok</button>

	</form>
	</div>
</body>

</html>