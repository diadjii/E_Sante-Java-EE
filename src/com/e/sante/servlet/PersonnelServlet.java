package com.e.sante.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.e.sante.bean.Medecin;
import com.e.sante.bean.Secretaire;
import com.e.sante.bean.Service;
import com.e.sante.ejb.MedecinService;
import com.e.sante.ejb.SecretaireService;
import com.e.sante.ejb.SpecialiteService;

@WebServlet("/ajoutPersonnel")
public class PersonnelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private MedecinService create;

	@EJB
	private SpecialiteService specialite;

	@EJB
	private SecretaireService secretaireService;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * recuperation des differentes specialitees qui existent
		 */

		List<Service> specialites = specialite.getAllService();
		request.setAttribute("specialites", specialites);

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajoutPersonnel.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		if (user.equals("medecin")) {

			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			int idService = Integer.parseInt(request.getParameter("service"));

			Medecin medecin = new Medecin();

			password = DigestUtils.sha256Hex(password);
			medecin.setPrenom(prenom.trim());
			medecin.setNom(nom.trim());
			medecin.setLogin(login.trim());
			medecin.setMdp(password.trim());
			medecin.setContact(contact.trim());
			medecin.setIdService(idService);
			create.createMedecin(medecin);
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			if (user.equals("secretaire")) {
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				String contact = request.getParameter("contact");
				int idService = Integer.parseInt(request.getParameter("service"));

				Secretaire secretaire = new Secretaire();

				secretaire.setPrenom(prenom);
				secretaire.setNom(nom);
				secretaire.setLogin(login);
				password = DigestUtils.sha256Hex(password);
				secretaire.setMdp(password);
				secretaire.setIdService(idService);
				secretaire.setContact(contact);
				secretaireService.createSecretaire(secretaire);
				response.sendRedirect(request.getContextPath() + "/accueilAdmin");
			}
		}
	}

}
