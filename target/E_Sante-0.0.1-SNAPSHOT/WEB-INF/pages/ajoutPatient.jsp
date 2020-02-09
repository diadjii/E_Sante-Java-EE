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

<title>Creation d'un Patient</title>
</head>
<body>
	<c:import url="menu_medecin.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-6 offset-md-3	">
				<h1>Cr&eacuteation Dossier Patient</h1>
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
				<form name="formAjout" method="post" action="ajoutPatient">
					<div class="form-group">
						<div class="row">
							<div class=" col-3 form-group">
								<label for="nom">Nom</label> <input id="nom "
									class="form-control" type="text" name="nom"
									value="${patient['nom']}" min="3" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['nom'] }"></c:out>
								</span>
							</div>

							<div class=" col-3 offset-md-1 form-group">
								<label>Prenom</label> <input class="form-control" type="text"
									name="prenom" value="${patient['prenom']}" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['prenom'] }"></c:out>
								</span>
							</div>
						</div>
						<div class="row">
							<div class="col-3 form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${patient['login']}" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['login'] }"></c:out>
								</span>
							</div>

							<div class="col-3  offset-md-1 form-group">
								<label>Mot de Passe</label> <input class="form-control"
									type="password" name="password" value="" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['password'] }"></c:out>
								</span>
							</div>
						</div>

						<div class="row">
							<div class="col-3 ">
								<label>Sexe</label>
								<div class="form-check ">
									<input type="radio" ${sexeF} name="sexe" id="inlineRadio1"
										value="F"><label for="inlineRadio1">Femme</label> <input
										type="radio" ${sexeM} name="sexe" id="inlineRadio2" value="M"><label
										for="inlineRadio2">Homme</label>
								</div>
							</div>

							<div class="col-3 offset-md-1 form-group">
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
							<div class="col-3 form-group">
								<label>Contact</label> <input class="form-control" type="tel"
									name="contact" value="${patient['contact']}" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['contact'] }"></c:out>
								</span>
							</div>
							<div class="col-3 offset-md-1 form-group">
								<label>Age</label> <input class="form-control" type="number"
									min=0 name="age" value="${patient['age']}" required /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['age'] }"></c:out>
								</span>
							</div>
						</div>
						<input type="submit" class="btn btn-primary" value="Creer" />
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>