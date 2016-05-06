package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Market;
import pe.com.tss.bean.RampArea;
import pe.com.tss.util.JPAUtil;

public class MarketDao {

	public void registrar(Market market) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(market);
		em.getTransaction().commit();

	}
	
	public Market getMarket(String name) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Market.getMarket");
		emquery.setParameter("name", name);		
		if (!emquery.getResultList().isEmpty()) {
			return (Market) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
