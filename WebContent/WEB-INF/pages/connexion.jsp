
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
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<script src="js/jquery.js"></script>

<script src="js/bootstrap.min.js"></script>
<title>Connexion</title>
</head>
<body>
	<nav id="homeBar" class="navbar navbar-light center "> <img
		id="logos" width=50px src="images/stethoscope.png" />
	<h2 id="medical" class="text-center">MedicalCare</h2>
	<img id="logosD" width=50px src="images/doctor2.png" /> </nav>
	<div id="particles-js">
		<div id="form" class="row ">
			<div class="col-7 offset-md-2">
				<h1 id="connect" class="text-white">Se Connecter</h1>
				<c:if test="${info != null }">

					<span class="  alert alert-danger alert-dismissible fade show"
						role="alert"> <c:out value="${info}"></c:out>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</span>
				</c:if>

				<form method="post" action="connexion">
					<div class="">
						<div class="text-white form-group">
							<label>Login</label> <input type="text" name="login"
								value="${login}" />
						</div>
						<div class="form-group text-white">
							<label>Mot de Passe</label> <input type="password"
								name="password" value="" />
						</div>
						<input type="submit" value="Se Connecter" />
					</div>
				</form>
			</div>
		</div>

	</div>
	<div id="footerLog" class="container-fluid text-center">
		<small>Copyrigth tous droits reserves @2018</small>
	</div>
	<script src="js/particles.js"></script>
	<script src="js/app.js"></script>
</body>
</html>