package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.RampArea;
import pe.com.tss.bean.State;
import pe.com.tss.util.JPAUtil;

public class RampAreaDao {

	public void registrar(RampArea ramparea) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(ramparea);
		em.getTransaction().commit();

	}

	public boolean exitsRampArea(String name, String country, String state, String city) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("RampArea.exitsRampArea");
		emquery.setParameter("name", name);
		emquery.setParameter("country", country);
		emquery.setParameter("state", state);
		emquery.setParameter("city", city);
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		// em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;

	}

	public RampArea getRampArea(String name, String country, String state, String city) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("RampArea.getRampArea");
		emquery.setParameter("name", name);
		emquery.setParameter("country", country);
		emquery.setParameter("state", state);
		emquery.setParameter("city", city);
		if (!emquery.getResultList().isEmpty()) {
			return (RampArea) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
