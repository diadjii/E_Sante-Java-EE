package com.e.sante.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.e.sante.bean.Patient;
import com.e.sante.ejb.PatientService;

@WebServlet("/profilPatient")
public class ProfilPatient extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private PatientService servicePatient;

	private String groupeA;
	private String groupeB;
	private String groupeO;
	private String sexeF;
	private String sexeM;
	private String type;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Patient patient = (Patient) session.getAttribute("user");
				groupePatient(patient.getGroupe());
				sexePatient(patient.getSexe());
				request.setAttribute("type", type);
				request.setAttribute("sexeM", sexeM);
				request.setAttribute("sexeF", sexeF);
				request.setAttribute("selectA", groupeA);
				request.setAttribute("selectB", groupeB);
				request.setAttribute("selectO", groupeO);
				request.setAttribute("patient", patient);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/profil.jsp").forward(request, response);

			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Patient patientS = (Patient) session.getAttribute("user");
		Patient patient = new Patient();
		String newPassword = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String contact = request.getParameter("contact");
		String newMotDePasse = request.getParameter("password");
		String sexe = request.getParameter("sexe");
		int age = Integer.parseInt(request.getParameter("age"));
		String groupe = request.getParameter("groupe");
		patient.setAge(age);
		patient.setContact(contact);
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setSexe(sexe);
		patient.setGroupe(groupe);
		patient.setLogin(login);
		if (patientS.getMdp() != patient.getMdp()) {
			newMotDePasse = DigestUtils.sha256Hex(newMotDePasse);
			patient.setMdp(newMotDePasse);
		} else {
			patient.setMdp(patientS.getMdp());
		}
		servicePatient.edit(patient, patientS.getId());
		session.setAttribute("user", patient);
		response.getWriter().write("ok");
	}

	private void groupePatient(String groupeP) {
		String selected = "selected";
		switch (groupeP) {
		case "A":
			groupeA = selected;
			break;
		case "B":
			groupeB = selected;
			break;
		case "O":
			groupeO = selected;
			break;

		default:
			break;
		}
	}

	private void sexePatient(String sexe) {
		switch (sexe) {
		case "F":
			sexeF = "checked";
			type = "girl.png";
			break;
		case "M":
			type = "man.png";
			sexeM = "checked";
			break;
		default:
			break;
		}
	}
}
