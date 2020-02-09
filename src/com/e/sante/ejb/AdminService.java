package com.e.sante.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.e.sante.bean.Admin;

@Stateless
public class AdminService {

	@PersistenceContext(unitName = "e_sante")
	private EntityManager em;

	public Admin find(String login) {
		Query req = em.createQuery("SELECT a FROM Admin a WHERE a.login like '" + login + "'");
		Admin admin = new Admin();
		try {
			admin = (Admin) req.getSingleResult();
		} catch (NoResultException e) {
			admin = null;
		}
		return admin;
	}
}
