<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/script.js"></script>
<title>Secretaire</title>
</head>
<body>
	<nav id="menu"
		class="navbar navbar-toggleable-md navbar-light bg-faded navbar-right">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarNavDropdown"
		aria-controls="navbarNavDropdown" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class=" text-white navbar-brand" href="/E_Sante">MedicalCare</a>
	<div class="collapse navbar-collapse" id="bar">
		<ul class="navbar-nav ">
			<li class="nav-item active"><a class="nav-link text-white"
				href="accueilSecretaire">Accueil</a></li>
			<li class="nav-item active"><a class="nav-link text-white"
				href="ajoutPatient">Creer Dossier</a></li>
			<li class="nav-item "><a class="nav-link text-white"
				href="profilMedecin">Voir Profil</a></li>
			<li class="nav-item "><a id="logout" class="nav-link text-white"
				href="profilMedecin">Deconnexion</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div id="medecin_1" class="col-12 mw-100">
				<h2 id="biendocteur">Bienvenue Secretaire ${sessionScope.user.nom}</h2>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-8 offset-md-1">
			<h2 class="text-gray">Liste des Rendez-Vous</h2>
			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>N°</th>
						<th>Pr&eacutenom</th>
						<th>Nom</th>
						<th>Confirmer</th>
					</tr>
				</thead>
				<tbody>
					<form method="post">
						<c:forEach items="${listeRendezVous}" var="rv" varStatus="index">

							<tr class="tr">
								<td scope="row"><c:out value="${index.count}"></c:out> <input
									type="number" name="idPatient" value="${rv['id']}" hidden /></td>
								<td><c:out value="${rv['prenom']}" /></td>
								<td><c:out value="${rv['nom']}" /></td>
								<td><input type="checkbox" class="form-check-input"
									name="confirmRVPatient" value=${rv['id']}></td>
							</tr>
						</c:forEach>
						<div class="input-group col-12">
							<div class="input-group col-6">
								<span class="input-group-addon" id="basic-addon1">Date
									Rendez-Vous</span> <input type="date" class="form-control"
									placeholder="Date rendez-vous" name="daterv">
							</div>
							<div class="col-4 offset-md-1">
								<input id="confirmRV" type="submit" class="btn btn-success"
									value="Confirmer " />
							</div>
						</div>
					</form>
				</tbody>
			</table>
		</div>
	</div>
	<div id="succesrvs" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sg">
			<div class="modal-content container">
				<h2>Confirmation de Rendez-vous</h2>
				<p>Les rendez-vous ont bien &eacutet&eacute valid&eacutes</p>
			</div>
		</div>
	</div>
</body>
</html>