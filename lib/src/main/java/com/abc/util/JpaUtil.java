package com.abc.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;
	static {
	    try {
	        entityManagerFactory = Persistence.createEntityManagerFactory("CAP-DB");
	    } catch (Throwable ex) {
	        System.err.println("EntityManagerFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
	}

	public static EntityManagerFactory getEntityManagerFactory() {
	    return entityManagerFactory;
	}
	public static void closeEntityManagerFactory() {
		if(entityManagerFactory != null && entityManagerFactory.isOpen())
			entityManagerFactory.close();
	}
}
