package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Office;
import pe.com.tss.bean.User;
import pe.com.tss.util.JPAUtil;

public class OfficeDao {

	public void registrar(Office office) {

		EntityManager em = JPAUtil.getEntityManager();
		// try{
		em.getTransaction().begin();
		em.persist(office);
		em.getTransaction().commit();
		// em.close();
		// }catch(Exception ex){
		// System.out.println(ex.getMessage());
		// }

	}

	public Office findByOfficeName(String officename) {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createNamedQuery("Office.findByOfficeName");
		q.setParameter("officename", officename);
		if (!q.getResultList().isEmpty()) {
			return (Office) q.getSingleResult();
		} else {
			return null;
		}

	}

}
