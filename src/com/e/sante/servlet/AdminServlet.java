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

import com.e.sante.bean.Admin;
import com.e.sante.bean.Medecin;
import com.e.sante.bean.Secretaire;
import com.e.sante.ejb.MedecinService;
import com.e.sante.ejb.SecretaireService;
import com.google.gson.Gson;

@WebServlet("/accueilAdmin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private MedecinService serviceMedecin;

	@EJB
	private SecretaireService serviceSecretaire;

	@Override
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
				Admin admin = (Admin) session.getAttribute("user");

				List<Medecin> listeMedecin = serviceMedecin.getAllMedecin();
				List<Secretaire> listeSecretaire = serviceSecretaire.getAllSecretaire();

				request.setAttribute("listeMedecin", listeMedecin);
				request.setAttribute("listeSecretaire", listeSecretaire);

				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);

			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conf = request.getParameter("json");
		String type = request.getParameter("user");
		String id = null;
		Gson gson = new Gson();

		/*
		 * recuperation de la liste des patients dont le RV est confirmé sous format
		 * json
		 */

		String[] lis = gson.fromJson(conf, String[].class);
		int idUser;
		if (conf == null) {
			request.setAttribute("id", "tableau null");
		} else {
			request.setAttribute("id", lis);
			if (type == "medecin") {
				for (int i = 0; i < lis.length; i++) {
					idUser = Integer.parseInt(lis[i]);
					serviceMedecin.delete(idUser);
				}
			} else {
				for (int i = 0; i < lis.length; i++) {
					idUser = Integer.parseInt(lis[i]);
					serviceSecretaire.delete(idUser);
				}
			}
			response.getWriter().write("ok");
			response.sendRedirect(request.getContextPath() + "/accueilAdmin");
		}
	}

}
