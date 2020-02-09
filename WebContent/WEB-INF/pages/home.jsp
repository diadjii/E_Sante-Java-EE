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
<script src="js/script.js"></script>

<title>Bienvenue</title>
</head>
<body>
	<nav id="homeBar" class="navbar navbar-light center "> <img
		id="logos" width=50px src="images/stethoscope.png" />
	<h2 id="medical" class="text-center">
		<a href="/E_Sante">MedicalCare</a>
	</h2>
	<img id="logosD" width=50px src="images/doctor2.png" /> </nav>
	<div id="header" class="">
		<div id="textPresentaiton" class="text- col-6 rounded-circle">
			Bienvenue dans Medical Care ! Votre systeme hospitalier vous
			proposant des soins medicaux de tres bonne qualite. En effet , en un
			clic vous avez votre dossier medical, mais aussi en un clic vous avez
			votre Rendez-Vous. Sans oublier les medecins qui peuvent consulter
			l'histoire medicale de leur patient et la completer.<br /> <br />"
			Medical care , la santé autrement "<br />
			<div id="btnLog">
				<button id="btnL" type="button" class="btn btn-outline-primary">Se
					Connecter</button>
				<button type="button" class=" btn
				btn-outline-primary"
					data-toggle="modal" data-target="#aide">Aide</button>
			</div>
		</div>

	</div>

	<div class="modal fade" id="aide" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Aide</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>
						<strong>Medecin :</strong>Medical Care vous offre 3 options: +
						Consulter le dossier medical du patient grace au bouton consulter
						dossier qui est sur la liste des patients à consulter + Ajouter
						une consultation au dossier du patient à l'aide du bouton nouvelle
						consultation , ensuite remplir le formulaire et le valider +
						Enregistrez un nouveau patient en cliquant juste sur ajouter
						patient , puis remplir le formulaire et le valider
					</p>
					<p>
						<strong>Patient :</strong> vous pouvez demander à avoir un
						Rendez-Vous grace au bouton >Avoir_Mon_RV ou consulter votre
						dossiel medical en Cliquant juste sur >Mon_Dossier
					</p>
					<p>
						<strong>Secretaire :</strong> Pour la gestion des RV, vous pouvez
						assigner une date à un patient à l'aide du calendrier et du bouton
						confirmer.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>