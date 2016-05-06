/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.tss.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author josediaz
 */

/**
 *
 * @author josediaz
 */
public class JPAUtil {
	
    private static final String PERSISTENCE_UNIT_NAME = "CargaDatosExcelPU";
    private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();
    private static EntityManagerFactory factory;

    private JPAUtil() {
    }

    public static EntityManager getEntityManager() {
        if (JPAUtil.factory == null) {
            JPAUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        EntityManager m = JPAUtil.manager.get();
        if (m == null) {
            m = JPAUtil.factory.createEntityManager();
            JPAUtil.manager.set(m);
        }
        return m;
    }


    public static void closeEntityManager() {
        EntityManager m = JPAUtil.manager.get();
        if (m != null) {
            EntityTransaction t = m.getTransaction();
            if (t.isActive()) { // TODO
                // CoreLog.getInstance()
                // .getLog()
                // .warn("EntityManager contains an active transaction, commiting transaction");
                // t.commit();
            }
            m.flush();
            m.close();
            JPAUtil.manager.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        JPAUtil.factory.close();
    }
}