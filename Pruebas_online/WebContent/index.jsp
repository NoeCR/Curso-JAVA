<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
<link rel="stylesheet" href="./css/main.css?1.1.73">
<title>Soft-Gest</title>
</head>
<body>
<div class="container-fluid">
	<header class="main-header">
		<div class="main-header-logo">
			<img src="img/logo/logo-texto.png" alt="" class="logo" />
		</div>
		<div class="main-header-content">
			<div class="form-head-search">
				<form>
					<div class="input-group">
				        <input type="text" class="form-control" placeholder="Buscar Articulo">
				        <span class="input-group-btn">
				          <button class="btn btn-default" type="button">
				            <span class="glyphicon glyphicon-search gliph-mod"></span>
				          </button>
				        </span>
				      </div>
				</form>
			</div>
			<ul	class="ul-head-elem">
				<li class="li-head-elem">
					<a href="#" class="head-menu-link" rel="nofollow">
						<span class="head-text-menu"><b>Entra <br />o regístrate</b></span>
						<img src="./img/icons/usuario-ico.png" class="icon-menu-user" />
					</a>
				</li>
				<li class="li-head-elem">
					<a href="#" class="head-menu-link" rel="nofollow">
						<span class="head-text-menu"><b>Mi <br />Carrito</b></span>
						<img src="./img/icons/carro-ico.png" class="icon-menu-user" />
					</a>
				</li>
			</ul>
		</div>
	
	</header>

  <div class="row content">
    <div class="col-sm-3 sidenav">
      <ul class="nav-pills nav-stacked">
      	<c:forEach var="cat" items="${ListaCategorias}">
        	<li class="left-li-menu"><a class="btn  left-btn-menu"><span class="${cat.logo}"></span>${cat.nombre}</a></li>
        </c:forEach>        
      </ul><br>
      
    </div>

    <div class="col-sm-9">
		<jsp:include page="lista-producots.jsp"></jsp:include>
    </div>
  </div>
</div>



</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>