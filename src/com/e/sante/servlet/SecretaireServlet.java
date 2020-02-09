package com.e.sante.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Patient;
import com.e.sante.bean.RendezVous;
import com.e.sante.bean.Secretaire;
import com.e.sante.ejb.PatientService;
import com.e.sante.ejb.RVService;
import com.e.sante.ejb.SecretaireService;
import com.google.gson.Gson;

@WebServlet("/accueilSecretaire")
public class SecretaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String vue = "";

	@EJB
	private PatientService servicePatient;

	@EJB
	private RVService serviceRV;

	@EJB
	private SecretaireService serviceSecretaire;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Secretaire secretaire = (Secretaire) session.getAttribute("user");
				int idSecretaire = secretaire.getIdService();
				List<RendezVous> listeRendezVous = serviceRV.findRV(idSecretaire);
				List<Patient> maListe = new ArrayList<Patient>();

				if (!listeRendezVous.isEmpty()) {
					int idPatient = 0;
					for (RendezVous rv : listeRendezVous) {
						idPatient = rv.getIdPatient();
						Patient patient = servicePatient.findById(idPatient);
						maListe.add(patient);
					}
				}
				request.setAttribute("listeRendezVous", maListe);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/secretaire.jsp").forward(request,
						response);
			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conf = request.getParameter("json");
		String dateRv = request.getParameter("daterv");
		String id = null;
		Gson gson = new Gson();

		/*
		 * recuperation de la liste des patients dont le RV est confirmé sous format
		 * json
		 */

		String[] lis = gson.fromJson(conf, String[].class);
		if (conf == null) {
			request.setAttribute("id", "tableau null");
		} else {
			request.setAttribute("id", lis);
			for (int i = 0; i < lis.length; i++) {
				int idPatient = Integer.parseInt(lis[i]);
				serviceRV.confirmRVPatient(idPatient, dateRv);
			}
			response.getWriter().write("ok");
			// response.sendRedirect(request.getContextPath() + "/accueilSecretaire");
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/secretaire.jsp").forward(request, response);
		}
	}

}
