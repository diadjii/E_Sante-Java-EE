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
import com.e.sante.bean.RendezVous;
import com.e.sante.ejb.RVService;

@WebServlet("/demandeRendez_Vous")
public class DemandeRVServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private RVService serviceRV;

	private int idService;
	private int idPatient;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajoutConsultation.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RendezVous rv = new RendezVous();
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("user");
		idPatient = patient.getId();

		try {
			idService = Integer.parseInt(request.getParameter("service"));
		} catch (NumberFormatException e) {
			request.setAttribute("errorRV", "Veillez choisir un service SVP");
			response.sendRedirect(request.getContextPath() + "/accueilPatient");
		}
		rv.setIdPatient(idPatient);
		rv.setIdService(idService);

		if (serviceRV.verifRV(rv)) {
			response.getWriter().write("deja fait");
		} else {
			serviceRV.createRV(rv);
			response.getWriter().write("ok");
		}
		response.sendRedirect(request.getContextPath() + "/profilPatient");
	}

}
