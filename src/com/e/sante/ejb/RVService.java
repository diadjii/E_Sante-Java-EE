package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.RendezVous;

@Stateless
public class RVService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void createRV(RendezVous rv) {
		em.persist(rv);
	}

	public List<RendezVous> findRV(int idService) {
		Query query = em.createQuery(
				"SELECT rv FROM RendezVous rv WHERE rv.idService=" + idService + " AND rv.etat=0 ORDER BY rv.date ASC");
		List<RendezVous> listeRV = query.getResultList();

		return listeRV;
	}

	public void confirmRVPatient(int idPatient, String dateRv) {
		String rq = "UPDATE RendezVous rv SET rv.etat=1 , rv.date ='" + dateRv + "' WHERE rv.idPatient=" + idPatient;
		Query query = em.createQuery(rq);
		query.executeUpdate();

	}

	public void validerRVPatient(int idPatient, int idService) {
		String rq = "UPDATE RendezVous rv SET rv.etat=2  WHERE rv.idPatient=" + idPatient + " and rv.idService="
				+ idService;
		Query query = em.createQuery(rq);
		query.executeUpdate();

	}

	public RendezVous rvConfirme(int idPatient) {
		String rq = "SELECT rv FROM RendezVous rv WHERE rv.idPatient =" + idPatient + " and rv.etat=1";
		Query query = em.createQuery(rq);
		RendezVous rv;
		try {
			rv = (RendezVous) query.getSingleResult();
		} catch (Exception e) {
			rv = null;
		}

		return rv;
	}

	public boolean verifRV(RendezVous rv) {
		boolean ok = false;
		String rq = "SELECT rv FROM RendezVous rv WHERE rv.idPatient=" + rv.getIdPatient() + " and rv.etat=0";
		Query query = em.createQuery(rq);
		RendezVous r;
		try {
			r = (RendezVous) query.getSingleResult();
		} catch (NoResultException e) {
			r = null;
		}
		if (r != null) {
			ok = true;
		}

		return ok;
	}

	public List<RendezVous> listRv(int idService) {
		String req = " SELECT rv FROM RendezVous rv WHERE rv.idService =" + idService + " and rv.etat=1";
		Query query = em.createQuery(req);
		@SuppressWarnings("unchecked")
		List<RendezVous> listeRV = query.getResultList();

		return listeRV;
	}
}
