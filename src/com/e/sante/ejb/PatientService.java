package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Patient;

@Stateless
public class PatientService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void createPatient(Patient patient) {
		em.persist(patient);
	}

	public void edit(Patient pa, int id) {
		// on fait une modification d'un etudiant
		Patient patient = pa;
		String rq = "UPDATE Patient p SET p.age=" + patient.getAge() + " ,p.contact='" + patient.getContact() + "',"
				+ " p.login='" + patient.getLogin() + "', p.mdp='" + patient.getMdp() + "', p.nom='"
				+ patient.getNom() + "',p.prenom='" + patient.getPrenom() + "', p.sexe ='" + patient.getSexe()
				+ "' WHERE p.id=" + id;
		Query query = em.createQuery(rq);
		query.executeUpdate();
	}

	public void delete(Patient patient) {
		// on rattache l'object
		patient = em.merge(patient);
		// on supprime un etudiant
		em.remove(patient);
	}

	/**
	 * recherche d'un etudiant avec son identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Patient findById(long id) {
		Query req = em.createQuery("SELECT p FROM Patient p WHERE p.id =" + id);
		Patient patient = new Patient();
		try {
			patient = (Patient) req.getSingleResult();
		} catch (NoResultException e) {
			patient = null;
		}
		return patient;
	}

	/**
	 * recherche d'un patient avec son login leors de sa connection
	 * 
	 * @param login
	 * @return
	 */
	public Patient find(String login) {
		Query req = em.createQuery("SELECT p FROM Patient p WHERE p.login like '" + login + "'");
		Patient patient = new Patient();
		try {
			patient = (Patient) req.getSingleResult();
		} catch (NoResultException e) {
			patient = null;
		}
		return patient;
	}

	public List<Patient> getAll() {
		Query query = em.createQuery("SELECT p FROM Patient p");
		@SuppressWarnings("unchecked")
		List<Patient> list = query.getResultList();
		return list;
	}
}
