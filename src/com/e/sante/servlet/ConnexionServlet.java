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

import com.e.sante.bean.Admin;
import com.e.sante.bean.Medecin;
import com.e.sante.bean.Patient;
import com.e.sante.bean.Secretaire;
import com.e.sante.ejb.AdminService;
import com.e.sante.ejb.MedecinService;
import com.e.sante.ejb.PatientService;
import com.e.sante.ejb.SecretaireService;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	private String vue = "";

	@EJB
	private MedecinService serviceMedecin;

	@EJB
	private PatientService pa;

	@EJB
	private SecretaireService serviceSecretaire;

	@EJB
	private AdminService serviceAdmin;

	private Patient patient = new Patient();
	private Medecin medecin = new Medecin();
	private Secretaire secretaire = new Secretaire();
	private Admin admin = new Admin();

	private String login;
	private String password;
	private String message;
	private HttpSession session;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creation d'une session

		session = request.getSession();
		login = request.getParameter(CHAMP_LOGIN);
		password = request.getParameter(CHAMP_PASS);

		if (connectPatient(login, password)) {
			session.setAttribute("user", patient);
			response.sendRedirect(request.getContextPath() + vue);
		} else {
			if (connectMedecin(login, password)) {
				session.setAttribute("user", medecin);
				response.sendRedirect(request.getContextPath() + vue);
			} else {
				if (connectSecretaire(login, password)) {
					session.setAttribute("user", secretaire);
					response.sendRedirect(request.getContextPath() + vue);
				} else {
					if (connectAdmin(login, password)) {
						session.setAttribute("user", admin);
						response.sendRedirect(request.getContextPath() + vue);
					} else {
						request.setAttribute("info", message);
						request.setAttribute("login", login);
						vue = "/WEB-INF/pages/connexion.jsp";
						this.getServletContext().getRequestDispatcher(vue).forward(request, response);
					}
				}
			}
		}
	}

	public boolean correctPassword(String correctPassword, String formPassword) {
		boolean ok = false;
		formPassword = DigestUtils.sha256Hex(formPassword);
		if (correctPassword.equals(formPassword.trim())) {
			ok = true;
		}
		return ok;
	}

	/**
	 * 
	 * teste si le user est un patient
	 * 
	 * @return boolean
	 */
	public boolean connectPatient(String login, String pass) {
		boolean correct = false;
		patient = pa.find(login);

		if (patient != null) {
			if (correctPassword(patient.getMdp(), password)) {
				message = "Connection Reussie";
				vue = "/accueilPatient";
				correct = true;
			} else {
				message = "Mot de passe saisi incorrect ";
				vue = "/connexion";
				correct = false;
			}
		} else {
			message = "Veillez verifier votre login.";
		}

		return correct;
	}

	public boolean connectAdmin(String login, String pass) {
		boolean correct = false;
		admin = serviceAdmin.find(login);

		if (admin != null) {
			if (correctPassword(admin.getMdp(), password)) {
				message = "Connection Reussie";
				vue = "/accueilAdmin";
				correct = true;
			} else {
				message = "Mot de passe saisi incorrect ";
				vue = "/connexion";
				correct = false;
			}
		} else {
			message = "Veillez verifier votre login.";
		}

		return correct;
	}

	public boolean connectSecretaire(String login, String pass) {
		boolean correct = false;
		secretaire = serviceSecretaire.findSecretaire(login);

		if (secretaire != null) {
			if (correctPassword(secretaire.getMdp(), password)) {
				message = "Connection Reussie";
				vue = "/accueilSecretaire";
				correct = true;
			} else {
				message = "Mot de passe saisi incorrect ";
				vue = "/connexion";
				correct = false;
			}
		} else {
			message = "Veillez verifier votre login.";
		}

		return correct;
	}

	/**
	 * 
	 * teste si le user est un medecin
	 * 
	 * @return boolean
	 */
	public boolean connectMedecin(String login, String pass) {
		boolean correct = false;
		medecin = serviceMedecin.find(login);

		if (medecin != null) {
			if (correctPassword(medecin.getMdp(), password)) {
				vue = "/accueilMedecin";
				correct = true;
			} else {
				message = "Mot de passe saisi incorrect ";
				vue = "/connexion";
				correct = false;
			}
		}
		return correct;
	}
}
