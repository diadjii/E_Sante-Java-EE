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
<body id="contentAdd">
	<c:import url="menu_admin.jsp"></c:import>
	<div class="container">
		<h1 id="titreEdit" class="text-center text-white">Ajout
			Medecin/Secretaire</h1>
		<div id="editProfil"
			class="col-lg-10 justify-content-md-center rounded mx-auto d-block">
			<img id="iconMedecin" src="images/doctor.png" alt="" />
			<div class="row">
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
				<form method="post" action="ajoutPersonnel">
					<div class="form-group">
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Utilisateur</label>
								<div class="form-check ">
									<input type="radio" name="user" id="inlineRadio1" checked
										value="secretaire"> <label for="inlineRadio1">Secretaire</label>
										<input type="radio" name="user" id="inlineRadio2"
										value="medecin"> <label for="inlineRadio2">Medecin</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class=" col-4 offset-md-2 form-group">
								<label for="nom">Nom</label> <input id="nom "
									class="form-control" type="text" name="nom"
									value="${patient['nom']}" required />
							</div>

							<div class=" col-4 offset-md-2 form-group">
								<label>Prenom</label> <input class="form-control" type="text"
									name="prenom" value="${patient['prenom']}" required />
							</div>
						</div>
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${patient['login']}" required />
							</div>

							<div class="col-4 offset-md-2 form-group">
								<label>Mot de Passe</label> <input class="form-control"
									type="password" name="password" value="" required />
							</div>
						</div>
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Contact</label> <input class="form-control" type="text"
									name="contact" value="${patient['contact']}" required />
							</div>

							<div class="col-4 offset-md-2 form-group">
								<label>Specialit&eacute</label> <select name="service" required>
									<option selected>Selectionnez une Specialite</option>
									<c:forEach items="${specialites}" var="specialite">
										<option value="${specialite['id'] }">${specialite['libelle']}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<input type="submit" class="col-3 offset-md-6 btn btn-primary"
							value="Ajouter" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>