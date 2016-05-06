package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.com.tss.bean.Customer;
import pe.com.tss.util.JPAUtil;

public class CustomerDao {

	public void registrar(Customer customer) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();

	}

	public Customer getCustomer(String code) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Customer.getCustomer");
		emquery.setParameter("code", code);
		if (!emquery.getResultList().isEmpty()) {
			return (Customer) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public Customer getCustomerName(String customername) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Customer.getCustomerName");
		emquery.setParameter("customername", customername);
		if (!emquery.getResultList().isEmpty()) {
			return (Customer) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public boolean exitsCustomer(String code) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Customer.existCustomer");
		emquery.setParameter("code", code);		
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();		
		if (r > 0) {
			resultado = true;
		}
		return resultado;
	}

}
