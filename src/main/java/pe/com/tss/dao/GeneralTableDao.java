package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Customer;
import pe.com.tss.bean.GeneralTable;
import pe.com.tss.util.JPAUtil;

public class GeneralTableDao {

	public boolean existGeneralTable(String value) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("GeneralTable.existGeneralTable");
		emquery.setParameter("value", value);
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		if (r > 0) {
			resultado = true;
		}
		return resultado;
	}

	public int getAll() {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("GeneralTable.getAll");
		int resultado = 0;		
		resultado = emquery.getResultList().size();
		return resultado;
	}

	public void registrar(GeneralTable generaltable) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(generaltable);
		em.getTransaction().commit();

	}
	
	public GeneralTable getGeneralTable(String code) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("GeneralTable.getGeneralTable");
		emquery.setParameter("code", code);
		if (!emquery.getResultList().isEmpty()) {
			return (GeneralTable) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
