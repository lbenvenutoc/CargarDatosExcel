package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Country;
import pe.com.tss.bean.State;
import pe.com.tss.util.JPAUtil;

public class StateDao {

	public boolean existState(String abbreviation) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("State.existState");
		emquery.setParameter("abbreviation", abbreviation);
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		// em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;

	}

	public void registrar(State state) {

		EntityManager em = JPAUtil.getEntityManager();
		// try {
		em.getTransaction().begin();
		em.persist(state);
		em.getTransaction().commit();
		// em.close();
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }

	}

	public State getState(String abbreviation) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("State.getState");
		emquery.setParameter("abbreviation", abbreviation);
		if (!emquery.getResultList().isEmpty()) {
			return (State) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
