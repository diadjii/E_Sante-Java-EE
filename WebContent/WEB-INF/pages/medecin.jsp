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
<title>Medecin</title>
</head>
<body>
	<c:import url="menu_medecin.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div id="medecin_1" class="col-12 mw-100">
				<h2 id="biendocteur">Bienvenue Docteur ${sessionScope.user.nom}</h2>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-8 offset-md-1">
			<h2 class="text-gray">Liste des Rendez-Vous</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>N°</th>
						<th>Prenom</th>
						<th>Nom</th>
						<th>Consulter</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${liste}" var="rv" varStatus="index">
						<tr>
							<th scope="row"><c:out value="${index.count}">
								</c:out></th>
							<td><c:out value="${rv['prenom']}" /></td>
							<td><c:out value="${rv['nom']}" /></td>
							<form action="consultationpatient" method="post">
								<td><input type="number" name="idPatient"
									value="${rv['id']}" hidden /> <input type="submit"
									class="btn btn-success" name="consultPatient"
									value="Consulter Dossier"></td>
							</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>