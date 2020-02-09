package com.e.sante.metier;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import com.e.sante.bean.Patient;
import com.e.sante.servlet.SecretaireServlet;

public class Connexion {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";

	@EJB
	private SecretaireServlet pa = new SecretaireServlet();
	String mesage = "";

	public String connexion(HttpServletRequest request) {

		String login = getValeurChamp(request, CHAMP_LOGIN);
		return mesage;
	}

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

}
