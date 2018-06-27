<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Productos</title>
<style type="text/css">
table{
	float: left;
}	
#contenedorBoton{
	floar: right;
	margin-left: 10px;
}
</style>
</head>
<body>

</body>
	<table>
		<tr>
			<th>Código Artículo</th>
			<th>Sección</th>
			<th>Nombre Artículo</th>
			<th>Precio</th>
			<th>Fecha</th>			
			<th>Importado</th>
			<th>País de Origen</th>	
			<th>Acción</th>	
		</tr>	
		<c:forEach var="p" items="${ListaProdcutos}">
		<!-- Link para actualizar registros -->
		<c:url var="linkArt" value="ControladorProductos">		
			<c:param name="instruccion" value="cargar"></c:param>
			<c:param name="CArticulo" value="${p.codart}"></c:param>		
		</c:url>
		<!-- Link para borrar registros -->
		<c:url var="linkDel" value="ControladorProductos">		
			<c:param name="instruccion" value="eliminar"></c:param>
			<c:param name="CArticulo" value="${p.codart}"></c:param>		
		</c:url>
		<tr>
			<td>${p.codart }</td>
			<td>${p.section }</td>
			<td>${p.nomart }</td>
			<td>${p.precio }</td>
			<td>${p.fecha }</td>
			<td>${p.importado }</td>
			<td>${p.porig }</td>	
			<td><a href="${linkArt}">Modificar</a> &nbsp;&nbsp; <a href="${linkDel}">Eliminar</a> </td>				
		</tr>
	</c:forEach>		
	</table>
	<div id="contenedorBoton">
		<input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'" />
	</div>
</html>