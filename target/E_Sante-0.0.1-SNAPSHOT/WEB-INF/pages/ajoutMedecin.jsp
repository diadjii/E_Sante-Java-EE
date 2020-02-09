<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

<title>Ajout d'un Medecin</title>
</head>
<body>
	<div class="">
		<nav id="menu"
			class="navbar navbar-toggleable-md navbar-light bg-faded"> <a
			id="titre" class="navbar-brand text-white " href="#">E_Sante</a>

		<div id="infoUser" class="dropdown dropdown-right">
			<span class="text-white dropdown-toggle" id="dropdownMenu2"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.user.login}</span>
			<div class=" dropdown-menu dropdown-menu-right"
				aria-labelledby="dropdownMenu2">
				<button class="dropdown-item" type="button">Action</button>
				<button class="dropdown-item" type="button">Another action</button>
				<button class="dropdown-item" type="button">Something else
					here</button>
			</div>
		</div>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6 offset-md-3	">
				<h1>Inscription Medecin</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10 offset-md-2">
				<c:if test="${info == 1}">
					<div class="col-4 alert alert-danger alert-dismissible fade show"
						role="alert">
						Ce login est dejà utilisé
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<form method="post" action="ajoutMedecin">
					<div class="form-group">
						<div class="row">
							<div class=" col-3 form-group">
								<label for="nom">Nom</label> <input id="nom "
									class="form-control" type="text" name="nom"
									value="${patient['nom']}" required />
							</div>

							<div class=" col-3 offset-md-1 form-group">
								<label>Prenom</label> <input class="form-control" type="text"
									name="prenom" value="${patient['prenom']}" required />
							</div>
						</div>
						<div class="row">
							<div class="col-3 form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${patient['login']}" required />
							</div>

							<div class="col-3  offset-md-1 form-group">
								<label>Mot de Passe</label> <input class="form-control"
									type="password" name="password" value="" required />
							</div>
						</div>
						<div class="row">
							<div class="col-3 ">
								<label>Sexe</label>
								<div class="form-check ">
									<input type="radio" name="sexe" id="inlineRadio1" checked
										value="F"> <label for="inlineRadio1">Femme</label> <input
										type="radio" name="sexe" id="inlineRadio2" value="M">
											<label for="inlineRadio2">Homme</label>
								</div>
							</div>

							<div class="col-3 offset-md-1 form-group">
								<label>Specialit&eacute</label> <select name="service" required>
									<option selected>Selectionnez une Specialite</option>
									<c:forEach items="${specialites}" var="specialite">
										<option value="${specialite['id'] }">${specialite['libelle']}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-3 form-group">
								<label>Contact</label> <input class="form-control" type="text"
									name="contact" value="${patient['contact']}" required />
							</div>
							<div class="col-3 offset-md-1 form-group">
								<label>Age</label> <input class="form-control" type="number"
									min=0 name="age" value="" required />
							</div>
						</div>
						<input type="submit" class="btn btn-primary" value="Creer" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			$(".alert").alert()
		})
	</script>
</body>
</html>