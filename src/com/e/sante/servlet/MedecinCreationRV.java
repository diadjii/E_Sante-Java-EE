package com.e.sante.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Medecin;
import com.e.sante.bean.RendezVous;
import com.e.sante.ejb.RVService;

@WebServlet("/MedecinCreationRV")
public class MedecinCreationRV extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private RVService serviceRV;

	private String message = null;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute("user");
		int idService = medecin.getIdService();
		int idPatient = 0;
		String dateRV = request.getParameter("dateRV");

		try {
			idPatient = Integer.parseInt(request.getParameter("idPatient"));
			message = "ok";
		} catch (Exception e) {
			message = "error";
		}
		if (message.equals("ok")) {
			RendezVous rendezVous = new RendezVous();
			rendezVous.setEtat(1);
			rendezVous.setIdPatient(idPatient);
			rendezVous.setIdService(idService);
			rendezVous.setDate(dateRV);

			serviceRV.createRV(rendezVous);
		}
		response.getWriter().write(message);

	}
}
