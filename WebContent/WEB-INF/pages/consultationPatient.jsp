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
<title>Liste des Consultations d'un Patient</title>
</head>
<body id="content">
	<c:import url="menu_medecin.jsp"></c:import>
	<div class="container">
		<div id="consul" class="row ">
			<h2 class="text-white text-center offset-md-2">Dossier Medical
				de ${patient.prenom} ${patient.nom}</h2>
			<div id="btnConsul" class="col-lg-10 offset-md-2">
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#saveConsultation">Enregistrer Consultation</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					id="valider">Valider Consultation</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#fixerRV">Fixer Rendez-Vous</button>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">

				<c:forEach items="${listeConsultations}" var="consultation"
					varStatus="index">
					<div id="accordion" role="tablist" aria-multiselectable="true">
						<div class="card" id="editProfil">
							<div class="card-header" role="tab" id="headingOne">
								<h5 class="mb-0">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne${consultation['id']}" aria-expanded="true"
										aria-controls="collapseOne"> ${consultation['motif']} </a>
								</h5>
							</div>

							<div id="collapseOne${consultation['id']}" class="collapse show"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="card-block">
									Prescription : ${consultation['prescription']}<br /> Examen:
									${consultation['examen']}<br /> Facture :
									${consultation['facture']} FCFA<br /> Date Consultation
									:${consultation['datecslt']}
								</div>
								<div class="card-block">
									<!--description de la consultation  -->
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="modal fade" id="saveConsultation" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"></h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="nom">Motif</label> <input type=number
								value="${patient.id }" name="idPatient" hidden><input
								id="nom " class="form-control" type="text" name="motif" min="3"
								placeholder="Motif consultatoin" />
						</div>
						<div class="form-group">
							<label for="exampleTextarea">Prescription du Medecin</label>
							<textarea class="form-control" name="prescription" rows="3"
								placeholder="Prescription du Medecin au client "></textarea>
						</div>
						<div class="form-group">
							<label for="nom">Examen</label> <input id="nom "
								class="form-control" type="text" name="examen"
								placeholder="Type Examen" />
						</div>
						<div class="form-group">
							<label for="nom">Facture</label> <input id="nom "
								class="form-control" type="number" name="facture" />
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button id="enregistrerConsultation" type="button"
						class="btn btn-primary">Enregistrer</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="fixerRV" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"></h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="errorRV"></div>
					<form>
						<div class="form-group">
							<label for="nom">Date Rendez-Vous</label> <input
								class="form-control" type="date" name="dateRV"
								placeholder="Type Examen" />
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="creationRV" type="button" class="btn btn-primary">Enregistrer</button>
				</div>
			</div>
		</div>
	</div>
	<div id="succesrv" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sg">
			<div class="modal-content container">
				<h2 id="titresms">Creation de Rendez-vous</h2>
				<p id="message">Rendez-Vous pour ${patient.prenom}
					${patient.nom} a bien &eacutet&eacute cr&eacutee avec succes</p>
			</div>
		</div>
	</div>
</body>
</html>