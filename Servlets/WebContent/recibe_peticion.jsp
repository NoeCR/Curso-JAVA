<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar título aquí</title>
</head>
<body>
<%

	//leyendo datos del formulario
	String ciudadFav = request.getParameter("ciudad_favorita");

	//crear la Cookie
	Cookie ciudadCK = new Cookie("agencia_viajes.ciudad_favorita", ciudadFav);
	//vida de la Cookie
	ciudadCK.setMaxAge(365*24*60*60);//valor para almacenarla un año en segundos
	//Enviar a usuario para que se guarde
	response.addCookie(ciudadCK);
%>
Cookie creada y guardada, redireccion a pagina para leerla
<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>
</body>
</html>