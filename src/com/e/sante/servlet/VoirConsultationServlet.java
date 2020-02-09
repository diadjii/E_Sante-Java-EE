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
import com.e.sante.bean.Medecin;
import com.e.sante.ejb.RVService;

@WebServlet("/validerConsultation")
public class VoirConsultationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private RVService serviceRV;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/connexion");
		} else {
			try {
				Medecin medecin = (Medecin) session.getAttribute("user");
				int idPatient = Integer.parseInt(request.getParameter("idPatient"));
				serviceRV.validerRVPatient(idPatient, medecin.getIdService());
				response.getWriter().write("ok");

			} catch (ClassCastException e) {
				response.sendRedirect(request.getContextPath() + "/acces-refuse");
			}
		}
	}
}
