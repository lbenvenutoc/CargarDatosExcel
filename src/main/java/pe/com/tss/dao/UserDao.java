package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Ramp;
import pe.com.tss.bean.User;
import pe.com.tss.bean.UserOffice;
import pe.com.tss.bean.UserRole;
import pe.com.tss.util.JPAUtil;

public class UserDao {

	public void registrar(User user) {

		EntityManager em = JPAUtil.getEntityManager();
		// try {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		// em.close();
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }

	}

	public void registrarUserRole(UserRole userrole) {

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(userrole);
		em.getTransaction().commit();

	}

	public void registrarUserOffice(UserOffice useroffice) {

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(useroffice);
		em.getTransaction().commit();

	}
	
	public User getUser(String username) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("User.getUser");
		emquery.setParameter("username", username);		
		if (!emquery.getResultList().isEmpty()) {
			return (User) emquery.getSingleResult();
		} else {
			return null;
		}

	}


}
