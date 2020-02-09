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
<title>Ajout d'un Medecin</title>
</head>
<body>
	<c:import url="menu_medecin.jsp"></c:import>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<form class="form-inline my-2 my-lg-0 " method="post">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Saisir identifiant du patient" name="id">
						<button id="search" class="btn btn-outline-success my-2 my-sm-0"
							type="submit">Chercher</button>
				</form>
			</div>
		</div>
	</div>
	<div id="accordion" role="tablist" aria-multiselectable="true">
		<div class="card">
			<div class="card-header" role="tab" id="headingOne">
				<h5 class="mb-0">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne"> Collapsible Group Item #1 </a>
				</h5>
			</div>

			<div id="collapseOne" class="collapse show" role="tabpanel"
				aria-labelledby="headingOne">
				<div class="card-block">Anim pariatur cliche reprehenderit,
					enim eiusmod high life accusamus terry richardson ad squid. 3 wolf
					moon officia aute, non cupidatat skateboard dolor brunch. Food
					truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor,
					sunt aliqua put a bird on it squid single-origin coffee nulla
					assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer
					labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
					excepteur butcher vice lomo. Leggings occaecat craft beer
					farm-to-table, raw denim aesthetic synth nesciunt you probably
					haven't heard of them accusamus labore sustainable VHS.</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			
		})
	</script>
</body>
</html>