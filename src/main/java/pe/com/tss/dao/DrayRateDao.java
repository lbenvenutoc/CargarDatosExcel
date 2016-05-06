package pe.com.tss.dao;

import javax.persistence.EntityManager;
import pe.com.tss.bean.DrayRate;
import pe.com.tss.util.JPAUtil;

public class DrayRateDao {
	
	public void registrar(DrayRate drayrate) {

		EntityManager em = JPAUtil.getEntityManager();		
		em.getTransaction().begin();
		em.persist(drayrate);
		em.getTransaction().commit();
		

	}

}
