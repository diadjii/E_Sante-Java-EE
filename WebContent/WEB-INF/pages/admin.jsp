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
<title>Gestion des Utilisateurs</title>
</head>
<body>
	<c:import url="menu_admin.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div id="medecin_1" class="col-12 mw-100">
				<h2 id="biendocteur">Bienvenue Administrateur
					${sessionScope.user.nom}</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-10 offset-md-1">
				<div id="accordion" role="tablist" aria-multiselectable="true">
					<div class="card">
						<div class="card-header" role="tab" id="headingOne">
							<h5 class="mb-0">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> Liste des Medecins </a>
							</h5>
						</div>
						<div id="collapseOne" class="collapse show" role="tabpanel"
							aria-labelledby="headingOne">
							<table class="table table-hover">
								<thead class="thead-inverse">
									<tr>
										<th>N°</th>
										<th>Pr&eacutenom</th>
										<th>Nom</th>
									</tr>
								</thead>
								<tbody>
									<form>
										<c:forEach items="${listeMedecin}" var="medecin"
											varStatus="index">
											<tr class="tr">
												<td scope="row"><c:out value="${index.count}"></c:out></td>
												<td><c:out value="${medecin['prenom']}" /></td>
												<td><c:out value="${medecin['nom']}" /></td>
												<td><input type="number" name="idPatient"
													value="${medecin['id']}" hidden /> <input type="checkbox"
													name="medecin" class="btn btn-danger"
													value="${medecin['id']}"></td>
											</tr>
										</c:forEach>
									</form>
								</tbody>
							</table>
						</div>
					</div>
					<div class="card">
						<div class="card-header" role="tab" id="headingTwo">
							<h5 class="mb-0">
								<a class="collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> Liste
									des S&eacutecretaires </a>
							</h5>
						</div>
						<div id="collapseTwo" class="collapse" role="tabpanel"
							aria-labelledby="headingTwo">
							<table class="table table-hover">
								<thead class="thead-inverse">
									<tr>
										<th>N°</th>
										<th>Pr&eacutenom</th>
										<th>Nom</th>
									</tr>
								</thead>
								<tbody>
									<form>
										<c:forEach items="${listeSecretaire}" var="secretaire"
											varStatus="index">
											<tr class="tr">
												<td scope="row"><c:out value="${index.count}"></c:out></td>
												<td><c:out value="${secretaire['prenom']}" /></td>
												<td><c:out value="${secretaire['nom']}" /></td>
												<td><input type="checkbox" name="secretaire"
													class="btn btn-danger" value="${secretaire['id']}"></td>
											</tr>
										</c:forEach>
									</form>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>