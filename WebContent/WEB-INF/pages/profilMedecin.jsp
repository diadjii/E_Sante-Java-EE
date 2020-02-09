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
<body id="content">
	<c:import url="menu_medecin.jsp"></c:import>
	<div class="container">
		<h1 id="titreEdit" class="text-center text-white">Modification
			Profil</h1>
		<div id="editProfil"
			class="row justify-content-md-center rounded mx-auto d-block">
			<div class="col col-lg-10 ">
				<img id="icon" src="images/${type }" alt="" />
				<form>
					<div class="form-group">
						<div class="row">
							<div class=" col-4 offset-md-2 form-group">
								<label for="nom">Nom</label> <input id="nom "
									class="form-control" type="text" name="nom"
									value="${medecin['nom']}" min="3" /> <span class="text-danger">
									<c:out value="${error['erreurs']['nom'] }"></c:out>
								</span>
							</div>

							<div class=" col-4 offset-md-2 form-group">
								<label>Prenom</label> <input class="form-control" type="text"
									name="prenom" value="${medecin['prenom']}" /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['prenom'] }"></c:out>
								</span>
							</div>
						</div>
						<div class="row">
							<div class="col-4 offset-md-2 form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${medecin['login']}" /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['login'] }"></c:out>
								</span>
							</div>

							<div class="col-4  offset-md-2 form-group">
								<label>Nouveau mot de passe</label> <input class="form-control"
									name="oldpassword" value="${medecin['mdp']}" hidden /> <input
									class="form-control" type="password" name="password" value=""
									placeholder="Nouveau mot de passe" /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['password'] }"></c:out>
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
								<label>Contact</label> <input class="form-control" type="tel"
									name="contact" value="${medecin['contact']}" /> <span
									class="text-danger"> <c:out
										value="${error['erreurs']['contact'] }"></c:out>
								</span>
							</div>
						</div>
						<input type="submit" id="editProfilM"
							class="btn btn-success offset-md-2" value="Modifier" />
					</div>
				</form>
			</div>
		</div>
		<div id="succesEdit" class="modal fade " tabindex="-1" role="dialog"
			aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sg">
				<div class="modal-content container">
					<h2>Modification Profil</h2>
					<p>Les modifcations de votre profil ont bien ete
						enregistr&eacutees.</p>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>