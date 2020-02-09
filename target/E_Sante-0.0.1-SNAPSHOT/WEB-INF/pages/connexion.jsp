<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Connexion</title>
</head>
<body>
	<div class="">
		<nav id="menu"
			class="navbar navbar-toggleable-md navbar-light bg-faded"> <a
			id="titre" class="navbar-brand text-white " href="#">Bienvenue
			sur E_Sante</a> </nav>
	</div>
	<div id="bodyConx" class="container">
		<div class="row">
			<div class="col-6 offset-md-3	">
				<h1>Se Connecter</h1>
			</div>

			<c:if test="${info != null }">

				<span
					class=" col-4 offset-md-4 alert alert-danger alert-dismissible fade show"
					role="alert"> <c:out value="${info}"></c:out>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</span>
			</c:if>
		</div>
		<div class="row">
			<form method="post" action="connexion">
				<div class="col-4 offset-md-6">
					<div class="form-group">
						<label>Login</label> <input type="text" name="login"
							value="${login}" />
					</div>
					<div class="form-group">
						<label>Mot de Passe</label> <input type="password" name="password"
							value="" />
					</div>
					<input type="submit" value="Se Connecter" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>