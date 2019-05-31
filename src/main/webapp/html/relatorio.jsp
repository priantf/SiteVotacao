<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório</title>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/script.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<button id="sair">Sair</button>
<a href="javascript:window.history.go(-1)">Voltar</a>

<% Map<String,Integer> relatorio = (HashMap)request.getSession().getAttribute("candidatos"); 
if (relatorio != null){
for (Map.Entry<String,Integer> pair : relatorio.entrySet()) { %>
	<h2> <%= "Candidato " + pair.getKey() + ": " + pair.getValue() + " Votos" %> </h2>
<%	
}}
%>

</body>
</html>