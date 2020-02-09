package com.e.sante.metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.e.sante.bean.Patient;

public class EditPatient {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_SEXE = "sexe";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	private static final String CHAMP_CONTACT = "contact";
	private static final String CHAMP_AGE = "age";
	private static final String CHAMP_GROUPE_SANGUIN = "groupe";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Patient editPatient(HttpServletRequest request, Patient oldPatient) {

		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String contact = getValeurChamp(request, CHAMP_CONTACT);
		String newMotDePasse = getValeurChamp(request, CHAMP_PASS);
		String oldPassword = oldPatient.getMdp();
		String sexe = getValeurChamp(request, CHAMP_SEXE);
		String groupe = getValeurChamp(request, CHAMP_GROUPE_SANGUIN);

		int age = Integer.parseInt(getValeurChamp(request, CHAMP_AGE));

		Patient patient = new Patient();

		patient.setSexe(sexe);
		patient.setGroupe(groupe);

		try {
			validationMotsDePasse(newMotDePasse, oldPassword);
			newMotDePasse = org.apache.commons.codec.digest.DigestUtils.sha256Hex(newMotDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		patient.setMdp(newMotDePasse);

		try {
			validationContact(contact);
		} catch (Exception e) {
			setErreur(CHAMP_CONTACT, e.getMessage());
		}
		patient.setContact(contact);

		try {
			validation(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		patient.setNom(nom);

		try {
			validation(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		patient.setPrenom(prenom);

		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}
		patient.setLogin(login);

		try {
			validationAge(age);
		} catch (Exception e) {
			setErreur(CHAMP_AGE, e.getMessage());
		}
		patient.setAge(age);

		if (erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Échec de l'inscription.";
		}

		return patient;
	}

	private void validationLogin(String login) throws Exception {
		if (login.trim().length() < 6) {
			throw new Exception("Le login doit doit contenir au moins 6 carateres");
		}
	}

	private void validationContact(String contact) throws Exception {
		if (contact == null || contact.length() < 9) {
			throw new Exception("Un Contact doit contenir 9 chiffres.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String oldPass) throws Exception {
		if (motDePasse == null) {
			motDePasse = oldPass;
		}
		if (motDePasse != null && motDePasse.length() < 3) {
			throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
		}
	}

	private void validation(String nom) throws Exception {
		if (nom == null || nom.length() < 2) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

	private void validationAge(int age) throws Exception {
		if (age < 0) {
			throw new Exception("L'age ne peut pas etre negatif");
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

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

}
