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
<body>
	<%
		/* if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} */
	%>
	<div class="">
		<nav id="menu"
			class="navbar navbar-toggleable-md navbar-light bg-faded"> <a
			id="titre" class="navbar-brand text-white " href="#">E_Sante</a>

		<div id="infoUser" class="dropdown dropdown-right">
			<span class="text-white dropdown-toggle" id="dropdownMenu2"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.user.prenom}</span>
			<div class=" dropdown-menu dropdown-menu-right"
				aria-labelledby="dropdownMenu2">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a> <a
					class="dropdown-item" href="#">Something else here</a>
				<div class="dropdown-divider"></div>
				<a id="logout" class="dropdown-item" href="">Deconnexion</a>
			</div>
		</div>
		</nav>
	</div>


	<h1>Bienvenue ${sessionScope.user.login}</h1>

	<%-- <c:forEach   items="${message}" var="mes">
		<ul>
 --%>
	<%-- </ul>
	</c:forEach>--%>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" data-whatever="">Demander RV</button>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Demande de
						Rendez-Vous</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="demandeRendez_Vous">
						<div id="infoRV">
							<div class="alert alert-info" role="alert">
								<strong>Info: </strong> Veillez choisir le service où vous
								voulez faire votre consultation.
							</div>
						</div>
						<div class="form-group	">
							<label><strong>Service</strong></label> <select
								class="form-control form-control-sm" name="service" required>
								<option selected>Selectionnez un Service</option>
								<c:forEach items="${specialites}" var="specialite">
									<option value="${specialite['id'] }">${specialite['libelle']}</option>
								</c:forEach>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="demandeRV" type="button" class="btn btn-primary">Envoyer</button>
				</div>
			</div>
		</div>
	</div>
	

	<div id="succesrv" class="modal fade " tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content container">
				<h2>Demande de Rendez-vous envoyée</h2>
				<p>
					Une notification vous sera envoyée une fois le Rendez-Vous
					confirmé. <br />Merci et à trés bientot.
				</p>
			</div>
		</div>
	</div>
</body>
</html>