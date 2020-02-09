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

import com.e.sante.bean.Medecin;
import com.e.sante.ejb.MedecinService;

@WebServlet("/profilMedecin")
public class ProfilMedecin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private MedecinService serviceMedecin;
	
	private String sexeF;
	private String sexeM;
	private String type;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Medecin medecin = (Medecin) session.getAttribute("user");
				sexeMedecin(medecin.getSexe());
				request.setAttribute("medecin", medecin);
				request.setAttribute("type", type);
				request.setAttribute("sexeM", sexeM);
				request.setAttribute("sexeF", sexeF);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/profilMedecin.jsp").forward(request,
						response);

			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Medecin medecinS = (Medecin) session.getAttribute("user");
		Medecin medecin = new Medecin();
		String newPassword = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String contact = request.getParameter("contact");
		String newMotDePasse = request.getParameter("password");
		String sexe = request.getParameter("sexe");
		String groupe = request.getParameter("groupe");
		medecin.setContact(contact);
		medecin.setNom(nom);
		medecin.setPrenom(prenom);
		medecin.setSexe(sexe);
		medecin.setLogin(login);
		if (medecinS.getMdp() != medecin.getMdp()) {
			newMotDePasse = DigestUtils.sha256Hex(newMotDePasse);
			medecin.setMdp(newMotDePasse);
		} else {
			medecin.setMdp(medecinS.getMdp());
		}
		serviceMedecin.edit(medecin, medecinS.getId());
		session.setAttribute("user", medecin);
		response.getWriter().write("ok");
	}
	private void sexeMedecin(String sexe) {
		switch (sexe) {
		case "F":
			sexeF = "checked";
			type = "girl.png";
			break;
		case "M":
			sexeM = "checked";
			type = "man.png";
			break;
		default:
			break;
		}
	}
}
