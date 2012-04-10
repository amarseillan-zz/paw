
<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
	</head>
	<body>
		<h1>Sistema de propiedades online</h1>
			<a href="publicationSearch">Buscar publicaciones</a>
		<c:if test="${userId != null}">
			<a href="publicationList">Mis publicaciones</a>
			<a href="logout">Salir</a>
		</c:if>
		<c:if test="${userId == null}">
			<a href="login">Login</a>
		</c:if>
		<br>
			<div class="container-fluid">
  				<div class="container">
					<%-- header --%>
 				 </div>
  				<div class="container">
 				 
