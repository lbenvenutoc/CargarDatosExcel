package pe.com.tss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.com.tss.bean.Role;
import pe.com.tss.util.JPAUtil;

public class RoleDao {

	public void registrar(Role role) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		//em.close();
	}

	public List<Role> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createQuery("SELECT r FROM Role r");
		List<Role> roleList = emquery.getResultList();
		//em.close();
		return roleList;
	}
	
	public Role findByRoleName(String rolename) {
		Role role = null;
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createNamedQuery("Role.findByRoleName");
		q.setParameter("rolename", rolename);
		role = (Role) q.getSingleResult();
		return role;
	}

}
