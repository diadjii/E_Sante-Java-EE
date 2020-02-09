package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Consultation;

@Stateless
public class ConsultationService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void createConsultation(Consultation consultation) {
		em.persist(consultation);
	}

	/**
	 * 
	 * @param idPatient
	 * @return la liste des consultations d'un patient
	 */
	public List<Consultation> findConsultation(int idPatient) {
		Query query = em.createQuery("SELECT c FROM Consultation c where c.idPatient = " + idPatient);
		List<Consultation> listeConsultations = query.getResultList();

		return listeConsultations;
	}

	public List<ConsultationService> getAllConsultation() {
		Query req = em.createQuery("SELECT c FROM Consultation c ");
		@SuppressWarnings("unchecked")
		List<ConsultationService> consultations = req.getResultList();

		return consultations;
	}
}
