<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar t�tulo aqu�</title>
</head>
<body>
	<form id="CArt" method="get" action="ControladorProductos">
	<input type="hidden" name="instruccion" value="insertarBBDD">
	<table width="592" border="1">
  <tbody>
    <tr>
      <td width="216">C�digo Art�culo</td>
      <td width="360"><text>
        <input name="CArt" type="text" id="CArt" placeholder="C�digo Articulo" /></td>
    </tr>
    <tr>
      <td>Secci�n</td>
      <td><input name="Seccion" type="text" id="Seccion" placeholder="Secci�n" /></td>
    </tr>
    <tr>
      <td>Nombre Articulo</td>
      <td><input name="nomArt" type="text" id="nomArt" placeholder="nombre Articulo" /></td>
    </tr>
    <tr>
      <td>Fecha</td>
      <td><input name="fecha" type="date" id="fecha" placeholder="fecha" /></td>
    </tr>
    <tr>
      <td>Precio</td>
      <td><input name="precio" type="text" id="precio" placeholder="Precio" /></td>
    </tr>
    <tr>
      <td>Importado</td>
      <td><input name="importado" type="text" id="importado" placeholder="Impostado" /></td>
    </tr>
    <tr>
      <td>Pa�s de Origen</td>
      <td><input name="porg" type="text" id="porg" placeholder="pa�s de Origen" /></td>
    </tr>
    <tr>
      <td><button type="submit" name="envio" id="envio" value="Enviar">Enviar</button></td>
      <td><button type="reset" name="borrar" id="borrar" value="Restablecer">Restablecer</button></td>
    </tr>
  </tbody>
</table>
</form>
</body>
</html>