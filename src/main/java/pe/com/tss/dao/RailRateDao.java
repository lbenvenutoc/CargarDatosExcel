package pe.com.tss.dao;

import javax.persistence.EntityManager;

import pe.com.tss.bean.RailRate;
import pe.com.tss.util.JPAUtil;

public class RailRateDao {
	
	public void registrar(RailRate railrate) {

		EntityManager em = JPAUtil.getEntityManager();		
		em.getTransaction().begin();
		em.persist(railrate);
		em.getTransaction().commit();
		

	}

}
