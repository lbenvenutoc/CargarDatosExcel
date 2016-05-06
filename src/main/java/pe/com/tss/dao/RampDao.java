package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Ramp;
import pe.com.tss.util.JPAUtil;

public class RampDao {
	
	public void registrar(Ramp ramp) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(ramp);
		em.getTransaction().commit();

	}
	
	public Ramp getRamp(String code, String name, String zipCode) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Ramp.getRamp");
		emquery.setParameter("code", code);
		emquery.setParameter("name", name);
		emquery.setParameter("zipCode", zipCode);		
		if (!emquery.getResultList().isEmpty()) {
			return (Ramp) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public Ramp getRampCode(String code) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Ramp.getRampCode");
		emquery.setParameter("code", code);			
		if (!emquery.getResultList().isEmpty()) {
			return (Ramp) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public boolean existRamp(String code) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Ramp.existRamp");
		emquery.setParameter("code", code);	
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();		
		if (r > 0) {
			resultado = true;
		}
		return resultado;

	}

}
