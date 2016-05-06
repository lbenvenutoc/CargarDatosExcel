package pe.com.tss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.City;
import pe.com.tss.bean.State;
import pe.com.tss.util.JPAUtil;

public class CityDao {

	public List<City> findByName(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("City.findByName");
		emquery.setParameter("name", name);
		List<City> cityList = emquery.getResultList();
		// em.close();
		return cityList;

	}

	public boolean existCity(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("City.exitsCity");
		emquery.setParameter("name", name);
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		// em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;

	}

	public void registrar(City city) {

		EntityManager em = JPAUtil.getEntityManager();
		// try {
		em.getTransaction().begin();
		em.persist(city);
		em.getTransaction().commit();
		// em.close();
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }

	}

	public City getCity(String name) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("City.getCity");
		emquery.setParameter("name", name);
		if (!emquery.getResultList().isEmpty()) {
			return (City) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
