package com.e.sante.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Patient;
import com.e.sante.bean.Secretaire;
import com.e.sante.ejb.MedecinService;
import com.e.sante.ejb.PatientService;
import com.e.sante.metier.AjoutPatient;

@WebServlet("/ajoutPatient")
public class PatientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String vue = "";

	@EJB
	private PatientService create;

	@EJB
	private MedecinService medecin;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Secretaire secretaire = (Secretaire) session.getAttribute("user");
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajoutPatient.jsp").forward(request,
						response);
			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AjoutPatient add = new AjoutPatient();
		Patient patient = new Patient();

		patient = add.inscrirePatient(request);
		if (patient != null) {
			try {
				create.createPatient(patient);
				int ok=1;
				request.setAttribute("ok", ok);
				vue = "/ajoutPatient";
				response.sendRedirect(request.getContextPath() + vue);
			} catch (Exception e) {
				int error = 1;
				request.setAttribute("info", error);
				vue = "/WEB-INF/pages/ajoutPatient.jsp";
				this.getServletContext().getRequestDispatcher(vue).forward(request, response);
			}
		} else {
			String checkF = "checked";
			String checkM = "checked";

			if (patient.getSexe().equals("M")) {
				checkF = "";
				request.setAttribute("sexeM", checkM);
				request.setAttribute("sexeF", checkF);
			} else {
				checkM = "";
				request.setAttribute("sexeF", checkF);
				request.setAttribute("sexeM", checkM);
			}
			request.setAttribute("error", add);
			request.setAttribute("patient", patient);
			vue = "/WEB-INF/pages/ajoutPatient.jsp";

			this.getServletContext().getRequestDispatcher(vue).forward(request, response);
		}
	}
}
