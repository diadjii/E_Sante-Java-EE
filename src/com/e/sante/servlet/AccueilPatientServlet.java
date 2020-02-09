package com.e.sante.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Consultation;
import com.e.sante.bean.Patient;
import com.e.sante.bean.RendezVous;
import com.e.sante.bean.Service;
import com.e.sante.ejb.ConsultationService;
import com.e.sante.ejb.RVService;
import com.e.sante.ejb.SpecialiteService;

@WebServlet("/accueilPatient")
public class AccueilPatientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private SpecialiteService specialite;

	@EJB
	private RVService serviceRV;

	@EJB
	private SpecialiteService serviceS;

	@EJB
	private ConsultationService serviceConsultation;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mes;
		/**
		 * redirige l'utilisateur vers sa page d'accueil si une session existe sinon il
		 * est redirige vers la page de connexion
		 */

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Patient patient = (Patient) session.getAttribute("user");
				List<Service> specialites = specialite.getAllService();
				request.setAttribute("specialites", specialites);
				
				List<Consultation> listeConsultationsPatient = serviceConsultation.findConsultation(patient.getId());
				request.setAttribute("consultations", listeConsultationsPatient);
				
				RendezVous rvPatient = serviceRV.rvConfirme(patient.getId());
				
				if (rvPatient != null) {
					int idService = rvPatient.getIdService();
					Service sv = serviceS.findService(idService);
					mes = "Votre rendez-vous chez le " + sv.getLibelle() + " est fixe le " + rvPatient.getDate() + "";
				} else {
					mes = "Aucun rendez-vous pour le moment";
				}
				
				request.setAttribute("mes", mes);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/patient.jsp").forward(request, response);

			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}

}
