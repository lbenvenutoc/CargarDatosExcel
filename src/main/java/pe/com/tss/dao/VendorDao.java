package pe.com.tss.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.tss.bean.Country;
import pe.com.tss.bean.Customer;
import pe.com.tss.bean.Vendor;
import pe.com.tss.util.JPAUtil;

public class VendorDao {
	
	public boolean exitsVendor(String code, String name, String vendortype) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Vendor.exitsVendor");
		emquery.setParameter("code", code);
		emquery.setParameter("name", name);
		emquery.setParameter("vendortype", vendortype);		
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		// em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean exitsVendorCode(String code) {
		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Vendor.exitsVendorCode");
		emquery.setParameter("code", code);		
		long r = 0;
		boolean resultado = false;
		r = (long) emquery.getSingleResult();
		// em.close();
		if (r > 0) {
			resultado = true;
		}
		return resultado;
	}
	
	public Vendor getVendor(String code) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Vendor.getVendor");
		emquery.setParameter("code", code);
		if (!emquery.getResultList().isEmpty()) {
			return (Vendor) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public Vendor getVendorName(String name) {

		EntityManager em = JPAUtil.getEntityManager();
		Query emquery = em.createNamedQuery("Vendor.getVendorName");
		emquery.setParameter("name", name);
		if (!emquery.getResultList().isEmpty()) {
			return (Vendor) emquery.getSingleResult();
		} else {
			return null;
		}

	}
	
	public void registrar(Vendor vendor) {

		EntityManager em = JPAUtil.getEntityManager();		
		em.getTransaction().begin();
		em.persist(vendor);
		em.getTransaction().commit();		

	}

}
