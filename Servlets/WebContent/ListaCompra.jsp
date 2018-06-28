<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*;" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar título aquí</title>
</head>
<body>
	<form action="ListaCompra.jsp" method="post" name="Formulario Compra">
		<p>Articulos a comrar:</p>
		<p>
			<label><input type="checkbox" name="articulo" value="agua" />Agua</label><br />
			<label><input type="checkbox" name="articulo" value="leche" />Leche</label><br />
			<label><input type="checkbox" name="articulo" value="pan" />Pan</label><br />
			<label><input type="checkbox" name="articulo" value="naranjas" />Naranjas</label><br />
			<label><input type="checkbox" name="articulo" value="manzanas" />Manzanas</label><br />
			<label><input type="checkbox" name="articulo" value="carne" />Carne</label><br />	
			<label><input type="checkbox" name="articulo" value="pescado" />Pescado</label><br />
		</p>
	<input type="submit" name="button" id="button" value="Enviar">
	</form> 

<h2>Carro de la compra</h2>
<ul>
<%
	List<String> listaElementos = (List<String>) session.getAttribute("misElementos");

	if(listaElementos == null){
		listaElementos = new ArrayList<String>();
		session.setAttribute("misElementos", listaElementos);
	}
	String [] elementos = request.getParameterValues("articulo");
	
	if(elementos != null){
		for(String el: elementos){
			//out.println("<li>" + el + "</li>");
			listaElementos.add(el);
		}		
	}
	for(String el: listaElementos){
		out.println("<li>" + el + "</li>");
	}
%>
</ul>
</body>
</html>