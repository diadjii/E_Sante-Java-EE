package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Medecin;

@Stateless
public class MedecinService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void createMedecin(Medecin medecin) {
		em.persist(medecin);
	}

	public Medecin find(String login) {
		Query req = em.createQuery("SELECT m FROM Medecin m WHERE m.login like '" + login + "'");
		Medecin medecin = new Medecin();
		try {
			medecin = (Medecin) req.getSingleResult();
		} catch (NoResultException e) {
			medecin = null;
		}
		return medecin;
	}

	public List<Medecin> getAllMedecin() {
		Query query = em.createQuery("SELECT m FROM Medecin m");
		@SuppressWarnings("unchecked")
		List<Medecin> medecins = query.getResultList();

		return medecins;
	}

	public void delete(int id) {
		String req = "DELETE FROM Medecin m WHERE m.id=" + id;
		Query query = em.createQuery(req);
		query.executeUpdate();
	}

	public void edit(Medecin med, int id) {
		Medecin medecin = med;
		String rq = "UPDATE Medecin m SET m.contact='" + medecin.getContact() + "'," + " m.login='" + medecin.getLogin()
				+ "', m.mdp='" + medecin.getMdp() + "', m.nom='" + medecin.getNom() + "',m.prenom='"
				+ medecin.getPrenom() + "', m.sexe ='" + medecin.getSexe() + "' WHERE m.id=" + id;
		Query query = em.createQuery(rq);
		query.executeUpdate();

	}
}
