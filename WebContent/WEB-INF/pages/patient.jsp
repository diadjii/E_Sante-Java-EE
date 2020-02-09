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
<title>Patient</title>
</head>
<body id="content">
	<c:import url="menu_patient.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div id="patientHeader" class="col-12 mw-100">
				<div id="identi" class="col-4">${sessionScope.user.prenom}
					${sessionScope.user.nom}</div>
				<div class="card col-7">
					<div class="card-header">Agenda Rendez-Vous</div>
					<div class="card-block">
						<p id="messageRV" class="card-text">
							<c:out value="${mes }"></c:out>
							.
						</p>
					</div>
					<button id="btn" type="button" class="btn col-5	"
						data-toggle="modal" data-target="#exampleModal"
						data-whatever="@mdo">Demandez rendez-vous</button>
					<br />
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-12 ">
				<h1 class="titres">Mon Dossier Medical</h1>
				<c:forEach items="${consultations}" var="consultation"
					varStatus="index">
					<div id="accordion" role="tablist" aria-multiselectable="true">
						<div class="card" id="editProfils">
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
									<strong>Prescription</strong> : ${consultation['prescription']}<br />
									<strong>Examen</strong> : ${consultation['examen']}<br /> <strong>Facture</strong>
									: ${consultation['facture']} FCFA<br /> <strong>Date
										Consultation</strong> : ${consultation['datecslt']}
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


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