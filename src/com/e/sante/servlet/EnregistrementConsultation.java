package com.e.sante.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e.sante.bean.Consultation;
import com.e.sante.bean.Medecin;
import com.e.sante.ejb.ConsultationService;

@WebServlet("/enregistrementConsultation")
public class EnregistrementConsultation extends HttpServlet {

	@EJB
	private ConsultationService serviceConsultation;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String motif = request.getParameter("motif");
		String prescription = request.getParameter("prescription");
		String examen = request.getParameter("examen");
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("EEEE, d MMM yyyy");
		String date = formater.format(aujourdhui);

		double facture = Double.parseDouble(request.getParameter("facture"));
		int idPatient = Integer.parseInt(request.getParameter("idPatient"));
		int idMedecin = 0;

		try {
			Medecin medecin = (Medecin) session.getAttribute("user");
			idMedecin = medecin.getId();
		} catch (ClassCastException e) {
			response.sendRedirect(request.getContentType() + "/accueilMedecin");
		}

		Consultation consultation = new Consultation();
		consultation.setIdMedecin(idMedecin);
		consultation.setIdPatient(idPatient);
		consultation.setMotif(motif);
		consultation.setExamen(examen);
		consultation.setPrescription(prescription);
		consultation.setFacture(facture);
		consultation.setDatecslt(date);

		serviceConsultation.createConsultation(consultation);
	}
}
