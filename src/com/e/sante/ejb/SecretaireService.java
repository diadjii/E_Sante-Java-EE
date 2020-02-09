package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Secretaire;

@Stateless
public class SecretaireService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void createSecretaire(Secretaire secretaire) {
		em.persist(secretaire);
	}

	public Secretaire findSecretaire(String login) {
		Query req = em.createQuery("SELECT s FROM Secretaire s WHERE s.login like '" + login + "'");
		Secretaire secretaire = new Secretaire();
		try {
			secretaire = (Secretaire) req.getSingleResult();
		} catch (NoResultException e) {
			secretaire = null;
		}
		return secretaire;
	}

	public List<Secretaire> getAllSecretaire() {
		Query query = em.createQuery("SELECT s FROM Secretaire s");

		@SuppressWarnings("unchecked")
		List<Secretaire> listeSecretaire = query.getResultList();

		return listeSecretaire;
	}

	public void delete(int id) {
		String req = "DELETE FROM Medecin m WHERE m.id=" + id;
		Query query = em.createQuery(req);
		query.executeUpdate();

	}
}