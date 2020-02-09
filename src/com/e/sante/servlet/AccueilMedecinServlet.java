package com.e.sante.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Medecin;
import com.e.sante.bean.Patient;
import com.e.sante.bean.RendezVous;
import com.e.sante.ejb.PatientService;
import com.e.sante.ejb.RVService;

@WebServlet("/accueilMedecin")
public class AccueilMedecinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private RVService serviceRV;

	@EJB
	private PatientService servicePatient;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/**
		 * redirige l'utilisateur vers sa page d'accueil si une session existe sinon il
		 * est redirige vers la page de connexion
		 */

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Medecin medecin = (Medecin) session.getAttribute("user");
				int idService = medecin.getIdService();
				List<RendezVous> listRendezVous = serviceRV.listRv(idService);
				List<Patient> listePatient = servicePatient.getAll();
				List<Patient> maListe = new ArrayList<Patient>();
				/**
				 * recuperation de la date actuelle à fin de recuperer les consultations de la
				 * journee
				 */
				Date actuelle = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String datActuelle = dateFormat.format(actuelle);
				
				request.setAttribute("date", datActuelle);
				
				for (Patient p : listePatient) {
					for (RendezVous rv : listRendezVous) {
						if (p.getId() == rv.getIdPatient() && rv.getDate().equals(datActuelle)) {
							maListe.add(p);
						}
					}
				}
				
				request.setAttribute("liste", maListe);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/medecin.jsp").forward(request, response);
			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}

}
