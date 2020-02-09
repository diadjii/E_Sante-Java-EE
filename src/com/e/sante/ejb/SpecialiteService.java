package com.e.sante.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Service;

@Stateless
public class SpecialiteService {
	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public void addSpecialite(Service service) {
		em.persist(service);
	}

	public List<Service> getAllService() {
		Query query = em.createQuery("SELECT s FROM Service s");
		@SuppressWarnings("unchecked")
		List<Service> services = query.getResultList();

		return services;
	}

	public Service findService(int idService) {
		Query query = em.createQuery("SELECT s FROM Service s WHERE s.id=" + idService);
		Service service = (Service) query.getSingleResult();

		return service;
	}
}
