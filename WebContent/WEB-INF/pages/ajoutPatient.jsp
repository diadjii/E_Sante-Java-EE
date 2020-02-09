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

<title>Creation d'un Patient</title>
</head>
<body id="contentAdd">
	<c:import url="menu_medecin.jsp"></c:import>
	<div class="container">
		<h1 id="titreEdit" class="text-center text-white">Creation
			Dossier Patient</h1>
		<div id="editProfil"
			class="col-lg-10 justify-content-md-center rounded mx-auto d-block">
			<img id="iconMedecin" src="images/patient.png" alt="" />
			<div class="row">
				<c:if test="${info == 1}">
					<div
						class="col-4 offset-md-2 alert alert-danger alert-dismissible fade show"
						role="alert">
						Ce login est dejà utilisé
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<c:if test="${ok == 1}">
					<div
						class="col-4 offset-md-2 alert alert-success alert-dismissible fade show"
						role="alert">
						Le dossier du patient a bien ete cree 
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<form name="formAjout" method="post" action="ajoutPatient">
					<div class="form-group">
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label for="nom">Nom</label> <input id="nom "
									class="form-control" type="text" name="nom"
									value="${patient['nom']}" min="3" required placeholder="Nom" />
								<span class="text-danger"> <c:out
										value="${error['erreurs']['nom'] }"></c:out>
								</span>
							</div>

							<div class=" col-4 offset-md-2 form-group">
								<label>Prenom</label> <input class="form-control" type="text"
									name="prenom" value="${patient['prenom']}" required
									placeholder="prenom" /> <span class="text-danger"> <c:out
										value="${error['erreurs']['prenom'] }"></c:out>
								</span>
							</div>
						</div>
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${patient['login']}" required
									placeholder="login" /> <span class="text-danger"> <c:out
										value="${error['erreurs']['login'] }"></c:out>
								</span>
							</div>

							<div class="col-4 offset-md-2 form-group">
								<label>Mot de Passe</label> <input class="form-control"
									type="password" name="password" value="" required
									placeholder="Mot de Passe" /> <span class="text-danger">
									<c:out value="${error['erreurs']['password'] }"></c:out>
								</span>
							</div>
						</div>

						<div class="row">
							<div class="col-4 offset-md-2 ">
								<label>Sexe</label>
								<div class="form-check ">
									<input type="radio" ${sexeF} name="sexe" id="inlineRadio1"
										value="F"><label for="inlineRadio1">Femme</label> <input
										type="radio" ${sexeM} name="sexe" id="inlineRadio2" value="M"><label
											for="inlineRadio2">Homme</label>
								</div>
							</div>

							<div class="col-4 offset-md-2 form-group">
								<label>Groupe Sanguin</label> <select name="groupe" required>
									<option selected>Selectionnez un Groupe</option>
									<option value="A">Groupe A</option>
									<option value="B">Groupe B</option>
									<option value="O">Groupe O</option>
								</select> <span class="text-danger"> <c:out
										value="${error['erreurs']['groupe'] }"></c:out>
								</span>
							</div>
						</div>

						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Contact</label> <input class="form-control" type="tel"
									name="contact" value="${patient['contact']}" required
									placeholder="Contact" /> <span class="text-danger"> <c:out
										value="${error['erreurs']['contact'] }"></c:out>
								</span>
							</div>
							<div class="col-4 offset-md-2 form-group">
								<label>Age</label> <input class="form-control" type="number"
									min=0 name="age" value="${patient['age']}" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['age'] }"></c:out>
								</span>
							</div>
						</div>
						<input type="submit" id="addPatient"
							class="col-3 offset-md-6 form-group btn btn-primary"
							value="Creer" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>