$(function() {

	$().dropdown('toggle')

	/**
	 * modals pour demander rendez vous chez un medecin
	 */
	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the
		// modal
		var recipient = button.data('whatever') // Extract info from
		// data-*
		// attributes
		// If necessary, you could initiate an AJAX request here (and
		// then do
		// the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you
		// could use
		// a data binding library or other methods instead.
		var modal = $(this)
		modal.find('.modal-title').text('Demandez de Rendez-Vous' + recipient)
		modal.find('.modal-body input').val(recipient)
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
							var div = $("<div class='alert alert-danger'>");
							div.text("Veillez choisir un Service SVP")
							var btn = $("<button class='close' data-dismiss='alert' aria-label='Close' >")
							var span = $("<span aria-hidden='true'>")
							span.text("X");
							btn.append(span);
							div.append(btn);
							$("#infoRV").append(div);
							// alert("Veillez choisir un service SVP");
						} else {
							var data = $("form").serialize();
							// var d = $("#successRV").
							// text("<strong>Demande Envoyée: </strong>Une
							// notification vous sera envoyée" +
							// " une fois le rendez - vous confirmé ");

							$.post("demandeRendez_Vous", data).done(function() {
								$("#exampleModal").modal("hide");
								$("#succesrv").modal("toggle");

							})
						}
					})
	/**
	 * creation d'un nouveau dossier pour un patient
	 */

	$("#creer_dossier").click(function() {
		var info_dossier = $("form").serialize();
		$.post("ajoutPatient", info_dossier).done(function() {
			alert("Dossier creer avec Succes");
		})
	})

	// recherche d'un dossier pour un patient
	$('.collapse').collapse()
	$("#search").submit(function(e) {
		e.preventDefault();
		var data = $("form").serialize();
		$.post("Consultation", data).done(function() {
			window.location = "";
		})

	})
})