<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar título aquí</title>
</head>
<body>
<h1 style="text-align:center">Agencia de viajes</h1>
<%
	//valor por defecto
	String ciudadFAV = "Madrid";
	
	//Lee la cookie de la peticion del navegador
	Cookie[] lasCookies = request.getCookies();
	
	//Buscar las preferencias. La ciudad favorita
	
	if(lasCookies != null){
		for(Cookie ck: lasCookies){
			if("agencia_viajes.ciudad_favorita".equals(ck.getName())){
				ciudadFAV = ck.getValue();
				break;
			}
		}
	}
%>
<h3>Vuelos a: <%=ciudadFAV%></h3>
<p>Texto de ejemplo</p>
</body>
</html>