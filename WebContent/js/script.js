$(function() {

	$().dropdown('toggle')

	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the
		var recipient = button.data('whatever') // Extract info from
		var modal = $(this)
		modal.find('.modal-title').text('Demandez de Rendez-Vous' + recipient)
		modal.find('.modal-body input').val(recipient)
	})

	$('#aide').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the
		var recipient = button.data('whatever') // Extract info from
		var modal = $(this)
		modal.find('.modal-title').text('Aide')
		modal.find('.modal-body input').val(recipient)
	})

	$('#saveConsultation').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the
		var recipient = button.data('whatever') // Extract info from
		var modal = $(this)
		modal.find('.modal-title').text('Enregistrement Consultation')

	})

	$('#fixerRV').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the
		var recipient = button.data('whatever') // Extract info from
		var modal = $(this)
		modal.find('.modal-title').text('Creation de Rendez-Vous')

	})

	/**
	 * deconnection de l'utilisateur sur le systeme
	 */
	$("#logout").click(function() {
		$.post("deconnexion", "").done(function() {
		})
	})

	/**
	 * demande de rv
	 */

	$("#demandeRV")
			.click(
					function() {
						var idService = $("[name='service']").val();
						if (isNaN(idService)) {
							createMessageAlert(
									"Veillez choisir un Service SVP", "danger")
						} else {
							var data = $("form").serialize();
							$
									.post("demandeRendez_Vous", data)
									.done(
											function(response) {
												if (response == "deja fait") {
													createMessageAlert(
															"Vous avez deja demander un rendez-vous "
																	+ "dans un service",
															"info");
												} else {
													$("#exampleModal").modal(
															"hide");
													$("#succesrv").modal(
															"toggle");
												}
											})
						}
					})

	function createMessageAlert(message, type) {
		var div = $("<div class='alert alert-" + type + "'>");
		div.text(message);
		var btn = $("<button class='close' data-dismiss='alert' aria-label='Close' >")
		var span = $("<span aria-hidden='true'>")
		span.text("x");
		btn.append(span);
		div.append(btn);
		$("#infoRV").append(div);
	}
	/**
	 * creation d'un nouveau dossier pour un patient
	 */

	$("#creer_dossier").click(function() {
		var info_dossier = $("form").serialize();
		$.post("ajoutPatient", info_dossier).done(function() {
			alert("Dossier creer avec Succes");
		})
	})

	/**
	 * modification profil patient
	 */

	$("#editProfilP").click(function(e) {
		e.preventDefault();
		var info_dossier = $("form").serialize();
		$.post("profilPatient", info_dossier).done(function(res) {
			if (res == "ok") {
				$("#succesEdit").modal("toggle");
			}
		})
	})

	/**
	 * modification profil patient
	 */

	$("#editProfilM").click(function(e) {
		e.preventDefault();
		var info_dossier = $("form").serialize();
		$.post("profilMedecin", info_dossier).done(function(res) {
			if (res == "ok") {
				$("#succesEdit").modal("toggle");
				window.location = "accueilPatient"
			}
		})
	})
	// confirmation d'un RV par un secretaire
	$("#confirmRV")
			.click(
					function(e) {
						e.preventDefault();
						var confirm = $("[name='confirmRVPatient']:checked");
						var dateRv = $("[name='daterv']").val();
						var array = [];

						for (var i = 0; i < confirm.length; i++) {
							array[i] = confirm[i].value;
						}

						var conf = JSON.stringify(array);
						$
								.ajax({
									url : "accueilSecretaire",
									type : "POST",
									dataType : 'json',
									data : {
										json : conf,
										daterv : dateRv
									}
								})
								.fail(
										function(e) {
											if (e.readyState == 4) {
												var tr = $(
														"[name='confirmRVPatient']:checked ")
														.closest(".tr");
												tr.remove();
												$("#succesrvs").modal("toggle");
											}
										})

					})

	// enregistrement d'une nouvelle consultation
	$("#enregistrerConsultation").click(function() {

		var info_dossier = $("form").serialize();
		$.post("enregistrementConsultation", info_dossier).done(function() {
			$('#saveConsultation').modal("hide");
			$("#succescslt").modal("toggle");
		})
	})

	/**
	 * creation de rendez-vous par un medecin
	 */
	$("#valider").click(function() {
		var id = $("[name='idPatient']").val();
		var date = $("[name='dateRV']").val();
		$.post("validerConsultation", {
			idPatient : id,
		}).done(function(response) {
			if (response == "ok") {
				$("#titresms").text("Confirmation de Consultation");
				$("#message").text("La consultation a ete confirmee");
				$("#succesrv").modal("toggle");
			} else {

				var error = $("<span id='errorFixeRV' class='text-danger'>");
				error.text("Une erreur c'est produite");
				$("#errorRV").append(error);
			}
		})
	})
	$("#creationRV").click(function() {
		var id = $("[name='idPatient']").val();
		var date = $("[name='dateRV']").val();
		$.post("MedecinCreationRV", {
			idPatient : id,
			dateRV : date
		}).done(function(response) {
			if (response == "ok") {
				$('#fixerRV').modal("hide");
				$("#succesrv").modal("toggle");
			} else {

				var error = $("<span id='errorFixeRV' class='text-danger'>");
				error.text("Une erreur c'est produite");
				$("#errorRV").append(error);
			}
		})
	})
	$("#deleteM").click(function() {
		var confirm = $("[name='medecin']:checked");
		var array = [];
		for (var i = 0; i < confirm.length; i++) {
			array[i] = confirm[i].value;
		}

		var conf = JSON.stringify(array);
		$.ajax({
			url : "accueilAdmin",
			type : "POST",
			dataType : 'json',
			data : {
				json : conf,
				user : "medecin"
			}
		})
		window.location = "accueilAdmin"
	})

	$("#deleteS").click(function() {
		var confirm = $("[name='secretaire']:checked");
		var array = [];
		for (var i = 0; i < confirm.length; i++) {
			array[i] = confirm[i].value;
		}

		var conf = JSON.stringify(array);
		$.ajax({
			url : "accueilAdmin",
			type : "POST",
			dataType : 'json',
			data : {
				json : conf,
				user : "secretaire"
			}
		})
	})

	$("#btnL").click(function() {
		window.location = "connexion";
	})
	
	$("#medical").click(function() {
		window.location = "/";
	})
})