package com.e.sante.metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.e.sante.bean.Consultation;

public final class AjoutConsultation {
	private static final String CHAMP_ID_PATIENT = "id_patient";
	private static final String CHAMP_ID_MEDECIN = "id_medecin";
	private static final String CHAMP_MOTIF = "motif";
	private static final String CHAMP_FACTURE = "facture";
	
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}
	

	/**String
	 * 
	 * @param request
	 * @return patient c'est à partir de cette methode qu'on va recuperer les
	 *         valeurs saisies dans le formulaire et de controler les donnees
	 */
	public Consultation ajoutConsultation(HttpServletRequest request) {

		int id_patient = Integer.parseInt(getValeurChamp(request, CHAMP_ID_PATIENT));
		int id_medecin=Integer.parseInt(getValeurChamp(request,CHAMP_ID_MEDECIN));
		int facture=Integer.parseInt(getValeurChamp(request,CHAMP_FACTURE));
		String motif=getValeurChamp(request,CHAMP_MOTIF);
		
		Consultation consultation = new Consultation();
		
		consultation.setIdPatient(id_patient);
		consultation.setIdMedecin(id_medecin);
		consultation.setMotif(motif);
		consultation.setFacture(facture);
		
		return consultation;
		
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
	
