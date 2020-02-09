package com.e.sante.metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.e.sante.bean.Medecin;

public final class AjoutMedecin {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	private static final String CHAMP_ID_SERVICE = "id_service";
	private static final String CHAMP_CONTACT = "contact";
	private static final String CHAMP_CONF = "confirmation";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	/**
	 * 
	 * @param request
	 * @return patient c'est à partir de cette methode qu'on va recuperer les
	 *         valeurs saisies dans le formulaire et de controler les donnees
	 */
	public Medecin inscrireMedecin(HttpServletRequest request) {

		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String id_service = getValeurChamp(request, CHAMP_ID_SERVICE);
		String contact = getValeurChamp(request, CHAMP_CONTACT);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_PASS);

		Medecin medecin = new Medecin();

		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		medecin.setMdp(motDePasse);

		try {
			validationContact(contact);
		} catch (Exception e) {
			setErreur(CHAMP_CONTACT, e.getMessage());
		}
		medecin.setContact(contact);

		try {
			validation(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		medecin.setNom(nom);

		try {
			validation(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		medecin.setNom(prenom);

		try {
			validation(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}
		medecin.setLogin(login);

		if (erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Échec de l'inscription.";
		}

		return medecin;
	}

	private void validationContact(String contact) throws Exception {
		if (contact != null && contact.length() < 9) {
			throw new Exception("Un Contact doit contenir 9 chiffres.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private void validation(String nom) throws Exception {
		if (nom != null && nom.length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

	/*
	 * 
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 * 
	 */

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * 
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * 
	 * sinon.
	 * 
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
}
