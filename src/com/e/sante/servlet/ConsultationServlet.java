package com.e.sante.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e.sante.bean.Consultation;
import com.e.sante.bean.Patient;
import com.e.sante.ejb.ConsultationService;
import com.e.sante.ejb.PatientService;

@WebServlet("/consultationpatient")
public class ConsultationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private PatientService servicePatient;
	@EJB
	private ConsultationService serviceConsultation;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/accueilMedecin");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPatient = Integer.parseInt(request.getParameter("idPatient"));
		Patient patient = servicePatient.findById(idPatient);

		if (patient != null) {
			List<Consultation> listeConsultationsPatient = serviceConsultation.findConsultation(patient.getId());
			request.setAttribute("listeConsultations", listeConsultationsPatient);
			request.setAttribute("patient", patient);
		} else {
			String info = "Ce patient n'existe pas";
			request.setAttribute("info", info);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/consultationPatient.jsp").forward(request,
				response);
	}

}
