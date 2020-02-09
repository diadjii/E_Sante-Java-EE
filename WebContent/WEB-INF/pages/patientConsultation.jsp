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
<body>
	<c:import url="menu_patient.jsp"></c:import>

	<div class="container">
		<div class="row"></div>
	</div>
	
	<div class="row">
		<div class="col-8">
			<h2 class="text-gray offset-md-1">Liste des Consultations de
				${patient.prenom} ${patient.nom}</h2>
			<c:forEach items="${consultations}" var="consultation"
				varStatus="index">
				<div id="accordion" role="tablist" aria-multiselectable="true">
					<div class="card">
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
								Prescription : ${consultation['prescription']}<br /> Exame n:
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
	</body>
</html>