package pe.com.tss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Country;
import pe.com.tss.bean.Office;
import pe.com.tss.util.JPAUtil;

public class CountryDao {

	public List<Country> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createQuery("SELECT c FROM Country c");
		List<Country> countryList = emquery.getResultList();
		// em.close();
		return countryList;

	}

	public boolean exitsCountry(String abbreviation) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Country.exitsCountry");
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
	
	public Country getCountry(String abbreviation){
		
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Country.getCountry");
		emquery.setParameter("abbreviation", abbreviation);
		if(!emquery.getResultList().isEmpty()){
			return (Country)emquery.getSingleResult();
		}else{
			return null;
		}
		
		
	}

	public void registrar(Country country) {

		EntityManager em = JPAUtil.getEntityManager();
		// try {
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
		// em.close();
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }

	}

}
