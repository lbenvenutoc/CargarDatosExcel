package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.State;
import pe.com.tss.bean.Zip;
import pe.com.tss.util.JPAUtil;

public class ZipDao {
	
	public boolean existsZip(String zipcode) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Zip.existsZip");
		emquery.setParameter("zipcode", zipcode);
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		//em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;

	}
	
	public void registrar(Zip zip) {

		EntityManager em = JPAUtil.getEntityManager();
		// try {
		em.getTransaction().begin();
		em.persist(zip);
		em.getTransaction().commit();
		// em.close();
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }

	}
	
	public Zip getZip(String zipcode) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Zip.getZip");
		emquery.setParameter("zipcode", zipcode);
		if (!emquery.getResultList().isEmpty()) {
			return (Zip) emquery.getSingleResult();
		} else {
			return null;
		}

	}

}
